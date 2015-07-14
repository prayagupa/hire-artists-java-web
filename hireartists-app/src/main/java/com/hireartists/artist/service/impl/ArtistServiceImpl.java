package com.hireartists.artist.service.impl;

import com.hireartists.artist.repository.ArtistRepository;
import com.hireartists.client.model.ArtistModel;
import com.hireartists.client.model.SignupModel;
import com.hireartists.domain.Artist;
import com.hireartists.artist.service.ArtistService;
import com.hireartists.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by prayagupd
 * on 7/12/15.
 */

@Service
public class ArtistServiceImpl implements ArtistService{

    @Autowired
    ArtistRepository artistRepository;

    public ArtistServiceImpl(){

    }

    @Override
    public Artist save(SignupModel signupModel) {
        Artist artist = new Artist();
        artist.setDisplayName(signupModel.displayName);

        User user = new User();
        user.setUserName(signupModel.username);
        user.setPassword(signupModel.password);

        return artistRepository.save(artist);
    }
}
