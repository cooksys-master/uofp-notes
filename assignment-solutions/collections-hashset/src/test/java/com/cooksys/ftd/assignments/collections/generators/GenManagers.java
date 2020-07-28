package com.cooksys.ftd.assignments.collections.generators;

import com.cooksys.ftd.assignments.collections.model.Manager;
import com.pholser.junit.quickcheck.generator.GenerationStatus;
import com.pholser.junit.quickcheck.generator.Generator;
import com.pholser.junit.quickcheck.random.SourceOfRandomness;

/**
 * Used internally by tests. Students do not need to change or understand this file.
 */
public class GenManagers extends Generator<Manager> implements GenEmployees {
    private GenEmployee genEmployee;
    private GenManager genManager;

    public GenManagers() {
        super(Manager.class);
    }

    public Manager generate(SourceOfRandomness random, GenerationStatus status) {
        int depth = genEmployee != null ? genEmployee.depth() : genManager != null ? genManager.depth() : -1;
        return genManager(random, depth >= 0 ? depth : status.size());
    }

    public void configure(GenEmployee genEmployee) {
        this.genEmployee = genEmployee;
    }

    public void configure(GenManager genManager) {
        this.genManager = genManager;
    }
}
