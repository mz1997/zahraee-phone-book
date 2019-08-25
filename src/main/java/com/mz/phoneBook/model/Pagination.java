package com.mz.phoneBook.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.List;

public class Pagination<T> {


    public Pagination(Integer totalPages,Long totalElements ,Integer size ,Integer number ,List<T> content){
        this.totalPages=totalPages;
        this.totalElements = totalElements;
        this.size = size;
        this.number = number;
        this.content = content;

    }

    @JsonIgnore
    private Integer totalPages;
    private Long totalElements;
    private Integer size;
    private Integer number;
    private List<T> content;


    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public Long getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(Long totalElements) {
        this.totalElements = totalElements;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public List<T> getContent() {
        return content;
    }

    public void setContent(List<T> content) {
        this.content = content;
    }
}
