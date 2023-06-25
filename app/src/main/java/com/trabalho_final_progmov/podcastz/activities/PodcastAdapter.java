package com.trabalho_final_progmov.podcastz.activities;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.trabalho_final_progmov.podcastz.R;
import com.trabalho_final_progmov.podcastz.entities.Podcast;
import java.util.List;

public class PodcastAdapter
  extends RecyclerView.Adapter<PodcastAdapter.PodcastViewHolder> {

  private List<Podcast.Item> items;

  public PodcastAdapter(List<Podcast.Item> items) {
    this.items = items;
  }

  @Override
  public PodcastViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View view = LayoutInflater
      .from(parent.getContext())
      .inflate(R.layout.item_podcast, parent, false);
    return new PodcastViewHolder(view);
  }

  @Override
  public void onBindViewHolder(PodcastViewHolder holder, int position) {
    Podcast.Item item = items.get(position);
    holder.titleTextView.setText(item.getTitle());
    holder.descriptionTextView.setText(item.getDescription());
  }

  @Override
  public int getItemCount() {
    return items.size();
  }

  public static class PodcastViewHolder extends RecyclerView.ViewHolder {

    TextView titleTextView;
    TextView descriptionTextView;

    public PodcastViewHolder(View itemView) {
      super(itemView);
      titleTextView = itemView.findViewById(R.id.titleTextView);
      descriptionTextView = itemView.findViewById(R.id.descriptionTextView);
    }
  }
}
