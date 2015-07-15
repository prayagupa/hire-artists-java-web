package com.hireartists.client.model.mapper;

import com.hireartists.client.model.Profile;
import com.hireartists.domain.Artist;
import com.hireartists.domain.Event;

/**
 * Created by prayagupd on 7/14/15.
 */
public class ProfileMapper {
    public static Profile mapToModel(Artist artist){

        Profile profile = new Profile();
        profile.id = artist.getId();
        profile.displayName = artist.getDisplayName();

        for ( Event e : artist.getEvents() ) {
            System.out.println(e.getName());
        }
        return profile;
    }
}
