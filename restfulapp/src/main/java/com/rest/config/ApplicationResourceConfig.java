package com.rest.config;

import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import com.rest.controller.DriverResource;

@ApplicationPath("/api")
public class ApplicationResourceConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
	return getRestResourceClasses();
    }

    private Set<Class<?>> getRestResourceClasses() {
	Set<Class<?>> resources = new java.util.HashSet<Class<?>>();
	resources.add(DriverResource.class);
	return resources;
    }
}
