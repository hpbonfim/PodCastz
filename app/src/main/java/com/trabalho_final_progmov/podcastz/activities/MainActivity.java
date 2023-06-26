package com.trabalho_final_progmov.podcastz.activities;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.gson.Gson;
import com.trabalho_final_progmov.podcastz.R;
import com.trabalho_final_progmov.podcastz.adapters.PlaylistAdapter;
import com.trabalho_final_progmov.podcastz.entities.PlaylistItem;
import com.trabalho_final_progmov.podcastz.entities.PlaylistResponse;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

  private static final String API_URL =
    "https://api.podcastindex.org/api/1.0/recent/episodes?max=5";
  private static final String API_KEY = "6MEGVQUKHU2FV6TRWSGZ";
  private static final String API_SECRET =
    "H5A3ejkrdF28LUDKL8SdQ6Q8afDR6TZVe534XfGn";
  private PlaylistAdapter adapter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setupAdapter();
    setContentView(R.layout.activity_main);

    RecyclerView recyclerView = findViewById(R.id.recyclerView);
    recyclerView.setLayoutManager(new LinearLayoutManager(this));
    recyclerView.setAdapter(adapter);
  }

  private void setupAdapter() {
    OkHttpClient client = new OkHttpClient();

    String unixTime = String.valueOf(System.currentTimeMillis() / 1000L);
    String authString = API_KEY + API_SECRET + unixTime;
    String authHash = "";

    try {
      MessageDigest md = MessageDigest.getInstance("SHA-1");
      md.update(authString.getBytes(StandardCharsets.UTF_8));
      byte[] digest = md.digest();
      authHash = String.format("%040x", new BigInteger(1, digest));
    } catch (NoSuchAlgorithmException e) {
      e.printStackTrace();
    }

    Request request = new Request.Builder()
      .url(API_URL)
      .addHeader("X-Auth-Date", unixTime)
      .addHeader("X-Auth-Key", API_KEY)
      .addHeader("Authorization", authHash)
      .build();
    client
      .newCall(request)
      .enqueue(
        new okhttp3.Callback() {
          @Override
          public void onFailure(okhttp3.Call call, IOException e) {
            e.printStackTrace();
          }

          @Override
          public void onResponse(okhttp3.Call call, okhttp3.Response response)
            throws IOException {
            if (!response.isSuccessful()) {
              throw new IOException("Unexpected code " + response);
            } else {
              Gson gson = new Gson();
              PlaylistResponse playlist = gson.fromJson(
                response.body().string(),
                PlaylistResponse.class
              );
              List<PlaylistItem> items = playlist.getItems();

              // DEBUG LIST
              for (PlaylistItem item : items) {
                System.out.println(item.getTitle());
              }

              adapter =
                new PlaylistAdapter(playlist.getItems(), MainActivity.this);

              runOnUiThread(
                new Runnable() {
                  @Override
                  public void run() {
                    RecyclerView recyclerView = findViewById(R.id.recyclerView);
                    recyclerView.setLayoutManager(
                      new LinearLayoutManager(MainActivity.this)
                    );
                    recyclerView.setAdapter(adapter);
                  }
                }
              );
            }
          }
        }
      );
  }
}
