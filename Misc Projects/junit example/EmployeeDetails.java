package com.sun.junit;

public class EmployeeDetails {

	private String name;
	private double monthlySalary;
	private int age;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void setMonthlySalary(double monthlySalary) {
		this.monthlySalary = monthlySalary;
	}
	public double getMonthlySalary() {
		return monthlySalary;
	}
	
}
