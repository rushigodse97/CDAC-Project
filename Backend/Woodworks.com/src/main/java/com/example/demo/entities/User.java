package com.example.demo.entities;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="Users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "userId")
	private long userId;
	
	@Column
	private String firstname;
	
	@Column
	private String lastname;
	
	@Column
	private String email;
	
	@Column(name="Mobile_Number")
	private long mobileNo;
	
	@Column
	private String username;
	
	@Column
	private String password;
	
	@Column
	private String role;
	
	//@JsonIgnore                      //if we use @Data Annotation then use this two
	//@ToString.Exclude
	@OneToMany(mappedBy = "user",fetch = FetchType.EAGER,cascade=CascadeType.REMOVE)
	private List<Address> address;
	

	@OneToMany(mappedBy = "user",fetch = FetchType.EAGER,cascade=CascadeType.REMOVE)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<Product> product;
	
	@OneToMany(mappedBy = "user",fetch = FetchType.EAGER,cascade=CascadeType.REMOVE)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<Feedback> feedback;
	
	@OneToOne(mappedBy = "user",cascade=CascadeType.REMOVE)
	private MyOrder myorder;
	
}
