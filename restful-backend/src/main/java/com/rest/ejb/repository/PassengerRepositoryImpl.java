package com.rest.ejb.repository;

import javax.ejb.Singleton;

import com.rest.ejb.base.BaseRepositoryImpl;
import com.rest.ejb.model.Passenger;

@Singleton(name = "passengerRepository")
public class PassengerRepositoryImpl extends BaseRepositoryImpl<Passenger> implements PassengerRepository {

}
