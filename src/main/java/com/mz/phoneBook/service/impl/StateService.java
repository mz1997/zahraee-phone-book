package com.mz.phoneBook.service.impl;

import com.mz.phoneBook.dao.StateRepository;
import com.mz.phoneBook.model.State;
import com.mz.phoneBook.service.GenericService;
import com.mz.phoneBook.service.interfaces.IStateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class StateService extends GenericService <State , Integer> implements IStateService {


    @Autowired
    private StateRepository stateRepository;

    @Override
    protected JpaRepository<State, Integer> jpaRepository() {

        return stateRepository;
    }

    @Override
    public void save(State entity) {
        entity.setlUpdate(new Date());
        super.save(entity);
    }

    @Override
    public void edit(State entity) {
        entity.setlUpdate(new Date());
        super.edit(entity);
    }
}
