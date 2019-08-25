package com.mz.phoneBook.dao;

import com.mz.phoneBook.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends JpaRepository<City , Integer> {
}
