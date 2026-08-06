package com.healthclinic_app;

import com.healthclinic_app.dao.*;
import com.healthclinic_app.db.DatabaseInitializer;
import com.healthclinic_app.model.*;
import com.healthclinic_app.service.AppointmentService;
import com.healthclinic_app.service.PatientService;
import com.healthclinic_app.service.ReportService;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static final DoctorDAO doctorDAO = new DoctorDAO();
    private static final PatientDAO patientDAO = new PatientDAO();
    private static final AppointmentDAO appointmentDAO = new AppointmentDAO();
    private static final DoctorStatsDAO statsDAO = new DoctorStatsDAO();
    private static final BillDAO billDAO = new BillDAO();
    private static final SpecializationDAO specializationDAO = new SpecializationDAO();
    private static final DoctorSpecializationDAO doctorSpecializationDAO = new DoctorSpecializationDAO();

    private static final AppointmentService appointmentService = new AppointmentService();
    private static final PatientService patientService = new PatientService();
    private static final ReportService reportService = new ReportService();

    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        DatabaseInitializer.initialize();

        while (true) {
            System.out.println("\n========== Health Clinic ==========");
            System.out.println("1. Manage Doctors");
            System.out.println("2. Manage Patients");
            System.out.println("3. Manage Appointments");
            System.out.println("4. Manage Bills");
            System.out.println("5. Manage Specializations");
            System.out.println("6. Reports");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");

            int choice = safeIntInput(sc);
            switch (choice) {
                case 1: doctorMenu(); break;
                case 2: patientMenu(); break;
                case 3: appointmentMenu(); break;
                case 4: billMenu(); break;
                case 5: specializationMenu(); break;
                case 6: reportMenu(); break;
                case 7:
                    System.out.println("Exiting...");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    // ============================== DOCTOR MENU ==============================

    private static void doctorMenu() {
        while (true) {
            System.out.println("\n----- Manage Doctors -----");
            System.out.println("1. Add Doctor");
            System.out.println("2. View All Doctors");
            System.out.println("3. Find Doctor by ID");
            System.out.println("4. Update Doctor");
            System.out.println("5. Delete Doctor");
            System.out.println("6. Back");
            System.out.print("Choose an option: ");

            int choice = safeIntInput(sc);
            switch (choice) {
                case 1: addDoctor(); break;
                case 2: viewAllDoctors(); break;
                case 3: findDoctorById(); break;
                case 4: updateDoctor(); break;
                case 5: deleteDoctor(); break;
                case 6: return;
                default: System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private static void addDoctor() {
        System.out.print("Enter doctor name: ");
        String dName = sc.nextLine();
        System.out.print("Enter phone: ");
        String dPhone = sc.nextLine();
        System.out.print("Enter email: ");
        String dEmail = sc.nextLine();
        int exp = safeIntInput(sc, "Enter experience years: ");
        double fees = safeDoubleInput(sc, "Enter fees: ");

        Doctor doc = new Doctor();
        doc.setName(dName);
        doc.setPhone(dPhone);
        doc.setEmail(dEmail);
        doc.setExperienceYears(exp);
        doc.setFees(fees);
        doc.setJoinedAt(new Timestamp(System.currentTimeMillis()));
        doctorDAO.insertDoctor(doc);
    }

    private static void viewAllDoctors() {
        List<Doctor> doctors = doctorDAO.getAllDoctors();
        if (doctors.isEmpty()) {
            System.out.println("No doctors on record.");
            return;
        }
        System.out.printf("%-4s %-20s %-15s %-25s %-10s %s%n",
                "ID", "Name", "Phone", "Email", "Fees", "Experience");
        for (Doctor d : doctors) {
            System.out.printf("%-4d %-20s %-15s %-25s %-10.2f %d%n",
                    d.getDoctorId(), d.getName(), d.getPhone(), d.getEmail(), d.getFees(), d.getExperienceYears());
        }
    }

    private static void findDoctorById() {
        int id = safeIntInput(sc, "Enter doctor ID: ");
        Doctor doc = doctorDAO.getDoctorById(id);
        if (doc == null) {
            System.out.println("Doctor not found.");
        } else {
            System.out.println(doc);
        }
    }

    private static void updateDoctor() {
        int docId = safeIntInput(sc, "Enter doctor ID to update: ");
        Doctor existingDoc = doctorDAO.getDoctorById(docId);
        if (existingDoc == null) {
            System.out.println("Doctor not found.");
            return;
        }
        System.out.println("Current details: " + existingDoc);
        System.out.print("Enter new phone (leave blank to keep unchanged): ");
        String phone = sc.nextLine();
        if (!phone.isBlank()) existingDoc.setPhone(phone);

        System.out.print("Enter new email (leave blank to keep unchanged): ");
        String email = sc.nextLine();
        if (!email.isBlank()) existingDoc.setEmail(email);

        double newFees = safeDoubleInput(sc, "Enter new fees (enter -1 to keep unchanged): ");
        if (newFees >= 0) existingDoc.setFees(newFees);

        doctorDAO.updateDoctor(existingDoc);
    }

    private static void deleteDoctor() {
        int delDocId = safeIntInput(sc, "Enter doctor ID to delete: ");
        doctorDAO.deleteDoctor(delDocId);
    }

    // ============================== PATIENT MENU ==============================

    private static void patientMenu() {
        while (true) {
            System.out.println("\n----- Manage Patients -----");
            System.out.println("1. Add Patient");
            System.out.println("2. View All Patients");
            System.out.println("3. Find Patient by ID");
            System.out.println("4. Update Patient");
            System.out.println("5. Delete Patient");
            System.out.println("6. Back");
            System.out.print("Choose an option: ");

            int choice = safeIntInput(sc);
            switch (choice) {
                case 1: addPatient(); break;
                case 2: viewAllPatients(); break;
                case 3: findPatientById(); break;
                case 4: updatePatient(); break;
                case 5: deletePatient(); break;
                case 6: return;
                default: System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private static void addPatient() {
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
    }

    private static void viewAllPatients() {
        List<Patient> patients = patientDAO.getAllPatients();
        if (patients.isEmpty()) {
            System.out.println("No patients on record.");
            return;
        }
        System.out.printf("%-4s %-20s %-4s %-8s %-15s %s%n",
                "ID", "Name", "Age", "Gender", "Phone", "Address");
        for (Patient p : patients) {
            System.out.printf("%-4d %-20s %-4d %-8s %-15s %s%n",
                    p.getPatientId(), p.getName(), p.getAge(), p.getGender(), p.getPhone(), p.getAddress());
        }
    }

    private static void findPatientById() {
        int id = safeIntInput(sc, "Enter patient ID: ");
        Patient pat = patientDAO.getPatientById(id);
        if (pat == null) {
            System.out.println("Patient not found.");
        } else {
            System.out.println(pat);
        }
    }

    private static void updatePatient() {
        int patId = safeIntInput(sc, "Enter patient ID to update: ");
        Patient existingPat = patientDAO.getPatientById(patId);
        if (existingPat == null) {
            System.out.println("Patient not found.");
            return;
        }
        System.out.println("Current details: " + existingPat);
        System.out.print("Enter new phone (leave blank to keep unchanged): ");
        String phone = sc.nextLine();
        if (!phone.isBlank()) existingPat.setPhone(phone);

        System.out.print("Enter new address (leave blank to keep unchanged): ");
        String newAddr = sc.nextLine();
        if (!newAddr.isBlank()) existingPat.setAddress(newAddr);

        patientDAO.updatePatient(existingPat);
    }

    // Deletes the patient along with their appointments/bills in one
    // transaction (see PatientService).
    private static void deletePatient() {
        int delPatId = safeIntInput(sc, "Enter patient ID to delete: ");
        System.out.print("This will also delete all of this patient's appointments and bills. Continue? (y/n): ");
        String confirm = sc.nextLine();
        if (!confirm.equalsIgnoreCase("y")) {
            System.out.println("Cancelled.");
            return;
        }
        patientService.deletePatientCascade(delPatId);
    }

    // ============================== APPOINTMENT MENU ==============================

    private static void appointmentMenu() {
        while (true) {
            System.out.println("\n----- Manage Appointments -----");
            System.out.println("1. Book Appointment");
            System.out.println("2. View All Appointments");
            System.out.println("3. Find Appointment by ID");
            System.out.println("4. Update Appointment");
            System.out.println("5. Cancel Appointment");
            System.out.println("6. Delete Appointment");
            System.out.println("7. Back");
            System.out.print("Choose an option: ");

            int choice = safeIntInput(sc);
            switch (choice) {
                case 1: bookAppointment(); break;
                case 2: viewAllAppointments(); break;
                case 3: findAppointmentById(); break;
                case 4: updateAppointmentStatus(); break;
                case 5: cancelAppointment(); break;
                case 6: deleteAppointment(); break;
                case 7: return;
                default: System.out.println("Invalid choice. Try again.");
            }
        }
    }

    // Books through sp_book_appointment - the matching bill gets
    // created automatically once the insert goes through.
    private static void bookAppointment() {
        int doctorId = safeIntInput(sc, "Enter doctor ID: ");
        int patientId = safeIntInput(sc, "Enter patient ID: ");
        System.out.print("Enter status (e.g. SCHEDULED): ");
        String status = sc.nextLine();
        System.out.print("Enter diagnosis/notes: ");
        String diagnosis = sc.nextLine();

        try {
            AppointmentService.BookingResult result =
                    appointmentService.bookAppointment(doctorId, patientId, status, diagnosis);
            System.out.println("Appointment booked! Appointment ID: " + result.appointmentId);
            printReceipt(result.appointmentId, result.billAmount);
        } catch (SQLException e) {
            System.out.println("Could not book appointment: " + e.getMessage());
        }
    }

    private static void printReceipt(int appointmentId, double amount) {
        System.out.println("\n--- Bill Receipt ---");
        System.out.println("Appointment ID : " + appointmentId);
        System.out.printf("Amount Due     : %.2f%n", amount);
        System.out.println("Status         : UNPAID");
        System.out.println("--------------------\n");
    }

    private static void viewAllAppointments() {
        List<Appointment> appts = appointmentDAO.getAllAppointments();
        if (appts.isEmpty()) {
            System.out.println("No appointments on record.");
            return;
        }
        appts.forEach(a -> System.out.println("Appt ID: " + a.getAppointmentId() +
                " | Doctor: " + a.getDoctorId() +
                " | Patient: " + a.getPatientId() +
                " | Time: " + a.getAppointmentTime() +
                " | Status: " + a.getStatus() +
                " | Diagnosis: " + a.getDiagnosis()));
    }

    private static void findAppointmentById() {
        int id = safeIntInput(sc, "Enter appointment ID: ");
        Appointment appt = appointmentDAO.getAppointmentById(id);
        if (appt == null) {
            System.out.println("Appointment not found.");
        } else {
            System.out.println(appt);
        }
    }

    private static void updateAppointmentStatus() {
        int apptId = safeIntInput(sc, "Enter appointment ID to update: ");
        Appointment existingAppt = appointmentDAO.getAppointmentById(apptId);
        if (existingAppt == null) {
            System.out.println("Appointment not found.");
            return;
        }
        System.out.print("Enter new status: ");
        String newStatus = sc.nextLine();
        existingAppt.setStatus(newStatus);
        System.out.print("Enter new diagnosis/notes (leave blank to keep unchanged): ");
        String newDiagnosis = sc.nextLine();
        if (!newDiagnosis.isBlank()) existingAppt.setDiagnosis(newDiagnosis);
        appointmentDAO.updateAppointment(existingAppt);
    }

    // Cancels the appointment and voids its bill together (one
    // transaction, see AppointmentService).
    private static void cancelAppointment() {
        int apptId = safeIntInput(sc, "Enter appointment ID to cancel: ");
        appointmentService.cancelAppointment(apptId);
    }

    private static void deleteAppointment() {
        int delApptId = safeIntInput(sc, "Enter appointment ID to delete: ");
        appointmentDAO.deleteAppointment(delApptId);
    }

    // ============================== BILL MENU ==============================

    private static void billMenu() {
        while (true) {
            System.out.println("\n----- Manage Bills -----");
            System.out.println("1. View All Bills");
            System.out.println("2. Find Bill by ID");
            System.out.println("3. View Bills for a Patient");
            System.out.println("4. Mark Bill as Paid");
            System.out.println("5. Delete Bill");
            System.out.println("6. Back");
            System.out.print("Choose an option: ");

            int choice = safeIntInput(sc);
            switch (choice) {
                case 1: viewAllBills(); break;
                case 2: findBillById(); break;
                case 3: viewBillsForPatient(); break;
                case 4: markBillPaid(); break;
                case 5: deleteBill(); break;
                case 6: return;
                default: System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private static void viewAllBills() {
        List<Bill> bills = billDAO.getAllBills();
        if (bills.isEmpty()) {
            System.out.println("No bills on record.");
            return;
        }
        System.out.printf("%-6s %-8s %-8s %-8s %-10s %-10s %s%n",
                "BillID", "ApptID", "PatID", "DocID", "Amount", "Status", "Generated At");
        for (Bill b : bills) {
            System.out.printf("%-6d %-8d %-8d %-8d %-10.2f %-10s %s%n",
                    b.getBillId(), b.getAppointmentId(), b.getPatientId(), b.getDoctorId(),
                    b.getAmount(), b.getStatus(), b.getGeneratedAt());
        }
    }

    private static void findBillById() {
        int id = safeIntInput(sc, "Enter bill ID: ");
        Bill bill = billDAO.getBillById(id);
        if (bill == null) {
            System.out.println("Bill not found.");
        } else {
            System.out.println(bill);
        }
    }

    private static void viewBillsForPatient() {
        int patientId = safeIntInput(sc, "Enter patient ID: ");
        List<Bill> bills = billDAO.getBillsByPatientId(patientId);
        if (bills.isEmpty()) {
            System.out.println("No bills found for this patient.");
            return;
        }
        double total = 0;
        for (Bill b : bills) {
            System.out.println(b);
            if (!"CANCELLED".equalsIgnoreCase(b.getStatus())) {
                total += b.getAmount();
            }
        }
        System.out.printf("Total billed (excluding cancelled): %.2f%n", total);
    }

    private static void markBillPaid() {
        int billId = safeIntInput(sc, "Enter bill ID to mark as paid: ");
        billDAO.updateBillStatus(billId, "PAID");
    }

    private static void deleteBill() {
        int billId = safeIntInput(sc, "Enter bill ID to delete: ");
        billDAO.deleteBill(billId);
    }

    // ============================== SPECIALIZATION MENU ==============================

    private static void specializationMenu() {
        while (true) {
            System.out.println("\n----- Manage Specializations -----");
            System.out.println("1. Add Specialization");
            System.out.println("2. View All Specializations");
            System.out.println("3. Assign Specialization to Doctor");
            System.out.println("4. Remove Specialization from Doctor");
            System.out.println("5. View Specializations for a Doctor");
            System.out.println("6. View Doctors for a Specialization");
            System.out.println("7. Back");
            System.out.print("Choose an option: ");

            int choice = safeIntInput(sc);
            switch (choice) {
                case 1: addSpecialization(); break;
                case 2: viewAllSpecializations(); break;
                case 3: assignSpecializationToDoctor(); break;
                case 4: removeSpecializationFromDoctor(); break;
                case 5: viewSpecializationsForDoctor(); break;
                case 6: viewDoctorsForSpecialization(); break;
                case 7: return;
                default: System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private static void addSpecialization() {
        System.out.print("Enter specialization name (e.g. Cardiology): ");
        String name = sc.nextLine();
        Specialization sp = new Specialization();
        sp.setSpecialization(name);
        specializationDAO.insertSpecialization(sp);
    }

    private static void viewAllSpecializations() {
        List<Specialization> list = specializationDAO.getAllSpecializations();
        if (list.isEmpty()) {
            System.out.println("No specializations on record.");
            return;
        }
        list.forEach(sp -> System.out.println(sp.getSpId() + " - " + sp.getSpecialization()));
    }

    private static void assignSpecializationToDoctor() {
        int doctorId = safeIntInput(sc, "Enter doctor ID: ");
        if (doctorDAO.getDoctorById(doctorId) == null) {
            System.out.println("Doctor not found.");
            return;
        }
        int spId = safeIntInput(sc, "Enter specialization ID: ");
        if (specializationDAO.getSpecializationById(spId) == null) {
            System.out.println("Specialization not found.");
            return;
        }
        doctorSpecializationDAO.addSpecializationToDoctor(new DoctorSpecialization(doctorId, spId));
    }

    private static void removeSpecializationFromDoctor() {
        int doctorId = safeIntInput(sc, "Enter doctor ID: ");
        int spId = safeIntInput(sc, "Enter specialization ID: ");
        doctorSpecializationDAO.removeSpecializationFromDoctor(doctorId, spId);
    }

    private static void viewSpecializationsForDoctor() {
        int doctorId = safeIntInput(sc, "Enter doctor ID: ");
        Doctor doctor = doctorDAO.getDoctorById(doctorId);
        if (doctor == null) {
            System.out.println("Doctor not found.");
            return;
        }
        List<Integer> spIds = doctorSpecializationDAO.getSpecializationsByDoctor(doctorId);
        if (spIds.isEmpty()) {
            System.out.println(doctor.getName() + " has no specializations assigned yet.");
            return;
        }
        System.out.println("Specializations for " + doctor.getName() + ":");
        for (int spId : spIds) {
            Specialization sp = specializationDAO.getSpecializationById(spId);
            System.out.println(" - " + (sp != null ? sp.getSpecialization() : "Unknown (ID " + spId + ")"));
        }
    }

    private static void viewDoctorsForSpecialization() {
        int spId = safeIntInput(sc, "Enter specialization ID: ");
        Specialization sp = specializationDAO.getSpecializationById(spId);
        if (sp == null) {
            System.out.println("Specialization not found.");
            return;
        }
        List<Integer> doctorIds = doctorSpecializationDAO.getDoctorsBySpecialization(spId);
        if (doctorIds.isEmpty()) {
            System.out.println("No doctors are assigned to " + sp.getSpecialization() + " yet.");
            return;
        }
        System.out.println("Doctors specializing in " + sp.getSpecialization() + ":");
        for (int doctorId : doctorIds) {
            Doctor doctor = doctorDAO.getDoctorById(doctorId);
            System.out.println(" - " + (doctor != null ? doctor.getName() : "Unknown (ID " + doctorId + ")"));
        }
    }

    // ============================== REPORT MENU ==============================

    private static void reportMenu() {
        while (true) {
            System.out.println("\n----- Reports -----");
            System.out.println("1. Doctor Stats");
            System.out.println("2. Doctor Revenue Report");
            System.out.println("3. Back");
            System.out.print("Choose an option: ");

            int choice = safeIntInput(sc);
            switch (choice) {
                case 1: viewDoctorStats(); break;
                case 2: viewDoctorRevenueReport(); break;
                case 3: return;
                default: System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private static void viewDoctorStats() {
        List<DoctorStats> stats = statsDAO.getAllDoctorStats();
        if (stats.isEmpty()) {
            System.out.println("No stats yet - stats are recorded the first time a doctor gets an appointment.");
            return;
        }
        stats.forEach(s -> System.out.println("Doctor ID: " + s.getDoctorId() +
                " | Total Patients Seen: " + s.getTotalPatients()));
    }

    private static void viewDoctorRevenueReport() {
        int doctorId = safeIntInput(sc, "Enter doctor ID: ");
        try {
            DoctorRevenueReport report = reportService.getDoctorRevenueReport(doctorId);
            if (report == null) {
                System.out.println("Doctor not found.");
                return;
            }
            System.out.println("\n--- Doctor Revenue Report ---");
            System.out.println("Doctor         : " + report.getDoctorName() + " (ID " + report.getDoctorId() + ")");
            System.out.println("Appointments   : " + report.getTotalAppointments());
            System.out.printf("Total Billed   : %.2f%n", report.getTotalBilled());
            System.out.printf("Total Collected: %.2f%n", report.getTotalCollected());
            System.out.println("------------------------------\n");
        } catch (SQLException e) {
            System.out.println("Could not generate report: " + e.getMessage());
        }
    }

    // ============================== INPUT HELPERS ==============================

    private static int safeIntInput(Scanner sc) {
        while (true) {
            try {
                int value = sc.nextInt();
                sc.nextLine();
                return value;
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
                double value = sc.nextDouble();
                sc.nextLine();
                return value;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a decimal number.");
                sc.nextLine();
            }
        }
    }

    private static double safeDoubleInput(Scanner sc, String prompt) {
        System.out.print(prompt);
        return safeDoubleInput(sc);
    }
}