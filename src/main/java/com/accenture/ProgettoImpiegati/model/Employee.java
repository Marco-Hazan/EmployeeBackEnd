package com.accenture.ProgettoImpiegati.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.UpdateTimestamp;


/*
 * 
 * CREATE TABLE employees(
	ID NUMBER(10) NOT NULL,
	first_NAME VARCHAR2(100) NOT NULL,
	last_name VARCHAR2(100) NOT NULL,
	email_address  VARCHAR2(100) NOT NULL,
	CONSTRAINT Employee_PK PRIMARY KEY (ID)
);

CREATE SEQUENCE empl_seq
  MINVALUE 1
  MAXVALUE 9999999999
  START WITH 1
  INCREMENT BY 1;
 * 
 * 
 * */
@Entity
@Table(name = "employees")
public class Employee {

    private long id;
    private String firstName;
    private String lastName;
    private String emailId;
    private LocalDate dataNascita;
    private LocalDateTime ultimoAggiornamento;
    private boolean follow;
    
    
    public Employee() {
  
    }
 
    public Employee(String firstName, String lastName, String emailId) {
         this.firstName = firstName;
         this.lastName = lastName;
         this.emailId = emailId;
    }
 
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CUST_SEQ")
    @SequenceGenerator(sequenceName = "empl_seq", allocationSize = 1, name = "CUST_SEQ")
        public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
 
    @Column(name = "first_name", nullable = false)
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
 
    @Column(name = "last_name", nullable = false)
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
 
    @Column(name = "email_address", nullable = false)
    public String getEmailId() {
        return emailId;
    }
    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    @Column(name = "data_nascita", nullable = false)
    public LocalDate getDataNascita() {
		return dataNascita;
	}
    
    @UpdateTimestamp
    @Column(name = "ultimo_aggiornamento",nullable = true)
    public LocalDateTime getUltimoAggiornamento() {
    	return ultimoAggiornamento;
    }
    
    

	public void setDataNascita(LocalDate dataNascita) {
		this.dataNascita = dataNascita;
	}

	public void setUltimoAggiornamento(LocalDateTime ultimoAggiornamento) {
		this.ultimoAggiornamento = ultimoAggiornamento;
	}

	@Column(name = "follow",columnDefinition = "boolean default false")
	public boolean isFollow() {
		return follow;
	}

	public void setFollow(boolean follow) {
		this.follow = follow;
	}

	@Override
    public String toString() {
        return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", emailId=" + emailId
       + "]";
    }
 
}