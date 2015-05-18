package com.rest.ejb.repository;

import javax.ejb.Local;

import com.rest.ejb.base.BaseRepository;
import com.rest.ejb.model.Passenger;

@Local
public interface PassengerRepository extends BaseRepository<Passenger> {

}
