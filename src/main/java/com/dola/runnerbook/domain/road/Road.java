package com.dola.runnerbook.domain.road;

import com.dola.runnerbook.domain.genre.Genre;

import javax.persistence.*;

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
}
