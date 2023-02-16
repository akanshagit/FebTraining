package com.coffee.coffee_variety.service;

import com.coffee.coffee_variety.exception.CoffeeException;
import com.coffee.coffee_variety.model.Coffee;

import java.util.List;

public interface CoffeeService {

    void saveAllRecords();

    Coffee getDetails(String name) throws CoffeeException;

    List<String> getMenu();

    List<Coffee> getAllDetails();
}
