package com.example.multimoduleapplication.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.multimoduleapplication.model.Employee;
import com.example.multimodulelibrary.errors.CustomDataNotFoundException;
import com.example.multimodulelibrary.errors.CustomParameterConstraintException;

@RestController
@Service
public class EmployeeController {
	private static final Logger LOGGER = LogManager.getLogger(EmployeeController.class);

	@RequestMapping("/hello")
	public List<Employee> getEmployees() {
		List<Employee> employeesList = new ArrayList<Employee>();
		try {

			employeesList.add(new Employee(1, "venkat", "reddy", "gmail"));

		} catch (Exception exception) {
			LOGGER.error("Error occurred in business service : {}", exception.getMessage());
		}
		return employeesList;
	}
	
	@RequestMapping("/notfound")
    public List<Employee> getException1() 
    {
		try {
	       System.out.println(" a NullPointerException error");
	         throw new NullPointerException("NG microservices to showcase core exceptions");
	     } catch (NullPointerException e) {
	         throw new CustomDataNotFoundException(e.getMessage());
	     }
    }
	
	@RequestMapping("/badrequest")
    public List<Employee> getException2() 
    {
		try {
	       System.out.println(" a NullPointerException error");
	         throw new NullPointerException("NG microservices to showcase core exceptions");
	     } catch (NullPointerException e) {
	         throw new CustomParameterConstraintException(e.getMessage());
	     }
    }

}
