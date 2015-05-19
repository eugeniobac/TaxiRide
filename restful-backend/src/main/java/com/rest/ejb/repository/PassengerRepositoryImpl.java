package com.rest.ejb.repository;

import java.util.List;

import javax.ejb.Singleton;

import com.rest.ejb.base.BaseRepositoryImpl;
import com.rest.ejb.model.Passenger;

@Singleton(name = "passengerRepository")
public class PassengerRepositoryImpl extends BaseRepositoryImpl<Passenger> implements PassengerRepository {
    @SuppressWarnings("unchecked")
    @Override
    public List<Passenger> findIfTaxiRideExists(boolean exists) {
	String clause = "IS NULL";
	if (exists)
	    clause = "IS NOT NULL";

	return getSession().createQuery("SELECT p FROM Passenger as p LEFT JOIN p.taxiRide as t WHERE t " + clause).list();
    }

}
