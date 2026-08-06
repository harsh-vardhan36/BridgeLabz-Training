package com.healthclinic_app.db;

/**
 * Runs all schema setup in the correct dependency order:
 * parent tables -> child tables -> triggers -> stored procedures.
 *
 * Called once from Main.main() on startup. Every CREATE statement used
 * by the individual *TableSetup classes is CREATE TABLE IF NOT EXISTS,
 * so calling this repeatedly on an already-initialized database is safe.
 */
public class DatabaseInitializer {

    public static void initialize() {
        System.out.println("Initializing database schema...");

        // Parent tables first (no foreign keys of their own)
        DoctorTableSetup.createTable();
        PatientTableSetup.createTable();
        SpecializationTableSetup.createTable();

        // Tables that depend on the patients above
        AppointmentTableSetup.createTable();
        DoctorSpecializationTableSetup.createTable();
        DoctorStatsTableSetup.createTable();
        BillTableSetup.createTable();
        PatientAuditLogTableSetup.createTable();

        // Trigger and stored procedure objects (depend on tables existing)
        TriggerSetup.createTriggers();
        StoredProcedureSetup.createProcedures();

        //System.out.println("Database schema ready.\n");
    }

    public static void main(String[] args) {
        initialize();
    }
}
