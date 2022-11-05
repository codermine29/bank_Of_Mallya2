package com.example.accessingdatarest.payload.request;

import jakarta.validation.constraints.NotBlank;

public class ForgotPasswordRequest {
	
	@NotBlank
	private String securityAnswer;

	@NotBlank
	private String newPassword;

	public String getSecurityAnswer() {
		return securityAnswer;
	}

	public void setSecurityAnswer(String securityAnswer) {
		this.securityAnswer = securityAnswer;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	
	
	
	
}
