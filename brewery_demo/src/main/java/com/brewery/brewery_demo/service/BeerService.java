package com.brewery.brewery_demo.service;
import com.brewery.brewery_demo.exception.BeerException;
import com.brewery.brewery_demo.model.*;
import java.util.List;
import java.util.Optional;

public interface BeerService {
    Beer createBeer(Beer beer);
    Beer updateBeer(Beer beer);
    List<Beer> getAllBeers();
    Beer getBeerByCode(long beerCode);
    Beer getBeerByQuantity(long price) throws BeerException;
    void deleteBeer(long beerCode);
}
