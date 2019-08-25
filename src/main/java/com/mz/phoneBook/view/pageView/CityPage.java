package com.mz.phoneBook.view.pageView;

public class CityPage {

    private int page = 0;
    private int size = 5;
    private Integer id;
    private String name;
    private Integer StateId;
    private String stateName;

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStateId() {
        return StateId;
    }

    public void setStateId(Integer stateId) {
        StateId = stateId;
    }
}
