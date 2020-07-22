package com.cooksys.ftd.assignments.collections.model;

import com.cooksys.ftd.assignments.collections.util.MissingImplementationException;

import java.util.List;

/**
 * TODO: Implement this class <br>
 * <br>
 * A worker is a type of employee that cannot be a superior to another employee.
 * <br>
 * A worker should have a name, and, optionally, a manager superior to them.
 */
public class Worker extends Employee {

	public Worker(String name) {
		super(name);
	}
	
	public Worker(String name, Manager manager) {
		super(name, manager);
	}
}
