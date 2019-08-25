package com.mz.phoneBook.controller;

import com.mz.phoneBook.model.City;
import com.mz.phoneBook.model.Pagination;
import com.mz.phoneBook.service.interfaces.ICityService;
import com.mz.phoneBook.view.loadView.CityLoad;
import com.mz.phoneBook.view.pageView.CityPage;
import com.mz.phoneBook.view.postView.CityPost;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/city")
public class CityController {



    @Autowired
    private ICityService cityService;

    @Autowired
    private Mapper mapper;

    //save:
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public void save(@RequestBody CityPost cityPost) {
        City city= mapper.map(cityPost, City.class);
        if (city.getId()!= null){
            throw new RuntimeException();
        }
        cityService.save(city);
    }

    //edit:
    @RequestMapping(value = "/edit", method = RequestMethod.PUT)
    public void edit(@RequestBody CityPost cityPost) {
        City city = mapper.map(cityPost ,City.class);
        if (cityPost.getId()== null){
            throw new RuntimeException();
        }
        cityService.edit(city);
    }

    //load:
    @RequestMapping(value = "/load/{id}", method = RequestMethod.GET)
    public CityLoad load(@PathVariable Integer id) {
        return convert(cityService.load(id));
    }

    //delete:
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Integer id) {
        cityService.delete(id);
    }

    //get all
    @RequestMapping(value = "/getAllCity", method = RequestMethod.GET)
    public List<CityLoad> getAll() {
        List<City> listCity = new ArrayList<City>();
        listCity = cityService.getAll();
        List<CityLoad> list =  new ArrayList<CityLoad>();
        for(City cityFor : listCity)
        {
            list.add(convert(cityFor));
        }
        return list;
    }

    //search:
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public Pagination<CityLoad> search (@RequestBody(required = false) CityPage cityPage){
        City city =  mapper.map(cityPage ,City.class);
        Page<City> temps = cityService.findAll(cityPage.getPage(), cityPage.getSize() , city);
        List<City> listCity = temps.getContent();
        List<CityLoad> list =  new ArrayList<CityLoad>();
        for(City cityFor : listCity)
        {
            list.add(convert(cityFor));
        }
        return new Pagination(temps.getTotalPages(),temps.getTotalElements(),temps.getSize(),temps.getNumber(),list);
    }

    //convert to loadView
    private CityLoad convert(City city)
    {
        CityLoad retuenValue =  mapper.map(city,CityLoad.class);
        return retuenValue;
    }
}
