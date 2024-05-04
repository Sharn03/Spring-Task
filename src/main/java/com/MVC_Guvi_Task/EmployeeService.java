package com.MVC_Guvi_Task;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;
	
	// method that add employee to database
	public Employee addEmployee(Employee employee)
	{
		return employeeRepository.save(employee);
	}
	
	//  method that get All Employee
	public List<Employee>findAllEmployee()
	{
		return employeeRepository.findAll();
	}
	
	//MEthod that get the employee details by id
	public Employee findByEmployeeId(String id)
	{
		return employeeRepository.findById(id).get();
	}
	
	//Method that update the employee details
	public Employee updateEmployee(Employee employee)
	{
		Employee e = employeeRepository.findById(employee.getId()).get();
		e.setName(employee.getName());
		e.setEmail(employee.getEmail());
		e.setLocation(employee.getLocation());
		return employeeRepository.save(e);
	}
	
	

}
