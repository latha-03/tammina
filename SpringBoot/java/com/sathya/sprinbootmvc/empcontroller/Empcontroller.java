package com.sathya.sprinbootmvc.empcontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.sathya.sprinbootmvc.modelclass.EmployeeModel;

@Controller
public class Empcontroller {
	@GetMapping("/Employeeform")
	public String getEmployee()
	{
		return "add-emp";
	}
	
	
	
	@PostMapping("/saveEmployee")
	public String saveEmployee(EmployeeModel employeeModel)
	{
		System.out.println(employeeModel);
		return "Employee";
	}
}
