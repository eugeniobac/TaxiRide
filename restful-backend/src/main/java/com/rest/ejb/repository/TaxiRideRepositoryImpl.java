package com.rest.ejb.repository;

import java.util.Date;
import java.util.List;

import javax.ejb.Singleton;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import com.rest.ejb.base.BaseRepositoryImpl;
import com.rest.ejb.model.TaxiRide;

@Singleton(name = "taxiRideRepository")
public class TaxiRideRepositoryImpl extends BaseRepositoryImpl<TaxiRide> implements TaxiRideRepository {

    @SuppressWarnings("unchecked")
    @Override
    public List<TaxiRide> findByDates(Date startDate, Date endDate) {
	Criteria criteria = getSession().createCriteria(TaxiRide.class);

	criteria.add(Restrictions.between("date", startDate, endDate));

	return criteria.list();
    }

}
