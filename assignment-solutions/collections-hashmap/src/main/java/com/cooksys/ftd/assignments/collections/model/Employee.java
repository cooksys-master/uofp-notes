package com.cooksys.ftd.assignments.collections.model;

import java.util.ArrayList;
import java.util.List;

import com.cooksys.ftd.assignments.collections.util.MissingImplementationException;

/**
 * Parent interface for both {@code Manager} and {@code Employee}.
 * <br><br>
 * It defines several getters and a utility method that must be implemented by its subclasses.
 * <br><br>
 * The getters should return data specific to the {@code Employee} they're called on - every instance of
 * {@code Employee} should have its own name and manager.
 */
public abstract class Employee {
	
	private String name;
	private Manager manager;

    public Employee(String name) {
		this.name = name;
    }
    
    public Employee(String name, Manager manager) {
    	this.name = name;
    	this.manager = manager;
    }
    
	/**
     * @return the name of the employee
     */
    public String getName() {
    	return name;
    }

    /**
     * @return true if the employee has a manager, false otherwise
     */
    public boolean hasManager() {
    	return manager != null;
    }

    /**
     * @return the employee's direct manager, or null if they have none
     */
    public Manager getManager() {
    	return manager;
    }

    /**
     * Calculates the employee's chain of command as a {@code List<Manager>}, starting with their direct {@code Manager},
     * followed by that {@code Manager}'s {@code Manager}, and so on, until the top of the hierarchy is reached.
     * <br><br>
     * The returned list should never be or contain {@code null}.
     * <br><br>
     * If the employee does not have a {@code Manager}, an empty
     * {@code List<Manager>} should be returned.
     *
     * @return a {@code List<Manager>} that represents the employee's chain of command,
     */
    public List<Manager> getChainOfCommand() {
    	// need to return a list<manager>
    	// the returned list should never be or contain null
    	// if this employee's manager is null, return an empty list
    	List<Manager> result = new ArrayList<>();
    	
    	// start with this.getManager()
    	Manager current = this.getManager();
    	
    	// stop if that  next manager is null
    	while(current != null) {
    		result.add(current);
    		// then go to the next manager
    		current = current.getManager();
    	}
    	
//    	for (Manager m = this.getManager(); m != null; m = m.getManager()) {
//    		result.add(m);
//    	}
    	
    	return result;
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((manager == null) ? 0 : manager.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (manager == null) {
			if (other.manager != null)
				return false;
		} else if (!manager.equals(other.manager))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return  getClass().getSimpleName() + " [name=" + name + ", manager=" + (manager != null ? manager.getName() : null) + "]";
	}
    
    

}
