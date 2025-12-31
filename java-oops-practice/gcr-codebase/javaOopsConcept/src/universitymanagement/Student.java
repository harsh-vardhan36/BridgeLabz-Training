package universitymanagement;

import java.util.ArrayList;
import java.util.List;

// Student class
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

    public void enrollCourse(Course course) {
        courses.add(course);
        course.addStudent(this); // establish two-way association
        System.out.println(name + " enrolled in course: " + course.getCourseName());
    }

    public List<Course> getCourses() {
        return courses;
    }
}

