package com.reactjswithspringboot.reactjsspringboot.service;

import java.util.List;

import com.reactjswithspringboot.reactjsspringboot.dto.Employeedto;

public interface EmployeeService {

	Employeedto createEmployeed(Employeedto employeedto);
	
	Employeedto getEmployeeid (Long employeeId);
	
	List<Employeedto> getAllemp();
	
	Employeedto updateEmp(Long empId,Employeedto updateEmployeeDto);
	
	Employeedto deleteemp(Long empId);
}
