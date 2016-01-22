package com.sun.junit;

public class EmpBusinessLogic {
	
	public double calculateYearlySalary(EmployeeDetails employeeDeatils)
	{
		double yearlySalary = 0;
		yearlySalary = employeeDeatils.getMonthlySalary() * 12;
		return yearlySalary;
	}
	
	public double calculateAppraisal(EmployeeDetails employeeDeatils)
	{
		double appraisal = 0;
		if(employeeDeatils.getMonthlySalary() < 15000)
		{
			appraisal = 500;
		}
		else {
			appraisal = 1000;
		}
		return appraisal;
	}
}
