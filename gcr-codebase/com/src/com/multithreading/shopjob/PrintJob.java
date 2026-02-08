package com.multithreading.shopjob;

public class PrintJob implements Runnable {

    private String jobName;
    private int pages;
    private int priority;

    public PrintJob(String jobName, int pages, int priority) {
        this.jobName = jobName;
        this.pages = pages;
        this.priority = priority;
    }

    @Override
    public void run() {

        String level;

        if (priority >= 8) {
            level = "[High Priority]";
        } else if (priority >= 5) {
            level = "[Medium Priority]";
        } else {
            level = "[Low Priority]";
        }

        System.out.println(level + " Started " + jobName +
                " (" + pages + " pages, Priority " + priority + ")");

        try {
            for (int i = 1; i <= pages; i++) {

                System.out.println(level + " Printing " + jobName +
                        " - Page " + i + " of " + pages);

                Thread.sleep(100); // 100ms per page
            }

            System.out.println(level + " Completed " + jobName + " \n");

        } catch (InterruptedException e) {
            System.out.println(jobName + " interrupted during printing!");
        }
    }

    public int getPriority() {
        return priority;
    }
}
