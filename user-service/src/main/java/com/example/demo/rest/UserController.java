package com.example.demo.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.LoginRequest;
import com.example.demo.dto.RegistrationRequest;
import com.example.demo.dto.UpdateRequest;
import com.example.demo.model.User;
import com.example.demo.service.UserService;


@RestController
@RequestMapping("/api/users")
public class UserController {
	
	@Autowired
	UserService us;

	@PostMapping("/register/")
    public String registerUser(@RequestBody RegistrationRequest registrationRequest) {
        User success = us.registerUser(registrationRequest);
        if(success != null) {
        	return "Uspesno!\nUserId:" + success.getUserId() + "\nUsername: "+success.getUsername() + " | Email: " + success.getEmail();
        }else {
        	return "Neuspesna registracija, pokusaj ponovo!";
        	
        }
    }

    @PostMapping("/login/")
    public String loginUser(@RequestBody LoginRequest loginRequest) {
    	User success = us.loginUser(loginRequest);
    	if(success != null) {
        	return "Uspesno!\nUserId:" + success.getUserId() + "\nUsername: "+success.getUsername() + " | Email: " + success.getEmail();
        }else {
        	return "Neuspesan login, pokusaj ponovo!";
        	
        }
    }
    
    @PostMapping("/updateProfile/{userId}")
    public String updateProfile(@PathVariable int userId,@RequestBody UpdateRequest updateRequest) {
    	String success = us.updateProfile(updateRequest);
    	return success;
    }
	
}
