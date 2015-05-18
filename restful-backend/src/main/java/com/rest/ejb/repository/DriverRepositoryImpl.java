package com.rest.ejb.repository;

import javax.ejb.Singleton;

import com.rest.ejb.base.BaseRepositoryImpl;
import com.rest.ejb.model.Driver;

@Singleton(name = "driverRepository")
public class DriverRepositoryImpl extends BaseRepositoryImpl<Driver> implements DriverRepository {

}
