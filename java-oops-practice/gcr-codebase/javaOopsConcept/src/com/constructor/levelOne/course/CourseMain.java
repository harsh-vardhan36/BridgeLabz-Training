package com.constructor.levelOne.course;

public class CourseMain {
	public static void main(String[] args) {

        Course c1 = new Course("Java Full Stack", 6, 45000);

        // Display initial details
        c1.displayCourseDetails();

        // Update institute name
        Course.updateInstituteName("Technocrats Institute");

        // Display details after update
        c1.displayCourseDetails();
	}
}
