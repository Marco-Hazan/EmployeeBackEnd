package com.accenture.ProgettoImpiegati.repository;

 

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.accenture.ProgettoImpiegati.model.Employee;

 

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}