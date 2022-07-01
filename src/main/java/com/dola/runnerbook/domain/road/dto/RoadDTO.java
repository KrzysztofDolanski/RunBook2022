package com.dola.runnerbook.domain.road.dto;

import com.dola.runnerbook.domain.genre.Genre;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class RoadDTO {
    private Long id;
    private String name;
    private String city;
    private Integer length;
    private Genre genre;
    private boolean promoted;

    private String poster;

    private String description;

    public RoadDTO() {
    }

    public RoadDTO(Long id, String name, String city, Integer length, boolean promoted, String poster, String description) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.length = length;
        this.promoted = promoted;
        this.poster = poster;
        this.description = description;
    }

    public RoadDTO(Long id, String name, String city, Integer length, Genre genre, boolean promoted, String poster, String description) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.length = length;
        this.genre = genre;
        this.promoted = promoted;
        this.poster = poster;
        this.description = description;
    }

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
}

