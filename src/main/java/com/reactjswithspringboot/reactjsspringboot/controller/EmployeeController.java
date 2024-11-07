package com.reactjswithspringboot.reactjsspringboot.controller;

import java.net.http.HttpResponse;

import java.util.List;
import org.apache.catalina.connector.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reactjswithspringboot.reactjsspringboot.dto.Employeedto;
import com.reactjswithspringboot.reactjsspringboot.entity.Employee;
import com.reactjswithspringboot.reactjsspringboot.service.EmployeeService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
	
	
	@Autowired
	public EmployeeService employeeService;
	


	@PostMapping
	public ResponseEntity<Employeedto> createEmp(@RequestBody Employeedto employeedto){
		Employeedto empDto = employeeService.createEmployeed(employeedto);
		return new ResponseEntity<>(empDto,HttpStatus.CREATED);
		
	}
	
	
	@GetMapping("{id}")
	public ResponseEntity<Employeedto> getEmployeeDto(@PathVariable("id")Long empId){
		Employeedto employeedto = employeeService.getEmployeeid(empId);
		return   ResponseEntity.ok(employeedto);
		
	}
	
	@GetMapping()
	public ResponseEntity<List<Employeedto>> getEmployeeAll(){
	    // Call the employee service to get all employees and map them to DTOs
	    List<Employeedto> empdto = employeeService.getAllemp();
	    
	    // Return the list of EmployeeDTOs wrapped in a ResponseEntity with an OK status
	    return ResponseEntity.ok(empdto);
	}


	@PutMapping("{id}")
	public ResponseEntity<Employeedto> updateEmployee(@PathVariable("id") Long empId, @RequestBody  Employeedto updateEmployeeDto) {
	    
	    Employeedto updateempdto = employeeService.updateEmp(empId, updateEmployeeDto);
	    return ResponseEntity.ok(updateempdto);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<Employeedto> deleteEmployee(@PathVariable("id") Long empId){
		Employeedto deleteempdto =	employeeService.deleteemp(empId);
		return ResponseEntity.ok(deleteempdto);
		
	}
	
}

