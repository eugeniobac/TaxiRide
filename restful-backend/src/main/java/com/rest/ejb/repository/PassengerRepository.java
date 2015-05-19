package com.rest.ejb.repository;

import java.util.List;

import javax.ejb.Local;

import com.rest.ejb.base.BaseRepository;
import com.rest.ejb.model.Passenger;

@Local
public interface PassengerRepository extends BaseRepository<Passenger> {

    List<Passenger> findIfTaxiRideExists(boolean exists);

}
