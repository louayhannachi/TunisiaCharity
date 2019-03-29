/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.entities;

import java.util.Date;

/**
 *
 * @author lhannachi
 */
public class Events {
    private int id_event;
    private int id_user;
    private int id_categorie;
    private String title;
    private Date event_date;
    private String description;
    private String location;
    private String video_url;
    private String image_url;
    private Double longitude;
    private Double latitude;

    public Events() {
    }

    public Events(int id_event, int id_user, int id_categorie, String title, Date event_date, String description, String location, String video_url, String image_url, Double longitude, Double latitude) {
        this.id_event = id_event;
        this.id_user = id_user;
        this.id_categorie = id_categorie;
        this.title = title;
        this.event_date = event_date;
        this.description = description;
        this.location = location;
        this.video_url = video_url;
        this.image_url = image_url;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    
    
    
    public int getId_event() {
        return id_event;
    }

    public void setId_event(int id_event) {
        this.id_event = id_event;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public int getId_categorie() {
        return id_categorie;
    }

    public void setId_categorie(int id_categorie) {
        this.id_categorie = id_categorie;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getEvent_date() {
        return event_date;
    }

    public void setEvent_date(Date event_date) {
        this.event_date = event_date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getVideo_url() {
        return video_url;
    }

    public void setVideo_url(String video_url) {
        this.video_url = video_url;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    @Override
    public String toString() {
        return "Events{" + "id_event=" + id_event + ", id_user=" + id_user + ", id_categorie=" + id_categorie + ", title=" + title + ", event_date=" + event_date + ", description=" + description + ", location=" + location + ", video_url=" + video_url + ", image_url=" + image_url + ", longitude=" + longitude + ", latitude=" + latitude + '}';
    }
    
    
    
}
