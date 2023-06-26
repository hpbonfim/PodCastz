package com.trabalho_final_progmov.podcastz.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.squareup.picasso.Picasso;
import com.trabalho_final_progmov.podcastz.R;
import com.trabalho_final_progmov.podcastz.entities.PlaylistItem;
import java.util.List;

public class PlaylistAdapter
  extends RecyclerView.Adapter<PlaylistAdapter.PlaylistViewHolder> {

  private List<PlaylistItem> items;

  public PlaylistAdapter(List<PlaylistItem> items) {
    this.items = items;
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
  }

  @Override
  public int getItemCount() {
    return items.size();
  }

  public static class PlaylistViewHolder extends RecyclerView.ViewHolder {

    TextView titleTextView;
    TextView descriptionTextView;
    ImageView imageView;

    public PlaylistViewHolder(View itemView) {
      super(itemView);
      titleTextView = itemView.findViewById(R.id.titleTextView);
      descriptionTextView = itemView.findViewById(R.id.descriptionTextView);
      imageView = itemView.findViewById(R.id.coverImageView);
    }
  }
}
