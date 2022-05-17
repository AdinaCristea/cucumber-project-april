package com.config;

import org.apache.logging.log4j.LogManager;
import org.junit.platform.engine.TestExecutionResult;
import org.junit.platform.launcher.TestExecutionListener;
import org.apache.logging.log4j.Logger;
import org.junit.platform.launcher.TestIdentifier;
import org.junit.platform.launcher.TestPlan;
import org.slf4j.event.Level;

import java.util.concurrent.atomic.AtomicInteger;

public class TestProgressListener implements TestExecutionListener {

    private static final Logger LOG = LogManager.getLogger(TestProgressListener.class);
    private final AtomicInteger testPassedCount= new AtomicInteger();
    private final AtomicInteger testFailedCount= new AtomicInteger();
    private final AtomicInteger testAbortedCount= new AtomicInteger();

    @Override
    public void testPlanExecutionStarted(TestPlan testPlan){
        LOG.info("Test plan started. Found {} tests",testPlan.countTestIdentifiers(TestIdentifier::isTest));
    }

    @Override
    public void executionStarted(TestIdentifier testIdentifier){
        if(testIdentifier.isTest()){
            LOG.info("Running scenario [{}]",testIdentifier.getDisplayName());
        }
    }

    //to be implemented for testFinished.
}

