package com.sathya.sprinbootmvc.employeemodel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeModel {
	private int empid;
	private String empName;
	private double empsalary;
	private int empage;
	private String empdepartment;
	private String empexperinces;
}
