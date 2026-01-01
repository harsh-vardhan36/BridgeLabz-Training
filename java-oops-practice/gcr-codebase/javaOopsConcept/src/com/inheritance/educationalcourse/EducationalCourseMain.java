package com.inheritance.educationalcourse;

public class EducationalCourseMain {
	public static void main(String[] args) {

        PaidOnlineCourse course = new PaidOnlineCourse(
                "Java Full Stack",
                150,
                "Khan Academy",
                true,
                5500,
                20
        );

        course.displayDetails();
    }
}
