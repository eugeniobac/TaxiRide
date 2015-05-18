package com.rest.ejb.repository;

import javax.ejb.Local;

import com.rest.ejb.base.BaseRepository;
import com.rest.ejb.model.Driver;

@Local
public interface DriverRepository extends BaseRepository<Driver> {

}
