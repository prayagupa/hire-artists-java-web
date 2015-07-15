package com.hireartists.client.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by prayagupd
 * on 7/14/15.
 */

public class Profile implements Serializable {
    public Long id;
    public String displayName;
    public List<EventModel> events;

    static class EventModel {
        private Long id;
        private String name;
    }

}
