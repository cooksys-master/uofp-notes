package com.cooksys.ftd.assignments.collections.generators;

import com.cooksys.ftd.assignments.collections.model.OrgChart;
import com.cooksys.ftd.assignments.collections.model.Manager;
import com.pholser.junit.quickcheck.generator.GenerationStatus;
import com.pholser.junit.quickcheck.generator.Generator;
import com.pholser.junit.quickcheck.random.SourceOfRandomness;

import java.util.HashSet;
import java.util.Set;

/**
 * Used internally by tests. Students do not need to change or understand this file.
 */
public class GenOrgCharts extends Generator<OrgChart> implements GenEmployees {
    private GenOrgChart genOrgChart;

    public GenOrgCharts() {
        super(OrgChart.class);
    }

    @Override
    public OrgChart generate(SourceOfRandomness random, GenerationStatus status) {
        if (genOrgChart != null) {
            int depth = Math.max(genOrgChart.depth(), 0);
            int width = Math.max(genOrgChart.width(), 0);
            int ratio = genOrgChart.ratio() >= 1 ? genOrgChart.depth() : 1;
            int size = width + (int) Math.ceil(status.size() / Math.pow(ratio, depth));
            return populate(random, depth, size, ratio);
        } else {
            return populate(random);
        }
    }

    public OrgChart populate(SourceOfRandomness random) {
        return populate(random, 0, 0, 1);
    }

    public OrgChart populate(SourceOfRandomness random, int depth, int size, int ratio) {
        OrgChart corp = new OrgChart();
        Set<Manager> parents = new HashSet<>();
        parents.add(null);
        while (depth > 0) {
            if (depth > 1) {
                parents.addAll(genManagers(random, size, parents));
            } else {
                genEmployees(random, size, parents).forEach(corp::addEmployee);
            }
            size *= ratio;
            depth--;
        }
        return corp;
    }

    public void configure(GenOrgChart genOrgChart) {
        this.genOrgChart = genOrgChart;
    }
}
