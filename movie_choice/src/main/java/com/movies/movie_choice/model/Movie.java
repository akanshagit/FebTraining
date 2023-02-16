package com.movies.movie_choice.model;

import jakarta.persistence.*;

@Entity
@Table(name="movies")

public class Movie{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private float price;
    private String genre;
    public int getId() {

        return id;
    }
    public void setId(int id) {

        this.id = id;
    }
    public String getName() {

        return name;
    }
    public void setName(String name) {

        this.name = name;
    }
    public float getPrice() {
        return price;
    }
    public void setPrice(float price) {
        this.price = price;
    }
    public String getGenre() {
        return genre;
    }
    public void setGenre(String genre) {
        this.genre = genre;
    }



    public Movie(String name, String genre , float price) {
        super();
        //this.id = id;
        this.name = name;
        this.price = price;
        this.genre = genre;
    }


    public Movie() {
        super();
        // TODO Auto-generated constructor stub
    }


    @Override
    public String toString() {
        return "MovieCatalog [id=" + id + ", name=" + name + ", price=" + price + ", genre=" + genre + "]";
    }




}
