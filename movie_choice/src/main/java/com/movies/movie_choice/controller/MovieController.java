package com.movies.movie_choice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movies.movie_choice.service.*;
import com.movies.movie_choice.repository.*;
import com.movies.movie_choice.model.*;
import com.movies.movie_choice.exception.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MovieController {
    @Autowired
    private MovieService service;



    @PostMapping("/addmovies")
    public List<Movie> saveAllMovies(){
        List<Movie> M1 =new ArrayList();
        M1.add(new Movie("Avatar", "SciFi", 600.00F));
        M1.add(new Movie("Suryavanshi", "Rubbish", 399.99F));
        M1.add(new Movie("Phir hera pheri", "Comedy", 200.50F));
        M1.add(new Movie("KGF", "Action Drama", 239.99F));
        M1.add(new Movie ("21st century girl", "don't know", 450.0F));
        M1.add(new Movie("Pathan", "Action", 100.50F));
        M1.add(new Movie("RRR", "action-drama", 800.0F));

        return this.service.saveall(M1);
    }


    @GetMapping("/moviesList")
    public List<Movie> getallmovies() {
        return this.service.getall();
    }


    @PostMapping("/rentmovie/{id}")
    public String rentmovie(@PathVariable int id) {
        return "movie renting done";



    }


}
