package com.cooksys.ftd.assignments.collections.model;

import com.cooksys.ftd.assignments.collections.model.Employee;
import com.cooksys.ftd.assignments.collections.model.Manager;
import com.cooksys.ftd.assignments.collections.util.MissingImplementationException;

import java.util.*;

public class OrgChart {

    // TODO: this class needs to store employee data in private fields in order for the other methods to work as intended.
    //  Add those fields here. Consider how you want to store the data, and which collection types to use to make
    //  implementing the other methods as easy as possible. There are several different ways to approach this problem, so
    //  experiment and don't be afraid to change how you're storing your data if it's not working out!
	private Map<Manager, Set<Employee>> hierarchy = new HashMap<>();
	

    /**
     * TODO: Implement this method
     *  <br><br>
     *  Adds a given {@code Employee} to the {@code OrgChart}. If the {@code Employee} is successfully added, this
     *  method should return true. If the {@code Employee} was not successfully added, it should return false. In order
     *  to determine if and how an {@code Employee} can be added, refer to the following algorithm:
     *  <br><br>
     *  If the given {@code Employee} is already present in the {@code OrgChart}, do not add it and
     *  return false. Otherwise:
     *  <br><br>
     *  If the given {@code Employee} has a {@code Manager} and that {@code Manager} is not part of the
     *  {@code OrgChart} yet, add that {@code Manager} first and then add the given {@code Employee}, and return true.
     *  <br><br>
     *  If the given {@code Employee} has no {@code Manager}, but is a {@code Manager} itself, add it to the
     *  {@code OrgChart} and return true.
     *  <br><br>
     *  If the given {@code Employee} has no {@code Manager} and is not a {@code Manager} itself, do not add it
     *  and return false.
     *
     * @param employee the {@code Employee} to add to the {@code OrgChart}
     * @return true if the {@code Employee} was added successfully, false otherwise
     */
    public boolean addEmployee(Employee employee) {
    	// THINGS THAT NEED TO HAPPEN
    	// add to orgchart
    	// if add was successful return true
    	// otherwise return false
    	
    	// CONDITIONS
    	// If the employee is null or already added, don't add, return false
    	// An employee to be added should have their chain of command represented in the hierarchy
    	// If an employee is a worker and does not have a manager, do not add and return false
    	
    	
    	if (employee == null || this.hasEmployee(employee)) {
    		// If the employee is null or already added, don't add, return false
    		return false;
    		
    	} else if (employee instanceof Worker && !employee.hasManager()) {
    		// If an employee is a worker and does not have a manager, do not add and return false
    		return false;
    		
    	} else {
    		// An employee to be added should have their chain of command represented in the hierarchy
    		if (!this.hasEmployee(employee.getManager())) {
    			// get the chain of command...
    			List<Manager> chainOfCommand = employee.getChainOfCommand();
    			// ... in reverse order ...
    			Collections.reverse(chainOfCommand);
    			
    			// ... and iterate over it
    			for (Manager current : chainOfCommand) {
    				// skip any managers toward the top of the hierarchy that have already been added
    				if (this.hasEmployee(current)) {
    					continue;
    				}
    				// if the current manager's manager is in the hierarchy
    				if (hierarchy.containsKey(current.getManager())) {
    					// add the current manager to it's manager's associated Set<Employee>
    					hierarchy.get(current.getManager()).add(current);
    				}
    				// add the current manager to the map as a key and set up its own Set<Employee>
					hierarchy.put(current, new HashSet<>());
    			}
    		}
    		// add the employee
    		if (employee instanceof Manager) {
    			// add the current manager to the map as a key and set up its own Set<Employee>
				hierarchy.put((Manager) employee, new HashSet<>());
				if (!employee.hasManager()) {
					// if the employee does not have a manager, return true because there is no parent manager's employee set to add the employee to
					return true;
				}
    		} 
    		// 
    		return hierarchy.get(employee.getManager()).add(employee);
    		
    	}
    }

    /**
     * TODO: Implement this method
     *  <br><br>
     *  Checks if a given {@code Employee} has already been added to the {@code OrgChart}.
     *
     * @param employee the {@code Employee} to search for
     * @return true if the {@code Employee} has been added to the {@code OrgChart}, false otherwise
     */
    public boolean hasEmployee(Employee employee) {
    	if (employee == null) {
    		return false;
    	}
    	// if the employee is a manager
    	if (employee instanceof Manager) {
    		// then it has to be a key in the map
    		return this.hierarchy.containsKey(employee);
    	} else {
    		// otherwise it must be a worker
    		
    		// Then, as long as the worker's manager is in the map 
    		if (this.hierarchy.containsKey(employee.getManager())) {
    			
    			// the worker has to be in the Set<Employee> associated with that manager in the map
    			return this.hierarchy.get(employee.getManager()).contains(employee);
    		} else {
    		    // if the worker's manager is not a key in the map, the worker cannot be in the org
    			// because the add method states that in order to add an employee, their manager must also be added
    			return false;
    		}
    	}
    }

    /**
     * TODO: Implement this method
     *  <br><br>
     *  Retrieves all {@code Employee}s that have been added to the {@code OrgChart} as a flat {@code Set}. If no
     *  {@code Employee}s have been added to the {@code OrgChart} yet, the returned {@code Set} should be empty (not
     *  {@code null}!).
     *
     * @return all {@code Employee}s in the {@code OrgChart}, or an empty {@code Set} if no {@code Employee}s have
     *         been added to the {@code OrgChart}
     */
    public Set<Employee> getAllEmployees() {
        Set<Employee> result = new HashSet<>(this.hierarchy.keySet());
        for (Set<Employee> subordinates : this.hierarchy.values()) {
        	result.addAll(subordinates);
        }
        return result;
    }

    /**
     * TODO: Implement this method
     *  <br><br>
     *  Retrieves all {@code Manager}s that have been added to the {@code OrgChart} as a flat {@code Set}. If no
     *  {@code Manager}s have been added to the {@code OrgChart}, the returned {@code Set} should be empty (not
     *  {@code null}!).
     *
     * @return all {@code Manager}s in the {@code OrgChart}, or an empty {@code Set} if no {@code Manager}s
     *         have been added to the {@code OrgChart}
     */
    public Set<Manager> getAllManagers() {
//    	Set<Manager> result = new HashSet<>();
////    	for(Manager m : this.hierarchy.keySet()) {
////    		result.add(m);
////    	}
//    	result.addAll(this.hierarchy.keySet());
//        return result;
    	return new HashSet<>(this.hierarchy.keySet());
    }

    /**
     * TODO: Implement this method
     *  <br><br>
     *  Retrieves all of the direct subordinates of a given {@code Manager} as a flat {@code Set}.
     *  <br><br>
     *  These are the {@code Employee}s (both {@code Worker}s and {@code Manager}s) that return the given
     *  {@code Manager} when their {@code .getManager()} method is called.
     *  <br><br>
     *  If the given {@code Manager} does not have any subordinates in the
     *  {@code OrgChart}, or if the given {@code Manager} is itself not in the {@code OrgChart}, the returned
     *  {@code Set} should be empty, but not {@code null}.
     *
     * @param manager the {@code Manager} whose direct subordinates need to be returned
     * @return all {@code Employee}s in the {@code OrgChart} that have the given {@code Manager} as a direct
     *         parent, or an empty set if the {@code Manager} is not present in the {@code OrgChart}
     *         or if there are no subordinates for the given {@code Manager}
     */
    public Set<Employee> getDirectSubordinates(Manager manager) {
        Set<Employee> result = new HashSet<>();
        if (this.hasEmployee(manager)) {
        	result.addAll(this.hierarchy.get(manager));
        }
        return result;
    }

    /**
     * TODO: Implement this method
     *  <br><br>
     *  Retrieves a full representation of this {@code OrgChart} as a {@code Map} of {@code Manager} keys and
     *  {@code Set<Employee>} values. Every single {@code Manager} in the {@code OrgChart} should appear as a key in
     *  the returned {@code Map}, and for each (@code Manager} key, every {@code Employee} (both {@code Worker}s and
     *  {@code Manager}s) in the {@code OrgChart} whose direct manager is that key should be in the associated
     *  {@code Set<Employee>} value.
     *  <br><br>
     *  Like the other methods, the return value of this method should not be {@code null} or contain {@code null},
     *  either in its keys or values. An empty {@code Map} should be returned if the {@code OrgChart} is empty.
     *
     * @return a map in which the keys represent the parent {@code Manager}s in the
     *         {@code OrgChart}, and the each value is a set of the direct subordinates of the
     *         associated {@code Manager}, or an empty map if the {@code OrgChart} is empty.
     */
    public Map<Manager, Set<Employee>> getFullHierarchy() {
        Map<Manager, Set<Employee>> result = new HashMap<>();
        for (Manager current : this.hierarchy.keySet()) {
        	result.put(current, new HashSet<>(this.hierarchy.get(current)));
        }
        return result;
    }

}
