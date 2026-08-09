package com.app.greeting.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.app.greeting.model.RegisterationUser;
@Service
public class RegistrationService {


    private final List<RegisterationUser> userDB = new ArrayList<>();

    public boolean emailExists(RegisterationUser user) {

        for (RegisterationUser existingUser : userDB) {

            if (existingUser.getEmail().equals(user.getEmail())) {
                return true;
            }
        }

        return false;
    }

    public boolean addUser(RegisterationUser user) {

        if (emailExists(user)) {
            return false;
        }

        userDB.add(user);
        return true;
    }
    
    public boolean findUser(RegisterationUser user) {
    	for(RegisterationUser loginDetails : userDB) {
    		if(loginDetails.getEmail().equals(user.getEmail()) && loginDetails.getPassword().equals(user.getPassword())) {
    			return true;
    		}
    	}
    	return false;
    }
}