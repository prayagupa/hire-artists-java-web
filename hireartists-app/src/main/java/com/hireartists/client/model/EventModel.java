package com.hireartists.client.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by prayagupd on 7/14/15.
 */
public class EventModel implements Serializable {
    public Long id;
    public String name;
    public EventOrganiserModel organiser;
    public List<ArtistModel> artists = new ArrayList<ArtistModel>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public EventOrganiserModel getOrganiser() {
        return organiser;
    }

    public void setOrganiser(EventOrganiserModel organiser) {
        this.organiser = organiser;
    }

    public List<ArtistModel> getArtists() {
        return artists;
    }

    public void setArtists(List<ArtistModel> artists) {
        this.artists = artists;
    }
}
