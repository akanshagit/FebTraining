package com.coffee.coffee_variety.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.coffee.coffee_variety.model.*;

@Repository
public interface CoffeeRepository extends JpaRepository<Coffee,Integer> {
    @Query(nativeQuery = true,value = "select * from coffee where coffee_name=?1")
    Coffee findByName(String name);
}