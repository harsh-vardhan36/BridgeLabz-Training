package com.healthclinic_app;

import com.healthclinic_app.dao.*;
import com.healthclinic_app.model.*;
import java.sql.Timestamp;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DoctorDAO doctorDAO = new DoctorDAO();
        PatientDAO patientDAO = new PatientDAO();
        AppointmentDAO appointmentDAO = new AppointmentDAO();
        DoctorStatsDAO statsDAO = new DoctorStatsDAO();

        while (true) {
            System.out.println("\n=== Health Clinic CLI ===");
            System.out.println("1. Add Doctor");
            System.out.println("2. View Doctors");
            System.out.println("3. Update Doctor");
            System.out.println("4. Delete Doctor");
            System.out.println("5. Add Patient");
            System.out.println("6. View Patients");
            System.out.println("7. Update Patient");
            System.out.println("8. Delete Patient");
            System.out.println("9. Schedule Appointment");
            System.out.println("10. View Appointments");
            System.out.println("11. Update Appointment");
            System.out.println("12. Delete Appointment");
            System.out.println("13. View Doctor Stats");
            System.out.println("14. Exit");
            System.out.print("Choose an option: ");

            int choice = -1;
            try {
                choice = sc.nextInt();
                sc.nextLine(); // consume newline
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                sc.nextLine(); // clear invalid input
                continue;
            }

            switch (choice) {
                case 1:
                    // Add Doctor
                    System.out.print("Enter doctor name: ");
                    String dName = sc.nextLine();
                    System.out.print("Enter phone: ");
                    String dPhone = sc.nextLine();
                    System.out.print("Enter email: ");
                    String dEmail = sc.nextLine();
                    System.out.print("Enter experience years: ");
                    int exp = safeIntInput(sc);
                    System.out.print("Enter fees: ");
                    double fees = safeDoubleInput(sc);

                    Doctor doc = new Doctor();
                    doc.setName(dName);
                    doc.setPhone(dPhone);
                    doc.setEmail(dEmail);
                    doc.setExperienceYears(exp);
                    doc.setFees(fees);
                    doc.setJoinedAt(new Timestamp(System.currentTimeMillis()));
                    doctorDAO.insertDoctor(doc);
                    break;

                case 2:
                    // View Doctors
                    List<Doctor> doctors = doctorDAO.getAllDoctors();
                    System.out.println("ID "+"   Name            "+ " Phone          "+"Email             "+"Fees       "+ " Experience Years" );
                    doctors.forEach(d -> System.out.println(d.getDoctorId() + " - " + d.getName() + " - "+d.getPhone()+ " - "+d.getEmail()+" - "+d.getFees()+" - "+d.getExperienceYears()));
                    break;

                case 3:
                    // Update Doctor
                    int docId = safeIntInput(sc, "Enter doctor ID to update: ");
                    Doctor existingDoc = doctorDAO.getDoctorById(docId);
                    if (existingDoc != null) {
                        System.out.print("Enter new fees: ");
                        double newFees = safeDoubleInput(sc);
                        existingDoc.setFees(newFees);
                        doctorDAO.updateDoctor(existingDoc);
                    } else {
                        System.out.println("Doctor not found.");
                    }
                    break;

                case 4:
                    // Delete Doctor
                    int delDocId = safeIntInput(sc, "Enter doctor ID to delete: ");
                    doctorDAO.deleteDoctor(delDocId);
                    break;

                case 5:
                    // Add Patient
                    System.out.print("Enter patient name: ");
                    String pName = sc.nextLine();
                    int age = safeIntInput(sc, "Enter age: ");
                    System.out.print("Enter gender: ");
                    String gender = sc.nextLine();
                    System.out.print("Enter phone: ");
                    String pPhone = sc.nextLine();
                    System.out.print("Enter address: ");
                    String address = sc.nextLine();

                    Patient pat = new Patient();
                    pat.setName(pName);
                    pat.setAge(age);
                    pat.setGender(gender);
                    pat.setPhone(pPhone);
                    pat.setAddress(address);
                    pat.setJoinedAt(new Timestamp(System.currentTimeMillis()));
                    patientDAO.insertPatient(pat);
                    break;

                case 6:
                    // View Patients
                    List<Patient> patients = patientDAO.getAllPatients();
                    patients.forEach(p -> System.out.println(p.getPatientId() + " - " + p.getName()));
                    break;

                case 7:
                    // Update Patient
                    int patId = safeIntInput(sc, "Enter patient ID to update: ");
                    Patient existingPat = patientDAO.getPatientById(patId);
                    if (existingPat != null) {
                        System.out.print("Enter new address: ");
                        String newAddr = sc.nextLine();
                        existingPat.setAddress(newAddr);
                        patientDAO.updatePatient(existingPat);
                    } else {
                        System.out.println("Patient not found.");
                    }
                    break;

                case 8:
                    // Delete Patient
                    int delPatId = safeIntInput(sc, "Enter patient ID to delete: ");
                    patientDAO.deletePatient(delPatId);
                    break;

                case 9:
                    // Schedule Appointment
                    int doctorId = safeIntInput(sc, "Enter doctor ID: ");
                    int patientId = safeIntInput(sc, "Enter patient ID: ");
                    System.out.print("Enter status: ");
                    String status = sc.nextLine();
                    System.out.print("Enter diagnosis: ");
                    String diagnosis = sc.nextLine();

                    Appointment appt = new Appointment();
                    appt.setDoctorId(doctorId);
                    appt.setPatientId(patientId);
                    appt.setAppointmentTime(new Timestamp(System.currentTimeMillis()));
                    appt.setStatus(status);
                    appt.setDiagnosis(diagnosis);
                    appointmentDAO.insertAppointment(appt);
                    break;

                case 10:
                    // View Appointments
                    List<Appointment> appts = appointmentDAO.getAllAppointments();
                    appts.forEach(a -> System.out.println("Appt ID: " + a.getAppointmentId() +
                                                          " | Doctor: " + a.getDoctorId() +
                                                          " | Patient: " + a.getPatientId() +
                                                          " | Status: " + a.getStatus()));
                    break;

                case 11:
                    // Update Appointment
                    int apptId = safeIntInput(sc, "Enter appointment ID to update: ");
                    Appointment existingAppt = appointmentDAO.getAppointmentById(apptId);
                    if (existingAppt != null) {
                        System.out.print("Enter new status: ");
                        String newStatus = sc.nextLine();
                        existingAppt.setStatus(newStatus);
                        appointmentDAO.updateAppointment(existingAppt);
                    } else {
                        System.out.println("Appointment not found.");
                    }
                    break;

                case 12:
                    // Delete Appointment
                    int delApptId = safeIntInput(sc, "Enter appointment ID to delete: ");
                    appointmentDAO.deleteAppointment(delApptId);
                    break;

                case 13:
                    // View Doctor Stats
                    statsDAO.getAllDoctorStats().forEach(stats ->
                        System.out.println("Doctor ID: " + stats.getDoctorId() +
                                           " | Total Patients: " + stats.getTotalPatients()));
                    break;

                case 14:
                    System.out.println("Exiting CLI...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    // Helper methods for safe input
    private static int safeIntInput(Scanner sc) {
        while (true) {
            try {
                return sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                sc.nextLine();
            }
        }
    }

    private static int safeIntInput(Scanner sc, String prompt) {
        System.out.print(prompt);
        return safeIntInput(sc);
    }

    private static double safeDoubleInput(Scanner sc) {
        while (true) {
            try {
                return sc.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a decimal number.");
                sc.nextLine();
            }
        }
    }
}
