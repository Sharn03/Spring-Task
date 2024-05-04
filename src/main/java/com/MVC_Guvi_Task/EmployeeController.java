package com.MVC_Guvi_Task;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Controller

public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/index")
	public String index()
	{
		return "index";
	}
	
	//create an end-point for adding the employee
	@PostMapping("/createEmployee")
	@ResponseStatus(HttpStatus.CREATED)
	public String createEmployee( @ModelAttribute ("employee") Employee employee)
	{
		
		employeeService.addEmployee(employee);
		 
		 return "addedEmployee";
	}
	
	
	//create an end-point for displaying all the employee
	@GetMapping("/displayAllEmployee")
	public ModelAndView getAllEmployee()
	{
		 List<Employee> list = employeeService.findAllEmployee();
		 ModelAndView mv = new ModelAndView();
		 for(Employee e : list)
		 {
			 mv.addObject("displayAllEmployee", list);
			 System.out.println();
		 }
		 
		 mv.setViewName("employeeList");
		 return mv;
	}
	
	//create an end-point for displaying the employee based on id
	@GetMapping("displayEmployeeById/{id}")
	public ModelAndView getEmployeeById(@PathVariable String id)
	{
		Employee employee = employeeService.findByEmployeeId(id);
		 ModelAndView mv = new ModelAndView();
		 mv.addObject("displayEmployeeById", employee);
		 mv.setViewName("employeeDetailsById");
		 return mv;
	}
	
	@PutMapping("/updateEmployee")
	public Employee  updateEmployee(@RequestBody Employee employee)
	{
		return employeeService.updateEmployee(employee);
	}
}
