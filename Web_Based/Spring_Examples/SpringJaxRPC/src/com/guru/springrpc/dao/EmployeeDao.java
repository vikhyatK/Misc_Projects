package com.guru.springrpc.dao;



import com.guru.springrpc.model.Employee;

import java.util.ArrayList;
import java.util.List;

public class EmployeeDao {

	public List<Employee> getEmployees() {
		List<Employee> employees = new ArrayList<Employee>();
		Employee employee = new Employee();
		employee.setId(2309l);
		employee.setFirstName("Gurunath");
		employee.setLastName("Joshi");
		employees.add(employee);
		return employees;
	}

}
