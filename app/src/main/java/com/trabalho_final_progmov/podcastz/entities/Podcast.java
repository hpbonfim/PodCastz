package com.trabalho_final_progmov.podcastz.entities;

import java.util.List;

public class Podcast {

  public static class Root {

    private String status;
    private List<Item> items;
    private int count;
    private String max;
    private String description;

    public List<Item> getItems() {
      return items;
    }
  }

  public static class Item {

    private long id;
    private String title;
    private String link;
    private String description;
    private String guid;
    private long datePublished;
    private String datePublishedPretty;
    private long dateCrawled;
    private String enclosureUrl;
    private String enclosureType;
    private long enclosureLength;
    private int explicit;
    private Object episode;
    private String episodeType;
    private int season;
    private String image;
    private long feedItunesId;
    private String feedImage;
    private long feedId;
    private String feedTitle;
    private String feedLanguage;

    public String getTitle() {
      return title;
    }

    public String getDescription() {
      return description;
    }

  }
}
