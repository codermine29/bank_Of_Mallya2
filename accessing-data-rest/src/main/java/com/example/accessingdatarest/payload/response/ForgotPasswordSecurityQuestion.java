package com.example.accessingdatarest.payload.response;

import jakarta.validation.constraints.NotBlank;

public class ForgotPasswordSecurityQuestion {
	
	@NotBlank
	private String securityQuestion;

	public String getSecurityQuestion() {
		return securityQuestion;
	}

	public void setSecurityQuestion(String securityQuestion) {
		this.securityQuestion = securityQuestion;
	}
	
	
}
