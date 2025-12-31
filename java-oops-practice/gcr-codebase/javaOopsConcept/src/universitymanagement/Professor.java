package universitymanagement;

import java.util.ArrayList;
import java.util.List;

//Professor class
public class Professor {
 private String name;
 private List<Course> courses;

 public Professor(String name) {
     this.name = name;
     this.courses = new ArrayList<>();
 }

 public String getName() {
     return name;
 }

 public void assignCourse(Course course) {
     courses.add(course);
     course.setProfessor(this); // establish association
     System.out.println("Professor " + name + " assigned to course: " + course.getCourseName());
 }

 public List<Course> getCourses() {
     return courses;
 }
}
