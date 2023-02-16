package com.movies.movie_choice.repository;

import com.movies.movie_choice.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie,Integer> {

}
