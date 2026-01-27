package com.annotation.rolebasedaccess;

@RoleAllowed("ADMIN")
class AdminService {

    public void performAdminTask() {
        System.out.println("Admin task executed successfully");
    }
}
