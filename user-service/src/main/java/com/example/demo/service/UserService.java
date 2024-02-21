package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.example.demo.dto.LoginRequest;
import com.example.demo.dto.RegistrationRequest;
import com.example.demo.dto.UpdateRequest;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepo;

@Service
public class UserService {
	
	@Autowired
	UserRepo ur;
	
	public String updateProfile(UpdateRequest updateRequest) {
		String izmene = "Uspesno izmenjeno:";
		try {
			LoginRequest loginRequest = new LoginRequest();
			loginRequest.setPassword(updateRequest.getPassword());
			loginRequest.setUsernameOrEmail(updateRequest.getUsernameOrEmail());
			User loginSuccesfull = loginUser(loginRequest);
			if(loginSuccesfull != null) {
				if(updateRequest.getNewEmail() != null) {
					izmene.concat(" Email iz " + loginSuccesfull.getEmail() + " u " + updateRequest.getNewEmail());
					loginSuccesfull.setEmail(updateRequest.getNewEmail());
				}
				if(updateRequest.getNewPassword() != null) {
					izmene.concat(" Password iz " + loginSuccesfull.getPassword() + " u " + updateRequest.getNewPassword());
					loginSuccesfull.setPassword(updateRequest.getNewPassword());
				}
				if(updateRequest.getNewUsername() != null) {
					izmene.concat(" Username iz " + loginSuccesfull.getUsername() + " u " + updateRequest.getNewUsername());
					loginSuccesfull.setUsername(updateRequest.getNewUsername());
				}
				if(updateRequest.getFullName() != null) {
					izmene.concat(" FullName iz " + loginSuccesfull.getFullName() + " u " + updateRequest.getFullName());
					loginSuccesfull.setFullName(updateRequest.getFullName());
				}
				ur.save(loginSuccesfull);
				return izmene;
			}else {
				return "Za menjanje podataka na profilu morate uneti tacnu sifru i username/email!";
			}
		}catch(Exception ex) {
			ex.printStackTrace();
			return "Doslo je do greske negde!";
		}
	}
	
	public User loginUser(LoginRequest loginRequest) {
		try {
			User user = ur.findByUsernameOrEmail(loginRequest.getUsernameOrEmail(), loginRequest.getUsernameOrEmail());
			
			if(user != null) {
				if(loginRequest.getPassword().equals(user.getPassword())) {
					return user;
				}else {
					return null;
				}
			}else {
				return null;
			}
			
		}catch(Exception ex){
			ex.printStackTrace();
			return null;
		}
	}

	public User registerUser(RegistrationRequest registrationRequest) {
	    try {
	    	if(ur.findByUsernameOrEmail(registrationRequest.getUsername(), registrationRequest.getEmail()) != null) {
	    		return null;
	    	}else {
	    		User user = new User();
		        
		        user.setEmail(registrationRequest.getEmail());
		        user.setFullName(registrationRequest.getFullName());
		        user.setPassword(registrationRequest.getPassword());
		        user.setUsername(registrationRequest.getUsername());
		        
		        System.out.println(user);
		        
		        User savedUser = ur.save(user);
		        return savedUser;
	    	}
	        
	    } catch (DataIntegrityViolationException e) {
	        // Handle specific exception for duplicate entries (e.g., duplicate email/username)
	        System.err.println("Duplicate entry. User with email or username already exists.");
	        e.printStackTrace();
	        return null;
	    } catch (Exception ex) {
	        // Handle other exceptions
	        System.err.println("An error occurred during user registration.");
	        ex.printStackTrace();
	        return null;
	    }
	}

	
}
