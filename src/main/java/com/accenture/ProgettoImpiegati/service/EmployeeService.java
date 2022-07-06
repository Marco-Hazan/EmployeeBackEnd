package com.accenture.ProgettoImpiegati.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.accenture.ProgettoImpiegati.exceptions.ResourceNotFoundException;
import com.accenture.ProgettoImpiegati.model.Employee;
import com.accenture.ProgettoImpiegati.repository.EmployeeRepository;

@Service
@Transactional

public class EmployeeService implements IEmoployeeService {
	@Autowired
	private EmployeeRepository empRepo;

	@Override
	 

	public List<Employee> getEmployees() {
		// TODO Auto-generated method stub
		return empRepo.findAll();
	}

	@Override
	 
	public Employee saveEmployee(Employee theEmployee) {
		return empRepo.save(theEmployee);

	}

	@Override
	 
	public Employee getEmployee(Long theId) {
		Employee emp = null;
		try {
			emp= empRepo.findById(theId).
					orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + theId));
			 
		} catch (ResourceNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return emp;
	}

	@Override
	public void deleteEmployee(Long theId) {
		empRepo.deleteById(theId);
 

	}

}
