package com.rest.ejb.base;

import java.util.HashMap;
import java.util.List;

public interface BaseRepository<T> {

    public T save(T entity);

    public void delete(T entity);

    public List<T> findAll();

    public List<T> findByAttributtes(HashMap<String, Object> atributos);

    public List<T> findByAttribute(String atributo, Object valor);

    public T findById(Long id);

    public T update(T entity);

}
