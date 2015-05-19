package com.rest.ejb.base;

import java.util.HashMap;
import java.util.List;

public interface BaseRepository<T> {

    T save(T entity);

    void delete(T entity);

    List<T> findAll();

    List<T> findByAttributtes(HashMap<String, Object> atributos);

    List<T> findByAttribute(String atributo, Object valor);

    T findById(Long id);

    T update(T entity);

}
