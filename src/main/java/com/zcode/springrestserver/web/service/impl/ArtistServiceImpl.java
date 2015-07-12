package com.zcode.springrestserver.web.service.impl;

import com.zcode.springrestserver.web.domain.Artist;
import com.zcode.springrestserver.web.repository.ArtistRepository;
import com.zcode.springrestserver.web.service.ArtistService;
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
    public Artist save(Artist artist) {
        return artistRepository.save(artist);
    }
}
