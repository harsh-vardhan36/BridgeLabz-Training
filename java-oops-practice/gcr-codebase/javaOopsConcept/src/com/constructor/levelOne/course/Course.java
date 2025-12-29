package com.constructor.levelOne.course;

public class Course {
	// instance variables
		String courseName;
		double duration;
		double fees;
		// class variable
		static String instituteName = "TIT";
		
		// constructor
		Course(String cn, double d, double f ){
			courseName = cn;
			duration = d;
			fees = f;
		}
		
		// method to display output
		void displayCourseDetails() {
			 System.out.println("Institute Name : " + instituteName);
			System.out.println("Course name is :" + courseName + "\t  duration is : " + duration + " \t fees is : " + fees);
		}
		
		// method to update name of institute
		static void updateInstituteName(String newName) {
			instituteName = newName;
			
		}
}
