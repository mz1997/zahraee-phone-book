package com.mz.phoneBook.controller;

import com.mz.phoneBook.model.Pagination;
import com.mz.phoneBook.model.PhoneBook;
import com.mz.phoneBook.service.interfaces.IPhoneBookService;
import com.mz.phoneBook.view.daoView.PhoneBookDao;
import com.mz.phoneBook.view.daoView.PhoneBookDaoView;
import com.mz.phoneBook.view.loadView.PhoneBookLoad;
import com.mz.phoneBook.view.pageView.PhoneBookPage;
import com.mz.phoneBook.view.postView.PhoneBookPost;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/phoneBook")
public class PhoneBookController {



    @Autowired
    private IPhoneBookService phoneBookService;

    @Autowired
    private Mapper mapper;

    //save:
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public void save(@RequestBody PhoneBookPost phoneBookPost) {
        PhoneBook phoneBook = mapper.map(phoneBookPost,PhoneBook.class);
        if (phoneBookPost.getId()!= null){
            throw new RuntimeException();
        }
        phoneBookService.save(phoneBook);
    }

    //edit:
    @RequestMapping(value = "/edit", method = RequestMethod.PUT)
    public void edit(@RequestBody PhoneBookPost phoneBookPost) {
        PhoneBook phoneBook= mapper.map(phoneBookPost ,PhoneBook.class);
        if (phoneBookPost.getId()== null){
            throw new RuntimeException();
        }
        phoneBookService.edit(phoneBook);
    }

    //load:
    @RequestMapping(value = "/load/{id}", method = RequestMethod.GET)
    public PhoneBookLoad load(@PathVariable Integer id) {
        return convert(phoneBookService.load(id));
    }

    //delete:
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Integer id) {
        phoneBookService.delete(id);
    }

    //get all
    @RequestMapping(value = "/getAllPhoneBook", method = RequestMethod.GET)
    public List<PhoneBookLoad> getAll() {
        List<PhoneBook> listPhoneBook = new ArrayList<PhoneBook>();
        listPhoneBook = phoneBookService.getAll();
        List<PhoneBookLoad> list =  new ArrayList<PhoneBookLoad>();
        for(PhoneBook phoneBookFor : listPhoneBook)
        {
            list.add(convert(phoneBookFor));
        }
        return list;
    }

    //search:
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public Pagination<PhoneBookLoad> search (@RequestBody(required = false) PhoneBookPage phoneBookPage){
        PhoneBook phoneBook =  mapper.map(phoneBookPage,PhoneBook.class);
        Page<PhoneBook> temps = phoneBookService.findAll(phoneBookPage.getPage(), phoneBookPage.getSize() , phoneBook);
        List<PhoneBook> listPhoneBook = temps.getContent();
        List<PhoneBookLoad> list =  new ArrayList<PhoneBookLoad>();
        for(PhoneBook phoneBookFor : listPhoneBook)
        {
            list.add(convert(phoneBookFor));
        }
        return new Pagination(temps.getTotalPages(),temps.getTotalElements(),temps.getSize(),temps.getNumber(),list);
    }

    //convert to loadView
    private PhoneBookLoad convert(PhoneBook phoneBook)
    {
        PhoneBookLoad retuenValue =  mapper.map(phoneBook ,PhoneBookLoad.class);
        return retuenValue;
    }

    @RequestMapping(value = "searchByFirstNameOrLastName" , method = RequestMethod.POST)
    public List<PhoneBookDao> searchByFirstNameOrLastName (@RequestParam String name){
        return phoneBookService.searchByFirstNameOrLastName(name);
    }


    @RequestMapping(value = "searchByCityName" , method = RequestMethod.POST)
    public List<PhoneBookDaoView> searchByCityName (@RequestParam String cityName){
        return phoneBookService.searchByCityName(cityName);
    }

    @RequestMapping(value = "searchByPhoneNumber" , method = RequestMethod.POST)
    public List<PhoneBookDao> searchByPhoneNumber (@RequestParam Long phoneNumber){
        return phoneBookService.searchByPhoneNumber(phoneNumber);
    }
}
