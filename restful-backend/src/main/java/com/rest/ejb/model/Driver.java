/**
 *
 */
package com.rest.ejb.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Driver implements Serializable {

    private static final long serialVersionUID = -5939880767640067710L;

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String license;

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

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }

}
