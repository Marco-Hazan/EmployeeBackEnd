package com.accenture.ProgettoImpiegati.dto.request;

import java.time.LocalDate;

public class EmployeeRequestDto {
	
	private long id;
    private String firstName;
    private String lastName;
    private String emailId;
    private LocalDate dataNascita;
    private boolean follow;
    
    public EmployeeRequestDto() {}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public LocalDate getDataNascita() {
		return dataNascita;
	}

	public void setDataNascita(LocalDate dataNascita) {
		this.dataNascita = dataNascita;
	}

	public boolean isSeguito() {
		return follow;
	}

	public void setSeguito(boolean follow) {
		this.follow = follow;
	}
    
    
}
