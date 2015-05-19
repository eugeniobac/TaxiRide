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

    private String firstName;
    private String lastName;
    private Integer age;

    @OneToOne(mappedBy = "passenger")
    private TaxiRide taxiRide;

    public TaxiRide getTaxiRide() {
	return taxiRide;
    }

    public void setTaxiRide(TaxiRide taxiRide) {
	this.taxiRide = taxiRide;
    }

    public String getFirstName() {
	return firstName;
    }

    public void setFirstName(String firstName) {
	this.firstName = firstName;
    }

    public String getLastName() {
	return lastName;
    }

    public void setLastName(String lastName) {
	this.lastName = lastName;
    }

    public Integer getAge() {
	return age;
    }

    public void setAge(Integer age) {
	this.age = age;
    }
}
