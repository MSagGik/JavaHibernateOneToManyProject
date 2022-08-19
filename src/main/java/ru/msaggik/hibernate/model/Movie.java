package ru.msaggik.hibernate.model;

import javax.persistence.*;

@Entity
@Table(name = "Movie")
public class Movie {
    @Id
    @Column(name = "movie_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int movie_id;

    @Column(name = "name")
    private String name;

    @Column(name = "year_of_production")
    private int year_of_production;

    /// выстраивание связи многие ко одному
    @ManyToOne
    @JoinColumn(name = "director_id", referencedColumnName = "director_id")
    private Director owner;

    public Director getOwner() {
        return owner;
    }

    public void setOwner(Director owner) {
        this.owner = owner;
    }

///


    public Movie() {
    }

    public Movie(String name, int year_of_production, Director owner) {
        this.name = name;
        this.year_of_production = year_of_production;
        this.owner = owner;
    }

    public int getYear_of_production() {
        return year_of_production;
    }

    public void setYear_of_production(int year_of_production) {
        this.year_of_production = year_of_production;
    }

    public int getMovie_id() {
        return movie_id;
    }

    public void setMovie_id(int movie_id) {
        this.movie_id = movie_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "movie_id=" + movie_id +
                ", name='" + name + '\'' +
                ", year_of_production='" + year_of_production + '\'' +
                ", owner=" + owner +
                '}';
    }
}
