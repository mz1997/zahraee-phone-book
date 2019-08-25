package com.mz.phoneBook.dao;

import com.mz.phoneBook.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address , Integer> {
}
