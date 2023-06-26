package com.trabalho_final_progmov.podcastz.entities;

public class PlaylistItem {

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

  public String getImage() {
    return image;
  }

  public String getEnclosureType() {
    return enclosureType;
  }

  public String getEnclosureUrl() {
    return enclosureUrl;
  }
}
