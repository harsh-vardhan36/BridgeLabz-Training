package com.skillforge;

import java.util.*;

public class Course implements ICertifiable {

    private String title;
    private String instructor;
    private List<String> modules;
    private List<Integer> reviews = new ArrayList<>();
    private double rating;

    public Course(String title, String instructor) {
        this.title = title;
        this.instructor = instructor;
        this.modules = new ArrayList<>();
        modules.add("Introduction");
        modules.add("Basics");
        modules.add("Final Project");
    }

    public Course(String title, String instructor, List<String> modules) {
        this.title = title;
        this.instructor = instructor;
        this.modules = modules;
    }

    private void calculateRating() {
        int sum = 0;
        for (int r : reviews) sum += r;
        rating = (double) sum / reviews.size();
    }

    public void addReview(int stars) {
        reviews.add(stars);
        calculateRating();
    }

    public double getRating() {
        return rating;
    }

    public List<Integer> getReviews() {
        return Collections.unmodifiableList(reviews);
    }

    public int getTotalModules() {
        return modules.size();
    }

    public String getTitle() {
        return title;
    }

    @Override
    public void generateCertificate(Student student) {
        int grade = student.getGrade(this);

        if (grade >= 85)
            System.out.println("Advanced Certificate for " + student.name);
        else
            System.out.println("Basic Certificate for " + student.name);
    }
}

