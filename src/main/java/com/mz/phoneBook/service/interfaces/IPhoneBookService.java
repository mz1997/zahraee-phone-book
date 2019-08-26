package com.mz.phoneBook.service.interfaces;

import com.mz.phoneBook.model.PhoneBook;
import com.mz.phoneBook.view.daoView.PhoneBookDao;
import com.mz.phoneBook.view.daoView.PhoneBookDaoView;

import java.util.List;

public interface IPhoneBookService extends IGenericService<PhoneBook , Integer> {

    List<PhoneBookDao> searchByFirstNameOrLastName (String name);
    List<PhoneBookDaoView> searchByCityName (String cityName);

}
