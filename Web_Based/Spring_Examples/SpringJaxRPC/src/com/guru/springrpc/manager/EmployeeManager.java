package com.guru.springrpc.manager;


import com.guru.springrpc.dao.EmployeeDao;
import com.guru.springrpc.model.Employee;



import java.util.List;

public class EmployeeManager {

	EmployeeDao employeeDao;

	public EmployeeDao getEmployeeDao() {
		return employeeDao;
	}

	public void setEmployeeDao(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}

	public List<Employee> getEmployees() {
		return getEmployeeDao().getEmployees();
	}
}
