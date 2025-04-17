package com.ems.controller;

import java.util.List;

import com.ems.exceptions.DuplicateEmployeeException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.ems.entities.Employee;
import com.ems.exceptions.EmployeeNotFoundException;
import com.ems.services.IEmployeeService;

@RestController
public class EmployeeController {
	private static final Logger log = LoggerFactory.getLogger(EmployeeController.class);
	@Autowired
	private IEmployeeService service;
	@GetMapping("/employee")
	public List<Employee> getEmps()  {

          log.info("Getting employees");
		return service.getEmployees();
	}
	
	@GetMapping("/employee/{id}")
	public Employee getEmp(@PathVariable("id") int id) {
		
		return service.getEmployee(id);
	}

	@PostMapping("/employee")
	public Employee employee(@RequestBody Employee employee) throws DuplicateEmployeeException {

		return service.createNewEmployee(employee);
	}

}
