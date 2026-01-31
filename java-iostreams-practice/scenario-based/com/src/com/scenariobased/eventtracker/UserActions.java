package com.scenariobased.eventtracker;

public class UserActions {

    @AuditTrail(action = "USER_LOGIN", severity = "LOW")
    public void login() {}

    @AuditTrail(action = "FILE_UPLOAD", severity = "MEDIUM")
    public void uploadFile() {}

    @AuditTrail(action = "FILE_DELETE", severity = "HIGH")
    public void deleteFile() {}

    public void viewProfile() {
        // Not audited
    }
}
