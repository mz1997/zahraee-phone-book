package com.mz.phoneBook.service;

import com.mz.phoneBook.model.BaseEntity;
import com.mz.phoneBook.service.interfaces.IGenericService;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;
import java.util.List;

public abstract class GenericService <T extends BaseEntity<PK>, PK extends Serializable> implements IGenericService<T,PK> {

    protected abstract JpaRepository<T, PK> jpaRepository();

    @Override
    public void save(T entity) {
        jpaRepository().save(entity);
    }

    @Override
    public T load(PK id) {
        return jpaRepository().findOne(id);
    }

    @Override
    public void delete(PK id) {
        jpaRepository().delete(id);
    }
    @Override
    public void edit(T entity) {
        jpaRepository().save(entity);
    }

    @Override
    public List<T> getAll() {
        return jpaRepository().findAll();
    }


    protected Example<T> getExample(T example) {
        ExampleMatcher exampleMatcher = ExampleMatcher.matching().withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING)
                .withIgnoreCase();
        Example<T> exam = Example.of(example, exampleMatcher);
        return exam;
    }

    @Override
    public <S extends T> Page<T> findAll (int page, int size, S example){
        return jpaRepository().findAll(getExample(example), new PageRequest(page, size));
    }
}
