package com.spring_boot.employee_management.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring_boot.employee_management.model.Employee;
import com.spring_boot.employee_management.repository.EmployeeRepository;

@Service
public class EmployeeService implements EmployeeServiceInterface{

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public Employee saveEmployee(Employee employee) {
		Employee addedEmployee = employeeRepository.save(employee);
		return addedEmployee;
	}

	@Override
	public Optional<Employee> getEmployeeById(int id) {
		Optional<Employee> employee = employeeRepository.findById(id);
		return employee;
	}

	@Override
	public List<Employee> getAllEmployee() {
		List<Employee> list = employeeRepository.findAll();
		return list;
	}

	@Override
	public Employee updateEmployee(int id, Employee employee) {
		
		Employee employeeToUpdate = employeeRepository.findById(id).orElseThrow();
		employeeToUpdate.setFirstName(employee.getFirstName());
		employeeToUpdate.setLastName(employee.getLastName());
		employeeToUpdate.setEmail(employee.getEmail());
		
		employeeRepository.save(employeeToUpdate);
		return employeeToUpdate;
	}

	@Override
	public void deleteEmployee(int id) {
		employeeRepository.deleteById(id);		
	}

}
