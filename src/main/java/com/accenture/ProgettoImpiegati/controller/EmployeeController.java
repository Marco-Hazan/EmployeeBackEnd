package com.accenture.ProgettoImpiegati.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException.BadRequest;

import com.accenture.ProgettoImpiegati.dto.request.EmployeeRequestDto;
import com.accenture.ProgettoImpiegati.dto.response.EmployeeResponseDto;
import com.accenture.ProgettoImpiegati.exceptions.BadUserException;
import com.accenture.ProgettoImpiegati.exceptions.EmployeeNotFoundException;
import com.accenture.ProgettoImpiegati.exceptions.ErrorDetails;
import com.accenture.ProgettoImpiegati.exceptions.ResourceNotFoundException;
import com.accenture.ProgettoImpiegati.model.Employee;
import com.accenture.ProgettoImpiegati.service.EmployeeService;
import com.accenture.ProgettoImpiegati.utils.MapperDtoEntity;
/*
 * 
 * json ok
 *  
{
"firstName": "andrea",
"lastName": "pra",
"emailId": "dasdsa"
}
 * 
 * */


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1")
public class EmployeeController extends BaseController{
	
	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/employees")
	public List<EmployeeResponseDto> getAllEmployees() {
		return employeeService.getEmployees();
	}

	@GetMapping("/employees/{id}")
	public ResponseEntity<EmployeeResponseDto> getEmployeeById(@PathVariable(value = "id") Long employeeId
			)
					throws ResourceNotFoundException {
		EmployeeResponseDto employee = employeeService.getEmployee(employeeId);
		if(employee == null) {
			throw new EmployeeNotFoundException("Nessun utente trovato");
		}
		return ResponseEntity.ok().body(employee);
	}


	//http://localhost:8080/ProgettoImpiegatiApplication/api/v1/employees
	@PostMapping("/employees")
	public EmployeeResponseDto createEmployee(@Valid @RequestBody EmployeeRequestDto employee) {
		String regex = "^(.+)@(.+)$";
		Pattern pattern = Pattern.compile(regex);
		EmployeeResponseDto emp = null;	
//		try {
//			if (bindingResult.hasErrors()) {
//				logger.debug("Errore nella validazione form");
//				bindingResult.getFieldErrors().forEach(e -> {
//					logger.debug(e.getField() + " - " + e.getCode() + " constraint violated");
//				});}
//			else {
//				logger.debug("Form valido");
			logger.info(employee.getFirstName());
			if(
					employee.getFirstName().length() == 0 || 
					employee.getLastName().length() == 0 || 
					!pattern.matcher(employee.getEmailId()).matches() 
			) {
				throw new BadUserException("I dati dell'utente sono incorretti");
			}
				emp =  employeeService.saveEmployee(employee);
//			}
			return emp;
		}
//		catch (Exception e2) {
//			// TODO: handle exception
//		}
		
	 

	@PutMapping("/employees/{id}")
	public ResponseEntity<EmployeeResponseDto> updateEmployee(@PathVariable(value = "id") Long employeeId,
			@Valid @RequestBody EmployeeRequestDto employeeDetails) throws ResourceNotFoundException {
		String regex = "^(.+)@(.+)$";
		Pattern pattern = Pattern.compile(regex);
		//EmployeeResponseDto employee = employeeService.getEmployee(employeeId);
		EmployeeResponseDto updatedEmployee = employeeService.updateEmployee(employeeDetails, employeeId);
		if(updatedEmployee == null) {
			throw new EmployeeNotFoundException("Nessun utente trovato");
		}
		if(
				employeeDetails.getFirstName().length() == 0 || 
						employeeDetails.getLastName().length() == 0 || 
				!pattern.matcher(employeeDetails.getEmailId()).matches() 
		) {
			throw new BadUserException("I dati dell'utente sono incorretti");
		}
		/*employee.setEmailId(employeeDetails.getEmailId());
		employee.setLastName(employeeDetails.getLastName());
		employee.setFirstName(employeeDetails.getFirstName());
		final EmployeeResponseDto updatedEmployee = employeeService.saveEmployee(employee);*/
		return ResponseEntity.ok(updatedEmployee);
	}

	@DeleteMapping("/employees/{id}")
	public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Long employeeId)
			throws ResourceNotFoundException {
		//			Employee employee = employeeService.getEmployee(employeeId);
		employeeService.deleteEmployee(employeeId);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}