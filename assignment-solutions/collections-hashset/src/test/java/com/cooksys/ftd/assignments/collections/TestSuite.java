package com.cooksys.ftd.assignments.collections;

import com.cooksys.ftd.assignments.collections.properties.ManagerProperties;
import com.cooksys.ftd.assignments.collections.properties.OrgChartProperties;
import com.cooksys.ftd.assignments.collections.properties.WorkerProperties;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * TODO: Students should run this test suite to verify that their code passes the included tests.
 *  This test suite is a composite of three other test classes - {@code WorkerProperties}, {@code ManagerProperties},
 *  and {@code OrgChartProperties}. Refer to those classes for individual tests and comments on them. You may want to
 *  start by running the individual {@code Properties} classes by themselves - the comments in each class explain more.
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({ WorkerProperties.class, ManagerProperties.class, OrgChartProperties.class })
public class TestSuite {
}
