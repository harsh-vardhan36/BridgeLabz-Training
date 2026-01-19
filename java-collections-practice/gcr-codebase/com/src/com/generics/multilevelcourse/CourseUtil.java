package com.generics.multilevelcourse;

import java.util.*;

class CourseUtil {

    public static void displayAllCourses(
            List<? extends CourseType> courses) {

        for (CourseType c : courses) {
            System.out.println(
                c.getCourseName() + " | " + c.getEvaluationType()
            );
        }
    }
}
