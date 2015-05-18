/**
 *
 */
package com.rest.ejb.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Passenger implements Serializable {

    private static final long serialVersionUID = -5939880767640067710L;

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String license;

    @OneToOne(mappedBy = "passenger")
    private TaxiRide taxiRider;

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public String getLicense() {
	return license;
    }

    public void setLicense(String license) {
	this.license = license;
    }

    public TaxiRide getTaxiRider() {
	return taxiRider;
    }

    public void setTaxiRider(TaxiRide taxiRider) {
	this.taxiRider = taxiRider;
    }
}
