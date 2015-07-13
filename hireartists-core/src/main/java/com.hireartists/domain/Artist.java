package com.hireartists.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by prayagupd
 * on 7/11/15.
 */

@Entity
@Table(name="Artist")
public class Artist extends AbstractEntity<Long>{

    private String displayName;

    @Enumerated
    private ArtistType artistType = ArtistType.SOLO;

    @ManyToMany
    private List<Event> events = new ArrayList<Event>();

    @ManyToMany
    private List<Member> members = new ArrayList<Member>();

    @OneToMany(mappedBy = "artist")
    private List<Discography> discographies = new ArrayList<Discography>();

    @OneToOne
    private User user;

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ArtistType getArtistType() {
        return artistType;
    }

    public void setArtistType(ArtistType artistType) {
        this.artistType = artistType;
    }
}
