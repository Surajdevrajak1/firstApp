package com.employee.service;

import java.util.List;

import com.employee.entities.Employee;
import com.employee.exception.BusinessException;

public interface EmployeeServiceInterface {

	public Employee addEmployee(Employee employee) throws BusinessException;

	public List<Employee> getAllEmployees();

	public Employee getEmpById(Long empidL);

	public void deleteEmpById(Long empidL);
	
}
