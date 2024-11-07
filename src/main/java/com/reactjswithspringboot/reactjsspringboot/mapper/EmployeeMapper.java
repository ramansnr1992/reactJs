package com.reactjswithspringboot.reactjsspringboot.mapper;

import com.reactjswithspringboot.reactjsspringboot.dto.Employeedto;
import com.reactjswithspringboot.reactjsspringboot.entity.Employee;

public class EmployeeMapper {

	public static Employeedto mapToEmployeeDto(Employee  employee) {
		return new Employeedto
				
(employee. getId(),employee.getFirstName(),employee.getLastName(),employee.getEmail(),employee.getAddress());
		
	}
	
	public static Employee mapToEmployee(Employeedto employeedto) {
		return new Employee(employeedto.getId(), employeedto.getFirstName(), employeedto.getLastName(), employeedto.getEmail(),employeedto.getAddress());
		
	}
	
}
