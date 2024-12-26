package com.sathya.sprinbootmvc.empcontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.sathya.sprinbootmvc.employeemodel.EmployeeModel;


@Controller
public class EmployeeController {
    @GetMapping("/employeeform")
	public String getEmployee()
	{
		return "add-emp";
	}
	@PostMapping("/saveemployee")
	public String saveEmployee(EmployeeModel employeeModel)
	{
		System.out.println(employeeModel);
		return "Employee";
	}
}
