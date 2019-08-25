package com.mz.phoneBook.controller;


import com.mz.phoneBook.model.Pagination;
import com.mz.phoneBook.model.State;
import com.mz.phoneBook.service.interfaces.IStateService;
import com.mz.phoneBook.view.loadView.StateLoad;
import com.mz.phoneBook.view.pageView.StatePage;
import com.mz.phoneBook.view.postView.StatePost;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/state")
public class StateController {



    @Autowired
    private IStateService stateService;

    @Autowired
    private Mapper mapper;

    //save:
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public void save(@RequestBody StatePost statePost) {
        State state = mapper.map(statePost,State.class);
        if (statePost.getId()!= null){
            throw new RuntimeException();
        }
        stateService.save(state);
    }

    //edit:
    @RequestMapping(value = "/edit", method = RequestMethod.PUT)
    public void edit(@RequestBody StatePost statePost) {
        State state = mapper.map(statePost ,State.class);
        if (statePost.getId()== null){
            throw new RuntimeException();
        }
        stateService.edit(state);
    }

    //load:
    @RequestMapping(value = "/load/{id}", method = RequestMethod.GET)
    public StateLoad load(@PathVariable Integer id) {
        return convert(stateService.load(id));
    }

    //delete:
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Integer id) {
        stateService.delete(id);
    }

    //get all
    @RequestMapping(value = "/getAllState", method = RequestMethod.GET)
    public List<StateLoad> getAll() {
        List<State> listState = new ArrayList<State>();
        listState = stateService.getAll();
        List<StateLoad> list =  new ArrayList<StateLoad>();
        for(State stateFor : listState)
        {
            list.add(convert(stateFor));
        }
        return list;
    }

    //search:
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public Pagination<StateLoad> search (@RequestBody(required = false) StatePage statePage){
        State state =  mapper.map(statePage ,State.class);
        Page<State> temps = stateService.findAll(statePage.getPage(), statePage.getSize() , state);
        List<State> listState = temps.getContent();
        List<StateLoad> list =  new ArrayList<StateLoad>();
        for(State stateFor : listState)
        {
            list.add(convert(stateFor));
        }
        return new Pagination(temps.getTotalPages(),temps.getTotalElements(),temps.getSize(),temps.getNumber(),list);
    }

    //convert to loadView
    private StateLoad convert(State state)
    {
        StateLoad retuenValue =  mapper.map(state ,StateLoad.class);
        return retuenValue;
    }

}
