package com.cooksys.ftd.assignments.collections.generators;

import com.pholser.junit.quickcheck.From;
import com.pholser.junit.quickcheck.generator.GeneratorConfiguration;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Used internally by tests. Students do not need to change or understand this file.
 */
@Target({PARAMETER, FIELD, ANNOTATION_TYPE, TYPE_USE})
@Retention(RUNTIME)
@GeneratorConfiguration
@From(GenOrgCharts.class)
public @interface GenOrgChart {
    int depth() default 0;
    int width() default 0;
    int ratio() default 1;
}
