package com.sun.junit;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class TestEmployeeDetails {
	
	EmployeeDetails employeeDetails = new EmployeeDetails();
	EmpBusinessLogic empBusinessLogic = new EmpBusinessLogic();
	
	@Test
	public void testCalculateAppriasal() {
		employeeDetails.setName("Rikki");
		employeeDetails.setAge(22);
		employeeDetails.setMonthlySalary(18000);
	      double appraisal= empBusinessLogic.calculateAppraisal(employeeDetails);
	      assertEquals(1000, appraisal, 0.0);
	   }
	@Test
	public void testCalulateYearlySalary()
	{
		employeeDetails.setName("Rikki");
		employeeDetails.setAge(22);
		employeeDetails.setMonthlySalary(18000);
		double yearlySalary = empBusinessLogic.calculateYearlySalary(employeeDetails);
		assertEquals(216000, yearlySalary, 0.0);
	}

}
