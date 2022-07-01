package com.dola.runnerbook.domain.rating;

import com.dola.runnerbook.domain.road.Road;
import com.dola.runnerbook.domain.road.RoadRepository;
import com.dola.runnerbook.domain.user.User;
import com.dola.runnerbook.domain.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RatingService {

    private final RatingRepository ratingRepository;
    private final UserRepository userRepository;
    private final RoadRepository roadRepository;

    @Autowired
    public RatingService(RatingRepository ratingRepository, UserRepository userRepository, RoadRepository roadRepository) {
        this.ratingRepository = ratingRepository;
        this.userRepository = userRepository;
        this.roadRepository = roadRepository;
    }

    public void addOrUpdateRating(String userEmail, long roadId, int rating) {
        Rating ratingToSaveOrUpdate = ratingRepository.findByUser_EmailAndMovie_Id(userEmail, roadId)
                .orElseGet(Rating::new);
        User user = userRepository.findByEmail(userEmail).orElseThrow();
        Road road = roadRepository.findById(roadId).orElseThrow();
        ratingToSaveOrUpdate.setUser(user);
        ratingToSaveOrUpdate.setRoad(road);
        ratingToSaveOrUpdate.setRating(rating);
        ratingRepository.save(ratingToSaveOrUpdate);
    }

    public Optional<Integer> getUserRatingForMovie(String userEmail, long roadId) {
        return ratingRepository.findByUser_EmailAndMovie_Id(userEmail, roadId)
                .map(Rating::getRating);
    }
}
