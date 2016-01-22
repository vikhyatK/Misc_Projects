package com.guru.springrpc.service;

import com.guru.springrpc.manager.EmployeeManager;
import com.guru.springrpc.model.Employee;

import org.springframework.remoting.jaxrpc.ServletEndpointSupport;



import java.util.List;

import javax.xml.rpc.ServiceException;


public class EmployeeService extends ServletEndpointSupport implements EmployeeServiceInterface{
	EmployeeManager employeeManager;
	

	@Override
	protected void onInit() throws ServiceException {
		super.onInit();
		employeeManager = getApplicationContext().getBean("employeeManager", EmployeeManager.class);
	}
	
	public Employee[] getEmployees(){
		List<Employee> employees = employeeManager.getEmployees();
		Employee[] employee = new Employee[employees.size()];
		return employees.toArray(employee);
	}

}
