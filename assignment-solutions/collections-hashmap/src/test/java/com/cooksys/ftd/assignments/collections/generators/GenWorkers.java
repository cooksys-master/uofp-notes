package com.cooksys.ftd.assignments.collections.generators;

import com.cooksys.ftd.assignments.collections.model.Worker;
import com.pholser.junit.quickcheck.generator.GenerationStatus;
import com.pholser.junit.quickcheck.generator.Generator;
import com.pholser.junit.quickcheck.random.SourceOfRandomness;

/**
 * Used internally by tests. Students do not need to change or understand this file.
 */
public class GenWorkers extends Generator<Worker> implements GenEmployees {
    private GenEmployee genEmployee;
    private GenWorker genWorker;

    public GenWorkers() {
        super(Worker.class);
    }

    public Worker generate(SourceOfRandomness random, GenerationStatus status) {
        int depth = genEmployee != null ? genEmployee.depth() : genWorker != null ? genWorker.depth() : -1;
        return genWorker(random, depth >= 0 ? depth : status.size());
    }

    public void configure(GenEmployee genEmployee) {
        this.genEmployee = genEmployee;
    }

    public void configure(GenWorker genWorker) {
        this.genWorker = genWorker;
    }
}
