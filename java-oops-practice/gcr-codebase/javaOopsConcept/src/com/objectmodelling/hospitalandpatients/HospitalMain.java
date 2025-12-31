package com.objectmodelling.hospitalandpatients;

//Main class to test
public class HospitalMain {
 public static void main(String[] args) {
     Hospital hospital = new Hospital();

     Doctor d1 = new Doctor("Smith");
     Doctor d2 = new Doctor("Johnson");

     Patient p1 = new Patient("Alice");
     Patient p2 = new Patient("Bob");

     hospital.addDoctor(d1);
     hospital.addDoctor(d2);
     hospital.addPatient(p1);
     hospital.addPatient(p2);

     // Consultations
     d1.consult(p1);
     d1.consult(p2);
     d2.consult(p1);

     // Show associations
     System.out.println("\nPatients of Dr. Smith: ");
     for (Patient p : d1.getPatients()) {
         System.out.println("- " + p.getName());
     }

     System.out.println("\nDoctors consulted by Alice: ");
     for (Doctor d : p1.getDoctors()) {
         System.out.println("- Dr. " + d.getName());
     }
 }
}
