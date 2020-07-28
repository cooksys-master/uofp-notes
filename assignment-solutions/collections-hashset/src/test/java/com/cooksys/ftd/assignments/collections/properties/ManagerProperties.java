package com.cooksys.ftd.assignments.collections.properties;

import com.cooksys.ftd.assignments.collections.generators.GenManager;
import com.cooksys.ftd.assignments.collections.model.Manager;
import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Test suite that verifies the essential properties of the {@code Manager} class. Students may run this class by
 * itself to check that their {@code Manager} implementation is correct - if the {@code Manager} implementation is not correct,
 * there may be false positive test results when running {@code OrgChartProperties} or the full {@code TestSuite}
 */
@RunWith(JUnitQuickcheck.class)
public class ManagerProperties {

    @Property
    public void noOwnerConstructor(String name) {
        Manager manager = new Manager(name);
        assertEquals("Manager#getName() did not return the value passed to new Manager(name)", name, manager.getName());
        assertNull("Manager#getManager() did not return null when constructed without an owner", manager.getManager());
        assertFalse("Manager#hasManager() did not return false when constructed without an owner", manager.hasManager());
    }
    @Property
    public void fullConstructor(String name, @GenManager Manager manager) {
        Manager m = new Manager(name, manager);
        assertEquals("Manager#getName() did not return the value passed to new Manager(name,...)", name, m.getName());
        assertEquals("Manager#getManager() did not return the value passed to new Manager(..., manager)", manager,
                m.getManager());
        assertTrue("Manager#hasManager() did not return true when constructed without a manager", m.hasManager());
    }

    @Property
    public void noOwnerValueEquality(String name) {
        Manager a = new Manager(name);
        Manager b = new Manager(name);
        assertEquals(
                "Manager#equals() did not return true when both instances were constructed with the same name values",
                a, b);
    }

    @Property
    public void fullValueEquality(String name, @GenManager Manager manager) {
        Manager a = new Manager(name, manager);
        Manager b = new Manager(name, manager);
        assertEquals(
                "Manager#equals() did not return true when both instances were constructed with the same name and manager values",
                a, b);
    }

    @Property
    public void emptyChainOfCommand(@GenManager Manager manager) {
        List<Manager> chainOfCommand = manager.getChainOfCommand();
        assertNotNull("Manager#getChainOfCommand returned null instead of an empty list for a manager-less manager", chainOfCommand);
        assertTrue("Manager#getChainOfCommand returned a non-empty List for a manager-less manager", chainOfCommand.isEmpty());
    }

    @Property
    public void arbitraryChainOfCommand(@GenManager( depth = -1) Manager manager) {
        List<Manager> chainOfCommand = manager.getChainOfCommand();
        assertNotNull("Manager#getChainOfCommand returned null instead of an empty list for an arbitrary manager", chainOfCommand);
        if (!manager.hasManager()) {
            assertTrue("Manager#getChainOfCommand returned a non-empty List for a manager-less manager", chainOfCommand.isEmpty());
        } else {
            List<Manager> expectedChainOfCommand = new ArrayList<>();
            while (manager.hasManager()) {
                manager = manager.getManager();
                expectedChainOfCommand.add(manager);
            }
            assertEquals("Manager#getChainOfCommand returned a list of the wrong size for an arbitrary manager", expectedChainOfCommand.size(), chainOfCommand.size());
            assertEquals("Manager#getChainOfCommand did not return a list with the expected values", expectedChainOfCommand, chainOfCommand);
        }
    }
}
