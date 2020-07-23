package com.cooksys.ftd.assignments.collections.generators;

import com.cooksys.ftd.assignments.collections.model.Employee;
import com.cooksys.ftd.assignments.collections.model.Manager;
import com.cooksys.ftd.assignments.collections.model.Worker;
import com.pholser.junit.quickcheck.random.SourceOfRandomness;

import java.util.HashSet;
import java.util.Set;

/**
 * Used internally by tests. Students do not need to change or understand this file.
 */
public interface GenEmployees {

    default Employee genEmployee(SourceOfRandomness random) {
        return genEmployee(random, 0);
    }

    default Employee genEmployee(SourceOfRandomness random, int depth) {
        return genEmployee(random, depth, null);
    }

    default Employee genEmployee(SourceOfRandomness random, int depth, Manager root) {
        return genEmployee(random, genManager(random, depth, root));
    }

    default Employee genEmployee(SourceOfRandomness random, Manager parent) {
        if (random.nextBoolean()) {
            return genManager(random, parent);
        } else {
            return genWorker(random, parent);
        }
    }

    default Set<Employee> genEmployees(SourceOfRandomness random, int count) {
        return genEmployees(random, count, 0);
    }

    default Set<Employee> genEmployees(SourceOfRandomness random, int count, int depth) {
        return genEmployees(random, count, depth, (Manager) null);
    }

    default Set<Employee> genEmployees(SourceOfRandomness random, int count, int depth, Manager root) {
        Set<Manager> roots = new HashSet<>();
        roots.add(root);
        return genEmployees(random, count, roots);
    }

    default Set<Employee> genEmployees(SourceOfRandomness random, int count, int depth, Set<Manager> roots) {
        Set<Manager> parents = new HashSet<>();
        for (Manager root : roots) {
            parents.add(genManager(random, depth, root));
        }
        return genEmployees(random, count, parents);
    }

    default Set<Employee> genEmployees(SourceOfRandomness random, int count, Manager parent) {
        Set<Manager> parents = new HashSet<>();
        parents.add(parent);
        return genEmployees(random, count, parents);
    }

    default Set<Employee> genEmployees(SourceOfRandomness random, int count, Set<Manager> parents) {
        Set<Employee> result = new HashSet<>();
        for (int i = 0; i < count; i++) {
            result.add(genEmployee(random, random.choose(parents)));
        }
        return result;
    }

    default Manager genManager(SourceOfRandomness random) {
        return genManager(random, 0);
    }

    default Manager genManager(SourceOfRandomness random, int depth) {
        return genManager(random, depth, null);
    }

    default Manager genManager(SourceOfRandomness random, int depth, Manager root) {
        return genManager(random, depth > 0 ? genManager(random, depth - 1, root) : root);
    }

    default Manager genManager(SourceOfRandomness random, Manager parent) {
        String name = String.format("manager-%s", random.nextInt());
        return parent != null ? new Manager(name, parent) : new Manager(name);
    }

    default Set<Manager> genManagers(SourceOfRandomness random, int count) {
        return genManagers(random, count, 0);
    }

    default Set<Manager> genManagers(SourceOfRandomness random, int count, int depth) {
        return genManagers(random, count, depth, (Manager) null);
    }

    default Set<Manager> genManagers(SourceOfRandomness random, int count, int depth, Manager root) {
        Set<Manager> roots = new HashSet<>();
        roots.add(root);
        return genManagers(random, count, depth, roots);
    }

    default Set<Manager> genManagers(SourceOfRandomness random, int count, int depth, Set<Manager> roots) {
        Set<Manager> parents = new HashSet<>();
        for (Manager root : roots) {
            parents.add(genManager(random, depth, root));
        }
        return genManagers(random, count, parents);
    }

    default Set<Manager> genManagers(SourceOfRandomness random, int count, Manager parent) {
        Set<Manager> parents = new HashSet<>();
        parents.add(parent);
        return genManagers(random, count, parents);
    }

    default Set<Manager> genManagers(SourceOfRandomness random, int count, Set<Manager> parents) {
        Set<Manager> result = new HashSet<>();
        for (int i = 0; i < count; i++) {
            result.add(genManager(random, random.choose(parents)));
        }
        return result;
    }

    default Worker genWorker(SourceOfRandomness random) {
        return genWorker(random, 0);
    }

    default Worker genWorker(SourceOfRandomness random, int depth) {
        return genWorker(random, depth, null);
    }

    default Worker genWorker(SourceOfRandomness random, int depth, Manager root) {
        return genWorker(random, depth > 0 ? genManager(random, depth - 1, root) : root);
    }

    default Worker genWorker(SourceOfRandomness random, Manager parent) {
        String name = String.format("worker-%s", random.nextInt());
        return parent != null ? new Worker(name, parent) : new Worker(name);
    }

    default Set<Worker> genWorkers(SourceOfRandomness random, int count) {
        return genWorkers(random, count, 0);
    }

    default Set<Worker> genWorkers(SourceOfRandomness random, int count, int depth) {
        return genWorkers(random, count, depth, (Manager) null);
    }

    default Set<Worker> genWorkers(SourceOfRandomness random, int count, int depth, Manager root) {
        Set<Manager> roots = new HashSet<>();
        roots.add(root);
        return genWorkers(random, count, depth, roots);
    }

    default Set<Worker> genWorkers(SourceOfRandomness random, int count, int depth, Set<Manager> roots) {
        Set<Manager> parents = new HashSet<>();
        for (Manager root : roots) {
            parents.add(genManager(random, depth, root));
        }
        return genWorkers(random, count, parents);
    }

    default Set<Worker> genWorkers(SourceOfRandomness random, int count, Manager parent) {
        Set<Manager> parents = new HashSet<>();
        parents.add(parent);
        return genWorkers(random, count, parents);
    }

    default Set<Worker> genWorkers(SourceOfRandomness random, int count, Set<Manager> parents) {
        Set<Worker> result = new HashSet<>();
        for (int i = 0; i < count; i++) {
            result.add(genWorker(random, random.choose(parents)));
        }
        return result;
    }
}
