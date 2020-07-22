package com.cooksys.ftd.assignments.collections.properties;

import com.cooksys.ftd.assignments.collections.model.OrgChart;
import com.cooksys.ftd.assignments.collections.generators.GenEmployee;
import com.cooksys.ftd.assignments.collections.generators.GenOrgChart;
import com.cooksys.ftd.assignments.collections.generators.GenWorker;
import com.cooksys.ftd.assignments.collections.model.Manager;
import com.cooksys.ftd.assignments.collections.generators.GenManager;
import com.cooksys.ftd.assignments.collections.model.Employee;
import com.cooksys.ftd.assignments.collections.model.Worker;
import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import org.junit.runner.RunWith;

import java.util.*;

import static org.junit.Assert.*;

/**
 * Test suite that verifies the essential properties of the {@code OrgChart} class. Students may run this class by
 * itself to check that their {@code OrgChart} implementation is correct - but if their {@code Manager} or
 * {@code Worker} implementations have errors, this test may have false positive or negative test results. Students
 * should run the {@code ManagerProperties} and {@code WorkerProperties} test suites first to verify their
 * implementation of the {@code Manager} and {@code Worker} classes.
 * <br><br>
 * One additional note: The later tests in this suite rely on the {@code OrgChart.add()} and {@code OrgChart.has()}
 * methods functioning according to specifications. If the student's {@code .add()} or {@code .has()} implementations
 * are incomplete or incorrect, running the full test suite may result in false positives or negatives. Students should
 * verify that the
 * <br><br>
 * {@code addNull}, <br>
 * {@code addHasManagerlessWorker}, <br>
 * {@code addHasManagerlessManager}, <br>
 * {@code addHasEmployeeWithManager}, <br>
 * {@code addHasMultipleArbitraryEmployees}, <br>
 * and {@code .addHasMultipleArbitraryEmployeeNoDuplicates}
 * <br><br>
 * test methods are all succeeding before interpreting the other test results. These tests fully verify the
 * implementation requirements for the {@code .add()} and {@code .has()} methods.
 */
@RunWith(JUnitQuickcheck.class)
public class OrgChartProperties {

    @Property
    public void addNull(@GenOrgChart OrgChart orgChart) {
        assertFalse("OrgChart#add() returned true when called with null", orgChart.addEmployee(null));
    }

    @Property
    public void addHasManagerlessWorker(@GenOrgChart OrgChart orgChart, @GenWorker Worker worker) {
        assertFalse("OrgChart#add() returned true when called with a manager-less Worker", orgChart.addEmployee(worker));
        assertFalse("OrgChart#has() returned true when called with a manager-less Worker that failed to be added",
                orgChart.hasEmployee(worker));
    }

    @Property
    public void addHasManagerlessManager(@GenOrgChart OrgChart orgChart, @GenManager Manager manager) {
        assertTrue("OrgChart#add() returned false when called with a manager-less Manager", orgChart.addEmployee(manager));
        assertTrue("OrgChart#has() returned false when called with the manager-less Manager that was just added",
                orgChart.hasEmployee(manager));
    }

    @Property
    public void addHasEmployeeWithManager(@GenOrgChart OrgChart orgChart, @GenEmployee(depth = 1) Employee cap) {
        assertTrue("OrgChart#add() returned false when called with a Employee", orgChart.addEmployee(cap));
        assertTrue("OrgChart#has() returned false when called with the manager of the Employee that was just added",
                orgChart.hasEmployee(cap));
        assertTrue("OrgChart#has() returned false when called with the Employee that was just added", orgChart.hasEmployee(cap));
    }

    @Property
    public void addHasMultipleArbitraryEmployees(@GenOrgChart OrgChart orgChart, Set<@GenEmployee(depth = -1) Employee> employees) {
        for (Employee employee : employees) {
            assertTrue("OrgChart#add() returned false when called with an Employee", orgChart.addEmployee(employee));
            assertTrue("OrgChart#has() returned false when called with the Employee that was just added",
                    orgChart.hasEmployee(employee));
            while (employee.hasManager()) {
                employee = employee.getManager();
                assertTrue("OrgChart#has() returned false when called with a manager of the Employee that was just added",
                        orgChart.hasEmployee(employee));
            }
        }
    }

    @Property
    public void addHasMultipleArbitraryEmployeeNoDuplicates(@GenOrgChart OrgChart orgChart,
                                                            Set<@GenEmployee(depth = -1) Employee> employees) {
        for (Employee employee : employees) {
            assertTrue("OrgChart#add() returned false when called with an arbitrary Employee", orgChart.addEmployee(employee));
            assertTrue("OrgChart#has() returned false when called with the arbitrary Employee that was just added",
                    orgChart.hasEmployee(employee));
            assertFalse("OrgChart#add() returned true when called with the arbitrary Employee that was just added",
                    orgChart.addEmployee(employee));
        }

        for (Employee employee : employees) {
            assertTrue("OrgChart#has() returned false when called with a previously-added Employee", orgChart.hasEmployee(employee));
            assertFalse(
                    "OrgChart#add() returned true when called with a previously-added Employee after adding multiple Employees",
                    orgChart.addEmployee(employee));
        }
    }

    @Property
    public void getEmployeesEmpty(@GenOrgChart OrgChart orgChart) {
        Set<Employee> elements = orgChart.getAllEmployees();
        assertNotNull("OrgChart#getEmployees() returned a null value when called on an empty OrgChart", elements);
        assertTrue("OrgChart#getEmployees() returned a non-empty set when called on an empty OrgChart", elements.isEmpty());
    }

    @Property
    public void getEmployeesDefensiveCopy(@GenOrgChart OrgChart orgChart, @GenEmployee(depth = -1) Employee employee) {
        Set<Employee> elements = orgChart.getAllEmployees();
        elements.add(employee);
        assertFalse("OrgChart#getEmployees() returned a live set of elements that allowed external changes to the OrgChart",
                orgChart.hasEmployee(employee));
        elements = orgChart.getAllEmployees();
        assertFalse("OrgChart#getEmployees() returned a live set of elements that allowed external changes to the OrgChart",
                elements.contains(employee));
    }

    @Property
    public void getEmployeesMultipleArbitraryEmployees(@GenOrgChart OrgChart orgChart,
            Set<@GenEmployee(depth = -1) Employee> employees) {
        Set<Employee> expected = new HashSet<>(employees);
        for (Employee employee : employees) {
            orgChart.addEmployee(employee);
            while (employee != null) {
                expected.add(employee);
                employee = employee.getManager();
            }
        }
        Set<Employee> elements = orgChart.getAllEmployees();
        assertEquals(
                "OrgChart#getEmployees() returned a set that did not equal the set of previously-added Employees and their managers",
                expected, elements);
    }

    @Property
    public void getManagersEmpty(@GenOrgChart OrgChart orgChart) {
        Set<Manager> managers = orgChart.getAllManagers();
        assertNotNull("OrgChart#getManagers() returned a null value when called on an empty OrgChart", managers);
        assertTrue("OrgChart#getManagers() returned a non-empty set when called on an empty OrgChart", managers.isEmpty());
    }

    @Property
    public void getManagersDefensiveCopy(@GenOrgChart OrgChart orgChart, @GenManager Manager manager) {
        Set<Manager> managers = orgChart.getAllManagers();
        managers.add(manager);
        assertFalse("OrgChart#getManagers() returned a live set of managers that allowed external changes to the OrgChart",
                orgChart.hasEmployee(manager));
        managers = orgChart.getAllManagers();
        assertFalse("OrgChart#getManagers() returned a live set of managers that allowed external changes to the OrgChart",
                managers.contains(manager));
    }

    @Property
    public void getManagersManager(@GenOrgChart OrgChart orgChart, @GenManager Manager manager) {
        orgChart.addEmployee(manager);
        Set<Manager> managers = orgChart.getAllManagers();
        assertFalse("OrgChart#getManagers() returned an empty set after adding a Manager to the OrgChart", managers.isEmpty());
        assertEquals("OrgChart#getManagers() returned a set with size > 1 after adding a single Manager to the OrgChart", 1,
                managers.size());
    }

    @Property
    public void getManagersWorkerWithManager(@GenOrgChart OrgChart orgChart, @GenWorker(depth = 1) Worker worker) {
        orgChart.addEmployee(worker);
        Manager manager = worker.getManager();
        Set<Manager> managers = orgChart.getAllManagers();
        assertFalse("OrgChart#getManagers() returned an empty set after adding a Worker with a Manager to the OrgChart",
                managers.isEmpty());
        assertEquals(
                "OrgChart#getManagers() returned a set with size > 1 after adding a single Worker with a single Manager to the OrgChart",
                1, managers.size());
        assertTrue("OrgChart#getManagers() returned a set that did not contain the manager of the Worker added to the OrgChart",
                managers.contains(manager));
    }

    @Property
    public void getManagersMultipleArbitraryEmployees(@GenOrgChart OrgChart orgChart,
            Set<@GenEmployee(depth = -1) Employee> employees) {
        Set<Manager> expected = new HashSet<>();
        for (Employee employee : employees) {
            orgChart.addEmployee(employee);
            Manager manager = employee instanceof Manager ? (Manager) employee : employee.getManager();
            while (manager != null) {
                expected.add(manager);
                manager = manager.getManager();
            }
        }
        Set<Manager> managers = orgChart.getAllManagers();
        assertEquals("OrgChart#getManagers() returned a set that did not equal the set of all managers of the added Employees",
                expected, managers);
    }

    @Property
    public void getDirectSubordinatesEmpty(@GenOrgChart OrgChart orgChart, @GenManager Manager manager) {
        Set<Employee> subordinates = orgChart.getDirectSubordinates(manager);
        assertNotNull("OrgChart#getDirectSubordinates() returned a null value when called on an empty OrgChart", subordinates);
        assertTrue("OrgChart#getDirectSubordinates() returned a non-empty set when called on an empty OrgChart", subordinates.isEmpty());
    }

    @Property
    public void getDirectSubordinatesDefensiveCopy(@GenOrgChart OrgChart orgChart, @GenManager Manager manager, @GenEmployee Employee employee) {
        orgChart.addEmployee(manager);
        Set<Employee> subordinates = orgChart.getDirectSubordinates(manager);
        assertTrue("OrgChart#getDirectSubordinates() returned a non-empty set after adding a managerless Manager to the OrgChart",
                subordinates.isEmpty());
        subordinates.add(employee);
        assertFalse("OrgChart#getDirectSubordinates() returned a live set that allowed external changes to the OrgChart",
                orgChart.hasEmployee(employee));
        subordinates = orgChart.getDirectSubordinates(manager);
        assertFalse("OrgChart#getDirectSubordinates() returned a live set that allowed external changes to the OrgChart",
                subordinates.contains(employee));
    }

    @Property
    public void getDirectSubordinatesManagerWithManager(@GenOrgChart OrgChart orgChart, @GenManager(depth = 1) Manager manager) {
        orgChart.addEmployee(manager);
        Set<Employee> subordinates = orgChart.getDirectSubordinates(manager);
        assertTrue(
                "OrgChart#getDirectSubordinates() returned a non-empty set when called with a previously-added Manager that has a single manager",
                subordinates.isEmpty());
        subordinates = orgChart.getDirectSubordinates(manager.getManager());
        assertTrue(
                "OrgChart#getDirectSubordinates() returned a set that does not contain the previously-added Manager when called with its manager",
                subordinates.contains(manager));
    }

    @Property
    public void getDirectSubordinatesMultipleEmployeesWithSharedManager(@GenOrgChart OrgChart orgChart, @GenManager Manager manager,
                                                               Set<@GenEmployee Employee> subordinates) {
        orgChart.addEmployee(manager);
        Set<Employee> expected = new HashSet<>();
        for (Employee managerless : subordinates) {
            Employee withManager = managerless instanceof Manager
                    ? new Manager(managerless.getName(), manager)
                    : new Worker(managerless.getName(), manager);
            orgChart.addEmployee(withManager);
            expected.add(withManager);
        }
        assertEquals(
                "@getDirectSubordinates() returned a set that did not equal the set of subordinates of the previously-added Manager",
                expected, orgChart.getDirectSubordinates(manager));
    }

    @Property
    public void getDirectSubordinatesMultipleEmployeesSomeWithSharedManager(@GenOrgChart OrgChart orgChart, @GenManager Manager manager,
                                                                   Set<@GenEmployee Employee> subordinates, Set<@GenEmployee Employee> loose) {
        orgChart.addEmployee(manager);
        Set<Employee> expected = new HashSet<>();
        for (Employee managerless : subordinates) {
            Employee withManager = managerless instanceof Manager
                    ? new Manager(managerless.getName(), manager)
                    : new Worker(managerless.getName(), manager);
            orgChart.addEmployee(withManager);
            expected.add(withManager);
        }

        loose.forEach(orgChart::addEmployee);
        assertEquals(
                "OrgChart#getDirectSubordinates() returned a set that did not equal the set of subordinates of a previously-added Manager after adding loose employees",
                expected, orgChart.getDirectSubordinates(manager));
    }

    @Property
    public void getFullHierarchyEmpty(@GenOrgChart OrgChart orgChart) {
        Map<Manager, Set<Employee>> hierarchy = orgChart.getFullHierarchy();
        assertNotNull("OrgChart#getFullHierarchy() returned a null value when called on an empty OrgChart", hierarchy);
        assertTrue("OrgChart#getFullHierarchy() returned a non-empty Map when called on an empty OrgChart", hierarchy.isEmpty());
    }

    @Property
    public void getFullHierarchyInitializesChildSets(@GenOrgChart OrgChart orgChart, @GenManager Manager manager) {
        orgChart.addEmployee(manager);
        Set<Employee> subordinates = orgChart.getFullHierarchy().get(manager);
        assertNotNull("OrgChart#getFullHierarchy() returned a map with a null value for a previously-added childless Manager key",
                subordinates);
        assertTrue("OrgChart#getFullHierarchy() returned a map with a non-empty set for a previously-added childless Manager key",
                subordinates.isEmpty());
    }

    @Property
    public void getFullHierarchyDefensiveCopy(@GenOrgChart OrgChart orgChart, @GenWorker(depth = 1) Worker worker) {
        Set<Employee> subordinates = new HashSet<>();
        subordinates.add(worker);
        Map<Manager, Set<Employee>> hierarchy = orgChart.getFullHierarchy();
        hierarchy.put(worker.getManager(), subordinates);
        assertFalse("OrgChart#getFullHierarchy() returned a live map that allowed external changes to the OrgChart",
                orgChart.hasEmployee(worker.getManager()));
        assertFalse("OrgChart#getFullHierarchy() returned a live map that allowed external changes to the OrgChart",
                orgChart.hasEmployee(worker));

        hierarchy = orgChart.getFullHierarchy();
        assertNotEquals("OrgChart#getFullHierarchy() returned a live map that allowed external changes to the OrgChart", subordinates,
                hierarchy.get(worker.getManager()));
        assertFalse("OrgChart#getFullHierarchy() returned a live map that allowed external changes to the OrgChart",
                hierarchy.containsKey(worker.getManager()));

        orgChart.addEmployee(worker.getManager());
        hierarchy = orgChart.getFullHierarchy();
        subordinates = hierarchy.get(worker.getManager());
        subordinates.add(worker);
        assertFalse("OrgChart#getFullHierarchy() returned a live map that allowed external changes to the OrgChart",
                orgChart.hasEmployee(worker));

        hierarchy = orgChart.getFullHierarchy();
        assertFalse("OrgChart#getFullHierarchy() returned a live map that allowed external changes to the OrgChart",
                hierarchy.get(worker.getManager()).contains(worker));
    }

    @Property
    public void getFullHierarchyConsistencyWithOneLevel(@GenOrgChart(depth = 5) OrgChart orgChart) {
        Map<Manager, Set<Employee>> hierarchy = orgChart.getFullHierarchy();
        Set<Manager> expectedManagers = orgChart.getAllManagers();
        assertEquals("OrgChart#getFullHierarchy() returned a map with a key set that did not match the OrgChart's managers",
                expectedManagers, hierarchy.keySet());
        Set<Employee> actualElements = new HashSet<>();
        for (Manager manager : expectedManagers) {
            actualElements.add(manager);
            Set<Employee> expectedSubordinates = orgChart.getDirectSubordinates(manager);
            actualElements.addAll(expectedSubordinates);
            assertEquals(
                    "OrgChart#getFullHierarchy() returned a map in which a key's associated set of values did not match the OrgChart's subordinates for that key",
                    expectedSubordinates, hierarchy.get(manager));
        }
        assertEquals(orgChart.getAllEmployees(), actualElements);
    }
}
