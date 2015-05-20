/**
 *
 */
package com.rest.ejb.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Driver implements Serializable {

    private static final long serialVersionUID = -5939880767640067710L;

    @Id
    @GeneratedValue
    private Long id;

    @NotNull(message = "Field name is required!")
    @Column(length = 100)
    @Size(max = 100, message = "Max 100 characters per name!")
    private String name;

    @NotNull(message = "Field license is required!")
    @Size(max = 10, message = "Max 10 characters per license!")
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
