package com.mz.phoneBook.service.impl;

import com.mz.phoneBook.dao.PhoneBookRepository;
import com.mz.phoneBook.model.PhoneBook;
import com.mz.phoneBook.service.GenericService;
import com.mz.phoneBook.service.interfaces.IPhoneBookService;
import com.mz.phoneBook.view.daoView.PhoneBookDao;
import com.mz.phoneBook.view.daoView.PhoneBookDaoView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

    @Override
    public List<PhoneBookDao> searchByFirstNameOrLastName(String name) {
        List<PhoneBookDao> retValue = new ArrayList<PhoneBookDao>();
        Object[] temp = phoneBookRepository.searchByFirstNameOrLastName(name);
        for (Object ojb : temp){
            Object[] tem = (Object[]) ojb;
            PhoneBookDao phoneBookDao = new PhoneBookDao();
            phoneBookDao.setfName(tem[0].toString());
            phoneBookDao.setlName(tem[1].toString());
            phoneBookDao.setPhone((Long)tem[2]);
            retValue.add(phoneBookDao);
        }

        return retValue;
    }

    @Override
    public List<PhoneBookDaoView> searchByCityName(String cityName) {
        List<PhoneBookDaoView> retValue =new ArrayList<PhoneBookDaoView>();
        Object[] temp = phoneBookRepository.searchByCityName(cityName);
        for (Object ojb : temp){
            Object[] tem = (Object[]) ojb;
            PhoneBookDaoView phoneBookDaoView = new PhoneBookDaoView();
            phoneBookDaoView.setId(tem[0].hashCode());
            phoneBookDaoView.setfName(tem[1].toString());
            phoneBookDaoView.setlName(tem[2].toString());
            phoneBookDaoView.setPhone((Long)tem[3]);
            phoneBookDaoView.setMail(tem[4].toString());
            phoneBookDaoView.setAddressId(tem[5].hashCode());
            phoneBookDaoView.setAddress(tem[6].toString());
            phoneBookDaoView.setCityId(tem[7].hashCode());
            phoneBookDaoView.setCity(tem[8].toString());
            retValue.add(phoneBookDaoView);
        }


        return retValue;
    }
}
