package com.movies.movie_choice.service;

import com.movies.movie_choice.model.Movie;

import java.util.List;

public interface MovieService {
    List<Movie> saveall(List<Movie> detailedLists);
    List<Movie> getall();
}
