package com.spring_boot.employee_management.service;

import java.util.List;
import java.util.Optional;

import com.spring_boot.employee_management.model.Employee;

public interface EmployeeServiceInterface {

	public Employee saveEmployee(Employee employee);
	public Optional<Employee> getEmployeeById(int id);
	List<Employee> getAllEmployee();
	Employee updateEmployee(int id, Employee employee);
	void deleteEmployee(int id);
}
