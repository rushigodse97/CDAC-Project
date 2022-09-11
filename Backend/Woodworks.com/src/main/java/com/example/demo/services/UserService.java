package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.User;
import com.example.demo.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;

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

}
