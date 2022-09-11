package com.example.demo.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.User;

@Transactional
@Repository
public interface UserRepository extends JpaRepository<User,Long> {

	
	
	@Query(value="select * from users where email =?1 and password=?2",nativeQuery = true )
	public User getUserByEmailAndPassword(String email, String password);
}
