package com.example.demo.controller;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.User;
import com.example.demo.services.UserService;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {
	
	@Autowired
	UserService userService;
	
	/*
	@PostMapping("/loginUser")
	public  User loginUser(@RequestBody User user) {
		//String str = user.getEmail();
		return userService.loginUser(user);
		/*
		if(user != null) {
			userService.sendSimpleEmail(str,"You Registered Successfully","Welcome To Rent And Ride services");
			return new ResponseEntity<>("Sign Up Successful ... Please Login!!!",HttpStatus.OK);
		}
		return new ResponseEntity<>("Sign Up Successful ... Please Login!!!",HttpStatus.OK);
		//
	}
	*/
	
	@PostMapping("/loginUser")
	public  User loginUser(@RequestBody User user) {
		return userService.loginUser(user);		
	}
	
	@PostMapping("/registerUser")
	public String save(@RequestBody User user) throws MessagingException {
		String str = user.getEmail();
		User u1=userService.registerUser(user);
		
		if(u1 != null) {
			userService.sendSimpleEmail(str,"You Registered Successfully!\n Username = "+user.getUsername()+"\n Password = "+user.getPassword(),"Welcome To Woodworks.com services!!");
			return "Sign Up Successful ... Please Login!!!";
		}
		return "Sign Up Failed ... Please Signup !!!";
	}
	
	/*For Mail Service  Tushar
	@PostMapping("/signup")
	public ResponseEntity<?>signUpUser(@RequestBody UserDTO userdto) throws MessagingException
	{
		String str = userdto.getEmail();
		String encoded = crypt.encodePassword(userdto.getPassword());
		userdto.setPassword(encoded);
		userdto.setEmail(userdto.getEmail().toLowerCase());
		System.out.println("In add user details "+ userdto);
		userService.registerUser(userdto);
		if(new ResponseEntity<>(HttpStatus.OK) != null) {
			userService.sendSimpleEmail(str,"You Registered Successfully","Welcome To Rent And Ride services");
			return new ResponseEntity<>("Sign Up Successful ... Please Login!!!",HttpStatus.OK);
		}
		return new ResponseEntity<>("Sign Up Successful ... Please Login!!!",HttpStatus.OK);
	}*/
}
