package universitymanagement;

//Main class to test
public class UniversityMain {
 public static void main(String[] args) {
     // Create students
     Student s1 = new Student("Alice");
     Student s2 = new Student("Bob");

     // Create professors
     Professor p1 = new Professor("Dr. Smith");
     Professor p2 = new Professor("Dr. Johnson");

     // Create courses
     Course c1 = new Course("Computer Science");
     Course c2 = new Course("Mathematics");

     // Assign professors
     p1.assignCourse(c1);
     p2.assignCourse(c2);

     // Students enroll in courses
     s1.enrollCourse(c1);
     s1.enrollCourse(c2);
     s2.enrollCourse(c1);

     // Show course details
     c1.showCourseDetails();
     c2.showCourseDetails();
 }
}
