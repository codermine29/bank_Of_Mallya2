package com.example.accessingdatarest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.accessingdatarest.models.User;
import com.example.accessingdatarest.payload.request.ForgotPasswordRequest;
import com.example.accessingdatarest.payload.response.MessageResponse;
import com.example.accessingdatarest.repository.UserRepository;
import com.example.accessingdatarest.security.services.UserDetailsServiceImpl;

import jakarta.validation.Valid;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
public class TestController {

	static String str1=null;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	UserDetailsServiceImpl userDetailsServiceImpl;

	@Autowired
	PasswordEncoder encoder;
	
	
	@GetMapping("/all")
	public String allAccess() {
		return "Public Content.";
	}

	@GetMapping("/user")
	@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	public String userAccess() {
		return "User Content.";
	}

	/*
	@GetMapping("/mod")
	@PreAuthorize("hasRole('MODERATOR')")
	public String moderatorAccess() {
		return "Moderator Board.";
	}

	@GetMapping("/admin")
	@PreAuthorize("hasRole('ADMIN')")
	public String adminAccess() {
		return "Admin Board.";
	}
	*/

	@PostMapping("/forgotpassword")
	public ResponseEntity<?> forgotPassword(@Valid @RequestBody String username) {
		str1=username;
		return ResponseEntity.ok(new MessageResponse("Enter security answer for ("+userDetailsServiceImpl.getSecurityQuestionsBasedOnUsername(username)+") and new password"));
	}

	@PostMapping("/enterForgotPSecurityA")
	public ResponseEntity<?> forgotPasswordSecurityAnswer(
			@Valid @RequestBody ForgotPasswordRequest forgotPasswordRequest) {
		User user = userRepository.findByUsername(str1)
		        .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + str1));
		if(forgotPasswordRequest.getSecurityAnswer().compareTo(user.getSecurityAnswers())==0){
		user.setPassword(encoder.encode(forgotPasswordRequest.getNewPassword()));
		userRepository.save(user);
		
			return ResponseEntity.ok(new MessageResponse("Password updated"));
		}else {
			return ResponseEntity.badRequest().body(new MessageResponse("Wrong Security Answer"));
		}
	}
	
	/*
	 @Autowired
	Tbl_AtmdtlsRepositoryService tbl_atmdtlsRepositoryService;
	
	@GetMapping("test1")
	public List<Tbl_Atmdtls> getTable(){
		
		return  tbl_atmdtlsRepositoryService.getAllTbl();
	}
	 */

}
