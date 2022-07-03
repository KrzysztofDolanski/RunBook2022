package com.dola.runnerbook.domain.road;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoadRepository extends CrudRepository<Road, Long> {

    List<Road> findAllByPromotedIsTrue();

    List<Road> findAllByGenre_NameIgnoreCase(String genre);

    @Query("select r from Road r join r.ratings z group by r order by avg(z.rating) desc")
    List<Road> findTopByRating(Pageable page);
}
