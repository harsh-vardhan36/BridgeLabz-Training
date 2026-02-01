package com.java8.functional.dataserialization;
public class BackupApp {

    public static void main(String[] args) {

        UserProfile user = new UserProfile();
        TransactionLog log = new TransactionLog();

        BackupService.backup(user);
        BackupService.backup(log);
    }
}
