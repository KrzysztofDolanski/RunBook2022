package com.dola.runnerbook.domain.rating;

import com.dola.runnerbook.domain.road.Road;
import com.dola.runnerbook.domain.user.User;

import javax.persistence.*;

@Entity
@Table(name = "road_rating")
public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "road_id")
    private Road road;
    private Integer rating;

    public Rating() {
    }

    public Rating(User user, Road road, Integer rating) {
        this.user = user;
        this.road = road;
        this.rating = rating;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Road getRoad() {
        return road;
    }

    public void setRoad(Road road) {
        this.road = road;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }
}
