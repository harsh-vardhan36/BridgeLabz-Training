package com.linkedlist.taskscheduler;

public class Task {
    int taskId;
    String taskName;
    int priority;
    String dueDate;

    Task(int taskId, String taskName, int priority, String dueDate) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.priority = priority;
        this.dueDate = dueDate;
    }
}
