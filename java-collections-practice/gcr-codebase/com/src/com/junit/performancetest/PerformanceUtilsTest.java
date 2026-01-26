package com.junit.performancetest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

class PerformanceUtilsTest {

    PerformanceUtils utils = new PerformanceUtils();

    @Test
    @Timeout(2) // seconds
    void testLongRunningTaskTimeout() throws InterruptedException {
        utils.longRunningTask();
    }
}
