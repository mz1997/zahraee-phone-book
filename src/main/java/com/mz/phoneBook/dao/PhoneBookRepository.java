package com.mz.phoneBook.dao;

import com.mz.phoneBook.model.PhoneBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PhoneBookRepository  extends JpaRepository<PhoneBook , Integer> {


    @Query("select fName,lName,phone from PhoneBook where fName like %:name% or lName like %:name%")
    Object[] searchByFirstNameOrLastName (@Param("name") String name);
}
