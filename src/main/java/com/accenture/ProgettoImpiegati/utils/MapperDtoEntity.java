package com.accenture.ProgettoImpiegati.utils;

import org.springframework.beans.BeanUtils;

import com.accenture.ProgettoImpiegati.dto.request.EmployeeRequestDto;
import com.accenture.ProgettoImpiegati.dto.response.EmployeeResponseDto;
import com.accenture.ProgettoImpiegati.model.Employee;

public class MapperDtoEntity {

	public static Employee fromDtoToEntity(Object dto) {
		Employee emp = new Employee();
		BeanUtils.copyProperties(dto, emp);
		return emp;
	}
	
	public static EmployeeResponseDto fromEntityToDto(Object entity) {
		EmployeeResponseDto emp = new EmployeeResponseDto();
		BeanUtils.copyProperties(entity, emp);
		return emp;
	}
}
