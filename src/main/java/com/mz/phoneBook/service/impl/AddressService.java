package com.mz.phoneBook.service.impl;

import com.mz.phoneBook.dao.AddressRepository;
import com.mz.phoneBook.model.Address;
import com.mz.phoneBook.service.GenericService;
import com.mz.phoneBook.service.interfaces.IAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.Date;


@Service
public class AddressService extends GenericService<Address , Integer> implements IAddressService {


    @Autowired
    private AddressRepository addressRepository;

    @Override
    protected JpaRepository<Address, Integer> jpaRepository() {
        return addressRepository;
    }

    @Override
    public void save(Address entity) {
        entity.setlUpdate(new Date());
        super.save(entity);
    }

    @Override
    public void edit(Address entity) {
        entity.setlUpdate(new Date());
        super.edit(entity);
    }
}
