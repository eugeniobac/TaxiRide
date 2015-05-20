/**
 *
 */
package com.rest.ejb.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.codehaus.jackson.annotate.JsonIgnore;

@Entity
public class Passenger implements Serializable {

    private static final long serialVersionUID = -5939880767640067710L;

    @Id
    @GeneratedValue
    private Long id;

    @NotNull(message = "Field firstName is required!")
    @Size(max = 10, message = "Max 100 characters per firstName!")
    private String firstName;

    @NotNull(message = "Field lastName is required!")
    @Size(max = 10, message = "Max 100 characters per lastName!")
    private String lastName;

    @NotNull(message = "Field age is required!")
    private Integer age;

    @OneToMany(mappedBy = "passenger")
    @JsonIgnore
    private List<TaxiRide> taxiRide;

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

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public List<TaxiRide> getTaxiRide() {
	return taxiRide;
    }

    public void setTaxiRide(List<TaxiRide> taxiRide) {
	this.taxiRide = taxiRide;
    }
}
