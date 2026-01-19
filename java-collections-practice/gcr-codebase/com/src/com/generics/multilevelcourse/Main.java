package com.generics.multilevelcourse;

import java.util.*;
public class Main {
    public static void main(String[] args) {

        Course<ExamCourse> math =
                new Course<>(new ExamCourse("Mathematics"));

        Course<AssignmentCourse> programming =
                new Course<>(new AssignmentCourse("Java Programming"));

        Course<ResearchCourse> ai =
                new Course<>(new ResearchCourse("AI Research"));

        math.showCourseDetails();
        programming.showCourseDetails();
        ai.showCourseDetails();

        System.out.println("\nAll Courses:");

        List<CourseType> allCourses = new ArrayList<>();
        allCourses.add(new ExamCourse("Physics"));
        allCourses.add(new AssignmentCourse("Data Structures"));
        allCourses.add(new ResearchCourse("Machine Learning"));

        CourseUtil.displayAllCourses(allCourses);
    }
}
