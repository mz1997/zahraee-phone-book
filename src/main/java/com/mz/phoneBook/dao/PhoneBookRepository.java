package com.mz.phoneBook.dao;

import com.mz.phoneBook.model.PhoneBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhoneBookRepository  extends JpaRepository<PhoneBook , Integer> {
}
