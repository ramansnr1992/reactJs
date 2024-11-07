package com.reactjswithspringboot.reactjsspringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.reactjswithspringboot.reactjsspringboot.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
