package com.dola.runnerbook.domain.road;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoadRepository extends JpaRepository<Road, Long> {

    List<Road> findAllByPromotedIsTrue();
}
