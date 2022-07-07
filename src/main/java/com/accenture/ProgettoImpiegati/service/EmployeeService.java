package com.accenture.ProgettoImpiegati.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.accenture.ProgettoImpiegati.dto.request.EmployeeRequestDto;
import com.accenture.ProgettoImpiegati.dto.response.EmployeeResponseDto;
import com.accenture.ProgettoImpiegati.exceptions.ResourceNotFoundException;
import com.accenture.ProgettoImpiegati.model.Employee;
import com.accenture.ProgettoImpiegati.repository.EmployeeRepository;
import com.accenture.ProgettoImpiegati.utils.MapperDtoEntity;

@Service
@Transactional

public class EmployeeService implements IEmoployeeService {
	@Autowired
	private EmployeeRepository empRepo;

	@Override
	 

	public List<EmployeeResponseDto> getEmployees() {
		// TODO Auto-generated method stub
		return empRepo.findAll().stream() 
				.map(emp -> MapperDtoEntity.fromEntityToDto(emp))
				.collect(Collectors.toList());
	}

	@Override
	public EmployeeResponseDto saveEmployee(EmployeeRequestDto theEmployee) {
		Employee emp = MapperDtoEntity.fromDtoToEntity(theEmployee);
		return MapperDtoEntity.fromEntityToDto(empRepo.save(emp));
	}
	
	@Override
	public EmployeeResponseDto updateEmployee(EmployeeRequestDto theEmployee, Long id) {
		Employee emp = MapperDtoEntity.fromDtoToEntity(theEmployee);
		emp.setId(id);
		return MapperDtoEntity.fromEntityToDto(empRepo.save(emp));
	}

	@Override
	 
	public EmployeeResponseDto getEmployee(Long theId) {
		Employee emp = null;
		try {
			emp= empRepo.findById(theId).
					orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + theId));
			 
		} catch (ResourceNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return MapperDtoEntity.fromEntityToDto(emp);
	}

	@Override
	public void deleteEmployee(Long theId) {
		empRepo.deleteById(theId);
	}

}
