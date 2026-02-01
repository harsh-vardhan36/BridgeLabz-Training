package com.java8.functional.dataserialization;

public class BackupService {

    public static void backup(Object obj) {

        if (obj instanceof BackupSerializable) {
            System.out.println("Backing up object: " + obj.getClass().getSimpleName());
            
        } else {
            System.out.println("Backup skipped: Not marked for backup");
        }
    }
}
