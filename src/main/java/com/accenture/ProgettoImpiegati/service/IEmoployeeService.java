package com.accenture.ProgettoImpiegati.service;

 

import java.util.List;

import com.accenture.ProgettoImpiegati.dto.request.EmployeeRequestDto;
import com.accenture.ProgettoImpiegati.dto.response.EmployeeResponseDto;

 

 

public interface IEmoployeeService {

	public List<EmployeeResponseDto> getEmployees();

	public EmployeeResponseDto saveEmployee(EmployeeRequestDto theEmployee);

	public EmployeeResponseDto getEmployee(Long theId);

	public void deleteEmployee(Long theId);

	EmployeeResponseDto updateEmployee(EmployeeRequestDto theEmployee, Long id);
	
}
