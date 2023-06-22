package com.rest.service;

import java.util.List;

import com.rest.exception.EmployeeAlreadyExistsException;
import com.rest.exception.EmployeeNotFoundException;
import com.rest.model.Employee;

public interface EmployeeService {
	public Employee saveEmp(Employee eobj)throws EmployeeAlreadyExistsException;
	public Employee updateEmp(Employee eobj,int eid)throws EmployeeNotFoundException;
	public Employee getEmpById(int eid)throws EmployeeNotFoundException;
	public List<Employee> getAllEmp();
	public boolean delEmp(int eid)throws EmployeeNotFoundException;
}
