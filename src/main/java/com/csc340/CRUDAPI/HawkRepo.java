package com.csc340.CRUDAPI;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface HawkRepo extends JpaRepository<Hawk, Long> {

    List<Hawk> findHawksByOrigin (String origin);
   
    @Query(value = "select * from hawk where population >= ?1", nativeQuery = true)
    List<Hawk> findHawksByPopulation(int population);

    @Query(value = "select * from hawk where name like %?1%", nativeQuery = true)
    List<Hawk> findHawksByNameContaining(String name);
}

