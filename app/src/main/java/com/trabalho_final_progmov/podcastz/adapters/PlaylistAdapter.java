package com.trabalho_final_progmov.podcastz.adapters;

import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.squareup.picasso.Picasso;
import com.trabalho_final_progmov.podcastz.R;
import com.trabalho_final_progmov.podcastz.entities.PlaylistItem;
import java.io.IOException;
import java.util.List;

public class PlaylistAdapter
  extends RecyclerView.Adapter<PlaylistAdapter.PlaylistViewHolder> {

  private List<PlaylistItem> items;
  private MediaPlayer mediaPlayer;

  public PlaylistAdapter(List<PlaylistItem> items) {
    this.items = items;
    mediaPlayer = new MediaPlayer();
  }

  @NonNull
  @Override
  public PlaylistViewHolder onCreateViewHolder(
    @NonNull ViewGroup parent,
    int viewType
  ) {
    View view = LayoutInflater
      .from(parent.getContext())
      .inflate(R.layout.adapter_playlist, parent, false);
    return new PlaylistViewHolder(view);
  }

  @Override
  public void onBindViewHolder(
    @NonNull PlaylistViewHolder holder,
    int position
  ) {
    PlaylistItem item = items.get(position);

    holder.titleTextView.setText(item.getTitle());
    holder.descriptionTextView.setText(item.getDescription());

    if (item.getImage() != null && !item.getImage().isEmpty()) {
      Picasso.get().load(item.getImage()).into(holder.imageView);
    } else {
      Picasso.get().load(R.drawable.podcast_logo).into(holder.imageView);
    }

    holder.playPauseButton.setOnClickListener(
      new View.OnClickListener() {
        @Override
        public void onClick(View v) {
          if (mediaPlayer.isPlaying()) {
            mediaPlayer.pause();
            holder.playPauseButton.setImageResource(
              android.R.drawable.ic_media_play
            );
          } else {
            try {
              mediaPlayer.reset();
              mediaPlayer.setDataSource(item.getEnclosureUrl());
              mediaPlayer.prepare();
              mediaPlayer.setVolume(1.0f, 1.0f);
              mediaPlayer.start();
              holder.playPauseButton.setImageResource(
                android.R.drawable.ic_media_pause
              );
            } catch (IOException e) {
              e.printStackTrace();
            }
          }
        }
      }
    );
  }

  @Override
  public int getItemCount() {
    return items.size();
  }

  public static class PlaylistViewHolder extends RecyclerView.ViewHolder {

    TextView titleTextView;
    TextView descriptionTextView;
    ImageView imageView;
    ImageButton playPauseButton;

    public PlaylistViewHolder(View itemView) {
      super(itemView);
      titleTextView = itemView.findViewById(R.id.titleTextView);
      descriptionTextView = itemView.findViewById(R.id.descriptionTextView);
      imageView = itemView.findViewById(R.id.coverImageView);
      playPauseButton = itemView.findViewById(R.id.playPauseButton);
    }
  }
}
