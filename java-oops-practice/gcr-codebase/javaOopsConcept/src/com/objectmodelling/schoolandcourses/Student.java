package com.objectmodelling.schoolandcourses;

import java.util.ArrayList;
import java.util.List;

//Student class
public class Student {
 private String name;
 private List<Course> courses;

 public Student(String name) {
     this.name = name;
     this.courses = new ArrayList<>();
 }

 public String getName() {
     return name;
 }

 // Enroll in a course (association both ways)
 public void enrollInCourse(Course course) {
     courses.add(course);
     course.enrollStudent(this); // maintain bidirectional association
 }

 // Show courses enrolled
 public void showCourses() {
     System.out.println("Student: " + name + " | Enrolled Courses:");
     for (Course c : courses) {
         System.out.println("- " + c.getCourseName());
     }
 }
}
