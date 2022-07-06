package com.accenture.ProgettoImpiegati.service;

 

import java.util.List;

import com.accenture.ProgettoImpiegati.model.Employee;

 

 

public interface IEmoployeeService {

	public List<Employee> getEmployees();

	public Employee saveEmployee(Employee theEmployee);

	public Employee getEmployee(Long theId);

	public void deleteEmployee(Long theId);
	
}
