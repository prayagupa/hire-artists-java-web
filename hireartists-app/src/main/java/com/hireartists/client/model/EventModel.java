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
}
