package com.zcode.springrestserver.web.domain;

import javax.persistence.Entity;

/**
 * Created by prayagupd
 * on 7/11/15.
 */

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="Artist")
public class Artist extends AbstractEntity<Long>{

    private String displayName;
    private String artistType;

    @ManyToMany
    private List<Event> events = new ArrayList<Event>();

    @ManyToMany
    private List<Member> members = new ArrayList<Member>();

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }

    public List<Member> getMembers() {
        return members;
    }

    public void setMembers(List<Member> members) {
        this.members = members;
    }
}
