package universitymanagement;

import java.util.ArrayList;
import java.util.List;

//Course class
public class Course {
 private String courseName;
 private Professor professor;
 private List<Student> students;

 public Course(String courseName) {
     this.courseName = courseName;
     this.students = new ArrayList<>();
 }

 public String getCourseName() {
     return courseName;
 }

 public void setProfessor(Professor professor) {
     this.professor = professor;
 }

 public Professor getProfessor() {
     return professor;
 }

 public void addStudent(Student student) {
     students.add(student);
 }

 public List<Student> getStudents() {
     return students;
 }

 public void showCourseDetails() {
     System.out.println("\nCourse: " + courseName);
     System.out.println("Professor: " + (professor != null ? professor.getName() : "None"));
     System.out.println("Enrolled Students:");
     for (Student s : students) {
         System.out.println("- " + s.getName());
     }
 }
}