package com.brewery.brewery_demo.repository;

import com.brewery.brewery_demo.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;

import java.util.List;

public interface BeerRepository extends JpaRepository<Beer,Long> {


    @Query(nativeQuery = true,value = "Select beer_quantity from brewery where price=?1")
    Beer getBeerByQuantity(long price);

}
