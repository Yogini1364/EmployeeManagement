package com.tka.Controller;

import com.tka.employee.Dao.EmployeeDao;

import tka.employee.entity.Employee;

public class EmployeeController {
	
	public static void main(String[] args) {
		EmployeeDao dao=new EmployeeDao();
		
		Employee emp=new Employee("Sidhu", 35000);
		System.out.println(dao.saveEmployee(emp));
		
		
		System.out.println(dao.getavgsalaryofemp());
		System.out.println(dao.getCount());
		System.out.println(dao.getEmployeebylistdesc());
		
	}

}
