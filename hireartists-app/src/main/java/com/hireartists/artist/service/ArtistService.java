package com.hireartists.artist.service;


import com.hireartists.client.model.ArtistModel;
import com.hireartists.client.model.SignupModel;
import com.hireartists.domain.Artist;

/**
 * Created by prayagupd
 * on 7/12/15.
 */

public interface ArtistService {
    public Artist save(SignupModel artist);

    Artist getProfile(String username);
}
