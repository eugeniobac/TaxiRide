package com.rest.ejb.base;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

@SuppressWarnings("unchecked")
public abstract class BaseRepositoryImpl<T> implements BaseRepository<T> {
    @PersistenceContext(unitName = "appCDIUnit")
    private EntityManager em;

    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public T save(T entity) {
	return (T) getSession().save(entity);
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public T update(T entity) {
	return (T) getSession().merge(entity);
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void delete(T entity) {
	getSession().delete(entity);
    }

    @Override
    public List<T> findByAttributtes(HashMap<String, Object> atributos) {
	Criteria crit = getSession().createCriteria(getClassType());
	for (Entry<String, Object> a : atributos.entrySet())
	    crit.add(Restrictions.eq(a.getKey(), a.getValue()));

	return crit.list();
    }

    @Override
    public List<T> findByAttribute(String atributo, Object valor) {
	String classe = getClassType().getSimpleName();

	try {
	    valor = Integer.valueOf(valor.toString());
	} catch (Exception e) {}

	return getSession().createQuery("SELECT x FROM " + classe + " x WHERE x." + atributo + " = :valor").setParameter("valor", valor)
		.list();
    }

    @Override
    public List<T> findAll() {
	return getSession().createCriteria(getClassType()).list();
    }

    @SuppressWarnings({ "rawtypes" })
    private Class getClassType() {
	try {
	    Type type = super.getClass().getGenericSuperclass();
	    Class<T> entityClass = null;

	    if (type instanceof ParameterizedType) {
		ParameterizedType paramType = (ParameterizedType) type;
		if (paramType.getActualTypeArguments().length == 2) {
		    if (paramType.getActualTypeArguments()[1] instanceof TypeVariable)
			throw new IllegalArgumentException("Could not guess entity class by reflection");
		    entityClass = ((Class) paramType.getActualTypeArguments()[1]);
		} else
		    entityClass = ((Class) paramType.getActualTypeArguments()[0]);
	    }

	    return entityClass.newInstance().getClass();

	} catch (Exception e) {
	    return null;
	}
    }

    @Override
    public T findById(Long id) {
	return (T) getSession().get(getClassType(), id);
    }

    public Session getSession() {
	return (Session) em.getDelegate();
    }

}
