package com.annotation.pendingtask;

class ProjectFeatures {

    @Todo(
        task = "Implement user authentication",
        assignedTo = "Harsh",
        priority = "HIGH"
    )
    public void loginFeature() {
        // pending
    }

    @Todo(
        task = "Add email notifications",
        assignedTo = "Aman"
    )
    public void notificationFeature() {
        // pending
    }

    @Todo(
        task = "Optimize database queries",
        assignedTo = "Riya",
        priority = "LOW"
    )
    public void optimizationFeature() {
        // pending
    }
}
