package com.cooksys.ftd.assignments.collections.model;

import com.cooksys.ftd.assignments.collections.util.MissingImplementationException;

import java.util.List;

/**
 * TODO: Implement this class
 *  <br><br>
 *  A manager is a type of employee that can be a superior to another employee.
 *  <br>
 *  A manager should have a name, and, optionally, a manager superior to them.
 */
public class Manager extends Employee {

    // TODO: Does this class need private fields? If so, add them here

    /**
     * TODO: Implement this constructor.
     *
     * @param name the name of the manager to be created
     */
    public Manager(String name) {
        super(name);
    }

    /**
     *  TODO: Implement this constructor.
     *
     * @param name the name of the manager to be created
     * @param manager the direct manager of the manager to be created
     */
    public Manager(String name, Manager manager) {
        super(name, manager);
    }


}
