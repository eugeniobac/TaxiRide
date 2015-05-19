package com.rest.ejb.repository;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import com.rest.ejb.base.BaseRepository;
import com.rest.ejb.model.TaxiRide;

@Local
public interface TaxiRideRepository extends BaseRepository<TaxiRide> {

    List<TaxiRide> findByDates(Date startDate, Date endDate);

}
