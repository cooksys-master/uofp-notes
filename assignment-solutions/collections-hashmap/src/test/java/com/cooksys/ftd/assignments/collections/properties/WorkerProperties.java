package com.cooksys.ftd.assignments.collections.properties;

import com.cooksys.ftd.assignments.collections.generators.GenManager;
import com.cooksys.ftd.assignments.collections.generators.GenWorker;
import com.cooksys.ftd.assignments.collections.model.Employee;
import com.cooksys.ftd.assignments.collections.model.Manager;
import com.cooksys.ftd.assignments.collections.model.Worker;
import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Test suite that verifies the essential properties of the {@code Worker} class. Students may run this class by
 * itself to check that their {@code Worker} implementation is correct - if the {@code Worker} implementation is not correct,
 * there may be false positive test results when running {@code OrgChartProperties} or the full {@code TestSuite}
 */
@RunWith(JUnitQuickcheck.class)
public class WorkerProperties {

    @Property
    public void noOwnerConstructor(String name) {
        Worker worker = new Worker(name);
        assertEquals("Worker#getName() did not return the value passed to new Worker(name,...)", name, worker.getName());
        assertNull("Worker#getManager() did not return null when constructed without a manager", worker.getManager());
        assertFalse("Worker#hasManager() did not return false when constructed without a manager", worker.hasManager());
    }

    @Property
    public void fullConstructor(String name, @GenManager Manager manager) {
        Worker worker = new Worker(name, manager);
        assertEquals("Worker#getName() did not return the value passed to new Worker(name,...)", name, worker.getName());
        assertEquals("Worker#getManager() did not return the value passed to new Worker(..., manager)", manager,
                worker.getManager());
        assertTrue("Worker#hasManager() did not return true when constructed without a manager", worker.hasManager());
    }

    @Property
    public void noOwnerValueEquality(String name, int salary) {
        Worker a = new Worker(name);
        Worker b = new Worker(name);
        assertEquals(
                "Worker#equals() did not return true when both instances were constructed with the same name values",
                a, b);
    }

    @Property
    public void fullValueEquality(String name, int salary, @GenManager Manager manager) {
        Worker a = new Worker(name, manager);
        Worker b = new Worker(name, manager);
        assertEquals(
                "Worker#equals() did not return true when both instances were constructed with the same name and manager values",
                a, b);
    }

    @Property
    public void emptyChainOfCommand(@GenWorker Worker worker) {
        List<Manager> chainOfCommand = worker.getChainOfCommand();
        assertNotNull("Worker#getChainOfCommand returned null instead of an empty list for a manager-less Worker", chainOfCommand);
        assertTrue("Worker#getChainOfCommand returned a non-empty List for a manager-less Worker", chainOfCommand.isEmpty());
    }

    @Property
    public void arbitraryChainOfCommand(@GenWorker( depth = -1) Worker worker) {
        List<Manager> chainOfCommand = worker.getChainOfCommand();
        assertNotNull("Worker#getChainOfCommand returned null instead of an empty list for an arbitrary Worker", chainOfCommand);
        if (!worker.hasManager()) {
            assertTrue("Worker#getChainOfCommand returned a non-empty List for a manager-less Worker", chainOfCommand.isEmpty());
        } else {
            List<Manager> expectedChainOfCommand = new ArrayList<>();
            Manager manager = worker.getManager();
            do {
                expectedChainOfCommand.add(manager);
                manager = manager.getManager();
            } while (manager != null);
            assertEquals("Manager#getChainOfCommand returned a list of the wrong size for an arbitrary Worker", expectedChainOfCommand.size(), chainOfCommand.size());
            assertEquals("Manager#getChainOfCommand did not return a list with the expected values", expectedChainOfCommand, chainOfCommand);
        }
    }
}
