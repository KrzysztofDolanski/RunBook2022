package com.dola.runnerbook.domain.road;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoadRepository extends CrudRepository<Road, Long> {

    List<Road> findAllByPromotedIsTrue();

    List<Road> findAllByGenre_NameIgnoreCase(String genre);
}
