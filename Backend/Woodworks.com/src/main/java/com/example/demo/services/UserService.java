package com.example.demo.services;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;


import com.example.demo.entities.User;
import com.example.demo.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	private JavaMailSender sendMail;

	public User loginUser(User us) {	
		User user= userRepository.getUserByEmailAndPassword(us.getEmail(),us.getPassword());
		if (user != null) {
			System.out.println("true");		
			return user;
		}
		else
		{
			System.out.println("false");
			return null;
		}
	}

	public User registerUser(User user) {
		// TODO Auto-generated method stub
		return userRepository.save(user);
	}
	
	//For sending mail
	public void sendSimpleEmail(String toEmail,
            String body,
            String subject) throws MessagingException {
		SimpleMailMessage message = new SimpleMailMessage();
		
		message.setFrom("godserushi1997@gmail.com");
		message.setTo(toEmail);
		message.setText(body);
		message.setSubject(subject);
		
		System.out.println(toEmail);
		System.out.println(body);
		System.out.println(subject);
		
		//Another Way
		
		//MimeMessage message=sendMail.createMimeMessage();
		//MimeMessageHelper helper=new MimeMessageHelper(message);
		//helper.setFrom("godserushi1997@gmail.com");
		//helper.setTo(toEmail);
		//helper.setText(body);
		//helper.setSubject(subject);
		
		sendMail.send(message);
		
		System.out.println("Mail Send...");
}


}
