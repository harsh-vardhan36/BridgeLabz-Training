package com.junit.performancetest;

public class PerformanceUtils {

    public String longRunningTask() throws InterruptedException {
        Thread.sleep(3000); // 3 seconds
        return "Done";
    }
}
