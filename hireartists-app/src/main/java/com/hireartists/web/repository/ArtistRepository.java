package com.hireartists.web.repository;

import com.hireartists.domain.Artist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by prayagupd
 * on 7/12/15.
 */

@Repository
public interface ArtistRepository extends JpaRepository<Artist, Long>{
}
