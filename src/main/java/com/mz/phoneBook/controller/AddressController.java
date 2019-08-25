package com.mz.phoneBook.controller;


import com.mz.phoneBook.model.Address;
import com.mz.phoneBook.model.Pagination;
import com.mz.phoneBook.service.interfaces.IAddressService;
import com.mz.phoneBook.view.loadView.AddressLoad;
import com.mz.phoneBook.view.pageView.AddressPage;
import com.mz.phoneBook.view.postView.AddressPost;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/address")
public class AddressController {


    @Autowired
    private IAddressService addressService;

    @Autowired
    private Mapper mapper;

    //save:
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public void save(@RequestBody AddressPost addressPost) {
        Address address = mapper.map(addressPost,Address.class);
        if (addressPost.getId()!= null){
            throw new RuntimeException();
        }
        addressService.save(address);
    }

    //edit:
    @RequestMapping(value = "/edit", method = RequestMethod.PUT)
    public void edit(@RequestBody AddressPost addressPost) {
        Address address = mapper.map(addressPost ,Address.class);
        if (addressPost.getId()== null){
            throw new RuntimeException();
        }
        addressService.edit(address);
    }

    //load:
    @RequestMapping(value = "/load/{id}", method = RequestMethod.GET)
    public AddressLoad load(@PathVariable Integer id) {
        return convert(addressService.load(id));
    }

    //delete:
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Integer id) {
        addressService.delete(id);
    }

    //get all
    @RequestMapping(value = "/getAllAddress", method = RequestMethod.GET)
    public List<AddressLoad> getAll() {
        List<Address> listAddress = new ArrayList<Address>();
        listAddress = addressService.getAll();
        List<AddressLoad> list =  new ArrayList<AddressLoad>();
        for(Address addressFor : listAddress)
        {
            list.add(convert(addressFor));
        }
        return list;
    }

    //search:
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public Pagination<AddressLoad> search (@RequestBody(required = false) AddressPage addressPage){
        Address address =  mapper.map(addressPage ,Address.class);
        Page<Address> temps = addressService.findAll(addressPage.getPage(), addressPage.getSize() , address);
        List<Address> listAddress = temps.getContent();
        List<AddressLoad> list =  new ArrayList<AddressLoad>();
        for(Address addressFor : listAddress)
        {
            list.add(convert(addressFor));
        }
        return new Pagination(temps.getTotalPages(),temps.getTotalElements(),temps.getSize(),temps.getNumber(),list);
    }

    //convert to loadView
    private AddressLoad convert(Address address)
    {
        AddressLoad retuenValue =  mapper.map(address ,AddressLoad.class);
        return retuenValue;
    }

}
