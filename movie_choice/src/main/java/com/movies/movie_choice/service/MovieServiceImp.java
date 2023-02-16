package com.movies.movie_choice.service;

import java.util.List;
import java.util.Optional;

import com.movies.movie_choice.model.Movie;
import com.movies.movie_choice.service.*;
import com.movies.movie_choice.repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public class MovieServiceImp implements MovieService{

    @Autowired
    private Movie movieRepo;
    @Override
    public List<Movie> saveall(List<Movie> detailedLists) {
        return this.movieRepo.saveAll(detailedLists);
    }

    @Override
    public List<Movie> getall() {
        return this.movieRepo.findAll();
    }
}
