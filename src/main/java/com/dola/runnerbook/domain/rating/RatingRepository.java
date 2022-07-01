package com.dola.runnerbook.domain.rating;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RatingRepository extends JpaRepository<Rating, Long> {

    Optional<Rating> findByUser_EmailAndRoad_Id(String userEmail, Long roadId);
}
