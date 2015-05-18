/**
 *
 */
package com.rest.ejb.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class TaxiRide implements Serializable {

    private static final long serialVersionUID = -5939880767640067710L;

    @Id
    @GeneratedValue
    private Long id;
    private Double cost;
    private Integer duration;
    private Date date;

    @ManyToOne
    private Driver driver;

    @OneToOne
    private Passenger passenger;

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public Double getCost() {
	return cost;
    }

    public void setCost(Double cost) {
	this.cost = cost;
    }

    public Integer getDuration() {
	return duration;
    }

    public void setDuration(Integer duration) {
	this.duration = duration;
    }

    public Date getDate() {
	return date;
    }

    public void setDate(Date date) {
	this.date = date;
    }

    public Driver getDriver() {
	return driver;
    }

    public void setDriver(Driver driver) {
	this.driver = driver;
    }

    public Passenger getPassenger() {
	return passenger;
    }

    public void setPassenger(Passenger passenger) {
	this.passenger = passenger;
    }

}
