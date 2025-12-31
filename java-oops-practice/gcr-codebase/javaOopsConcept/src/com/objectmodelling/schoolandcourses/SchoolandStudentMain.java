package com.objectmodelling.schoolandcourses;

//Demonstration
public class SchoolandStudentMain{
 public static void main(String[] args) {
     // Create school
     School school = new School("Green Valley High School");

     // Create students
     Student s1 = new Student("Alice");
     Student s2 = new Student("Bob");

     // Add students to school (Aggregation)
     school.addStudent(s1);
     school.addStudent(s2);

     // Create courses
     Course math = new Course("Mathematics");
     Course science = new Course("Science");

     // Students enroll in courses (Association)
     s1.enrollInCourse(math);
     s1.enrollInCourse(science);

     s2.enrollInCourse(math);

     // Display school students
     school.showStudents();

     // Display student courses
     s1.showCourses();
     s2.showCourses();

     // Display course enrollments
     math.showEnrolledStudents();
     science.showEnrolledStudents();
 }
}
