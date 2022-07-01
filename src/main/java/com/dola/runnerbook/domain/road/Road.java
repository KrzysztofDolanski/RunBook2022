package com.dola.runnerbook.domain.road;

import com.dola.runnerbook.domain.genre.Genre;
import com.dola.runnerbook.domain.rating.Rating;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Road {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String city;
    private Integer length;
    @ManyToOne
    @JoinColumn(name = "genre_id", referencedColumnName = "id")
    private Genre genre;
    private boolean promoted;

    private String description;
    private String shortDescription;
    private String poster;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public Genre getGenre() {
        return genre;
    }

    @OneToMany(mappedBy = "road")
    private Set<Rating> ratings = new HashSet<>();

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public boolean isPromoted() {
        return promoted;
    }

    public void setPromoted(boolean promoted) {
        this.promoted = promoted;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {

        this.description = description;
    }

    public Set<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(Set<Rating> ratings) {
        this.ratings = ratings;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }
}
