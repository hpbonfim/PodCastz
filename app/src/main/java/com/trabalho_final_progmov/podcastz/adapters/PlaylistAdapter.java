package com.trabalho_final_progmov.podcastz.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.trabalho_final_progmov.podcastz.R;
import com.trabalho_final_progmov.podcastz.entities.PlaylistItem;
import java.util.List;

public class PlaylistAdapter
  extends RecyclerView.Adapter<PlaylistAdapter.PlaylistViewHolder> {

  private List<PlaylistItem> items;

  public PlaylistAdapter(List<PlaylistItem> items) {
    this.items = items;
  }

  @Override
  public PlaylistViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View view = LayoutInflater
      .from(parent.getContext())
      .inflate(R.layout.adapter_playlist, parent, false);
    return new PlaylistViewHolder(view);
  }

  @Override
  public void onBindViewHolder(PlaylistViewHolder holder, int position) {
    PlaylistItem item = items.get(position);
    holder.titleTextView.setText(item.getTitle());
    holder.descriptionTextView.setText(item.getDescription());
    System.out.println(item);
    // holder.linkButton.setOnClickListener(v -> {
    // Action to open the link in a browser or a media player
    //});
  }

  @Override
  public int getItemCount() {
    return items.size();
  }

  public static class PlaylistViewHolder extends RecyclerView.ViewHolder {

    TextView titleTextView;
    TextView descriptionTextView;
    ImageView imageView;
    Button linkButton;

    public PlaylistViewHolder(View itemView) {
      super(itemView);
      titleTextView = itemView.findViewById(R.id.titleTextView);
      descriptionTextView = itemView.findViewById(R.id.descriptionTextView);
      // imageView = itemView.findViewById(R.id.imageView);
      // linkButton = itemView.findViewById(R.id.linkButton);
    }
  }
}
