package com.generics.multilevelcourse;

class Course<T extends CourseType> {
    private T course;

    public Course(T course) {
        this.course = course;
    }

    public T getCourse() {
        return course;
    }

    public void showCourseDetails() {
        System.out.println(
            course.getCourseName() + " | " + course.getEvaluationType()
        );
    }
}
