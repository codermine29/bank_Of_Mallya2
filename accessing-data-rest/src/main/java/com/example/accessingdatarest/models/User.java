package com.example.accessingdatarest.models;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "users",
       uniqueConstraints = {
           @UniqueConstraint(columnNames = "username"),
           @UniqueConstraint(columnNames = "email")
       })
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotBlank
  @Size(max = 20)
  private String username;

  @NotBlank
  @Size(max = 50)
  @Email
  private String email;

  @NotBlank
  @Size(max = 120)
  private String password;
  
  @NotBlank
  private String yourName;
  
  private String middleName;
  
  @NotBlank
  private String lastName;
  
  @NotBlank
  private String securityQuestions;
  
  @NotBlank
  private String securityAnswers;
  
  @NotBlank
  private String accountTypeID;
  
  @NotBlank
  private String mobileNumber;
  

  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(name = "user_roles", 
             joinColumns = @JoinColumn(name = "user_id"),
             inverseJoinColumns = @JoinColumn(name = "role_id"))
  private Set<Role> roles = new HashSet<>();

  public User() {
  }

  
  
  public User(String username, String email, String password,
		  String yourName,String middleName,
		  String lastName,String securityQuestions,String securityAnswers,String accountTypeID,String mobileNumber) {
    this.username = username;
    this.email = email;
    this.password = password;
    this.yourName=yourName;
    this.middleName=middleName;
    this.lastName=lastName;
    this.securityQuestions=securityQuestions;
    this.securityAnswers=securityAnswers;
    this.accountTypeID=accountTypeID;
    this.mobileNumber=mobileNumber;
  }

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getUsername() {
	return username;
}

public void setUsername(String username) {
	this.username = username;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public String getYourName() {
	return yourName;
}

public void setYourName(String yourName) {
	this.yourName = yourName;
}

public String getMiddleName() {
	return middleName;
}

public void setMiddleName(String middleName) {
	this.middleName = middleName;
}

public String getLastName() {
	return lastName;
}

public void setLastName(String lastName) {
	this.lastName = lastName;
}

public String getSecurityQuestions() {
	return securityQuestions;
}

public void setSecurityQuestions(String securityQuestions) {
	this.securityQuestions = securityQuestions;
}

public String getSecurityAnswers() {
	return securityAnswers;
}

public void setSecurityAnswers(String securityAnswers) {
	this.securityAnswers = securityAnswers;
}

public String getAccountTypeID() {
	return accountTypeID;
}

public void setAccountTypeID(String accountTypeID) {
	this.accountTypeID = accountTypeID;
}

public String getMobileNumber() {
	return mobileNumber;
}

public void setMobileNumber(String mobileNumber) {
	this.mobileNumber = mobileNumber;
}

public Set<Role> getRoles() {
	return roles;
}

public void setRoles(Set<Role> roles) {
	this.roles = roles;
}
  
}
