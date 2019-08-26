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

    @Query("select p.id,p.fName,p.lName,p.phone,p.mail,p.address.id,p.address.address,p.address.city.id,p.address.city.name from PhoneBook p where p.address.id in (select a.id from p.address a where a.city.id in (select c.id from p.address.city c where c.name like %:cityName%))")
    Object[] searchByCityName(@Param("cityName") String cityName);
}
