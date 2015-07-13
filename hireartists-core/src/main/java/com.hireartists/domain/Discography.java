package com.hireartists.domain;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 * Created by prayagupd
 * on 7/12/15.
 */

@Entity
public class Discography extends AbstractEntity<Long>{

    private String title;

    @ManyToOne
    private Artist artist;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }
}
