package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

//After Product book 
@Service
public class EmailSender {
	
	@Autowired
	private JavaMailSender sendMail;
	
	public void sendEmailForNewRegistration(String email) 
	{
		SimpleMailMessage message = new SimpleMailMessage();
		
		message.setFrom("godserushi1997@gmail.com");
		message.setTo(email);
		message.setSubject("Registration Conformation Mail.....Successfully Registered the User");
		message.setText("Thank You for Registering With Us! Welcome to Woodworks.com!"
				+ "Have Happy shopping From Woodworks.com!");
		sendMail.send(message);
	}

}
