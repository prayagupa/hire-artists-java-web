package com.hireartists.client.model.mapper;

import com.hireartists.client.model.ArtistModel;
import com.hireartists.domain.Artist;

/**
 * Created by prayagupd
 * on 7/13/15.
 */

public class ArtistMapper {
    public static ArtistModel mapToModel(Artist artist) {
        ArtistModel model = new ArtistModel();
        model.displayName = artist.getDisplayName();
        return model;
    }
}
