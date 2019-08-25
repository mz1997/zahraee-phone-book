package com.mz.phoneBook.service.impl;

import com.mz.phoneBook.dao.PhoneBookRepository;
import com.mz.phoneBook.model.PhoneBook;
import com.mz.phoneBook.service.GenericService;
import com.mz.phoneBook.service.interfaces.IPhoneBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class PhoneBookService extends GenericService<PhoneBook , Integer> implements IPhoneBookService {


    @Autowired
    private PhoneBookRepository phoneBookRepository;

    @Override
    protected JpaRepository<PhoneBook, Integer> jpaRepository() {
        return phoneBookRepository;
    }

    @Override
    public void save(PhoneBook entity) {
        entity.setlUpdate(new Date());
        super.save(entity);
    }

    @Override
    public void edit(PhoneBook entity) {
        entity.setlUpdate(new Date());
        super.edit(entity);
    }
}
