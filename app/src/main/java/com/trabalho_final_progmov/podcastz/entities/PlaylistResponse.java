package com.trabalho_final_progmov.podcastz.entities;

import java.util.List;

public class PlaylistResponse {
    private boolean status;
    private List<PlaylistItem> items;
    private int count;
    private String max;
    private String description;

    public List<PlaylistItem> getItems() {
        return items;
    }
}