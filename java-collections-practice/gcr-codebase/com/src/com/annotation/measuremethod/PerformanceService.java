package com.annotation.measuremethod;

class PerformanceService {

    @LogExecutionTime
    public void fastTask() {
        for (int i = 0; i < 1_000; i++) {
            // small task
        }
    }

    @LogExecutionTime
    public void slowTask() {
        for (int i = 0; i < 10_000_000; i++) {
            // heavy task
        }
    }

    public void normalTask() {
        System.out.println("No logging here");
    }
}
