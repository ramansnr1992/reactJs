package com.reactjswithspringboot.reactjsspringboot.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reactjswithspringboot.reactjsspringboot.dto.Employeedto;
import com.reactjswithspringboot.reactjsspringboot.entity.Employee;
import com.reactjswithspringboot.reactjsspringboot.exception.ResourceNotFoundException;
import com.reactjswithspringboot.reactjsspringboot.mapper.EmployeeMapper;
import com.reactjswithspringboot.reactjsspringboot.repository.EmployeeRepository;

import jakarta.transaction.Transactional;

@Service
public class EmployeeServiceImpl implements EmployeeService  {

	@Autowired
	public EmployeeRepository employeeRepository;

	
	
	@Override
	public Employeedto createEmployeed(Employeedto employeedto) {
		// TODO Auto-generated method stub
		Employee emp = EmployeeMapper.mapToEmployee(employeedto);
		Employee saveEmp =employeeRepository.save(emp); 
		return EmployeeMapper.mapToEmployeeDto(saveEmp);
	}



	@Override
	public Employeedto getEmployeeid(Long employeeId) {
		// TODO Auto-generated method stub
		Employee emp= employeeRepository.findById(employeeId).orElseThrow(() -> new ResourceNotFoundException("Employee not found with id: " + employeeId));
		return  EmployeeMapper.mapToEmployeeDto(emp);
	}



	@Override
	public List<Employeedto> getAllemp() {
		// TODO Auto-generated method stub
		List<Employee>  emp  = employeeRepository.findAll();
		return  emp.stream().map((em)->EmployeeMapper.mapToEmployeeDto(em)).collect(Collectors.toList());
	}


	@Transactional
	@Override
	public Employeedto updateEmp(Long empId, Employeedto updateEmployeeDto) {
		// TODO Auto-generated method stub
		Employee emp = employeeRepository.findById(empId).orElseThrow(()-> new ResourceNotFoundException("Employee not found with id: " + empId));
		
		emp.setFirstName(updateEmployeeDto.getFirstName());
		emp.setLastName(updateEmployeeDto.getLastName());
		emp.setEmail(updateEmployeeDto.getEmail());
		emp.setAddress(updateEmployeeDto.getAddress());
		
		Employee empUpdate = employeeRepository.save(emp);
		
		return EmployeeMapper.mapToEmployeeDto(empUpdate);
	}



	@Override
	public Employeedto deleteemp(Long empId) {
		// TODO Auto-generated method stub
		Employee emp = employeeRepository.findById(empId).orElseThrow(()-> new ResourceNotFoundException("Employee not found with id: " + empId));
		employeeRepository.deleteById(empId);
		return EmployeeMapper.mapToEmployeeDto(emp);
		
	}

}
