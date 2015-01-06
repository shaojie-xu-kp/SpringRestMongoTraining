package com.fashionis.ecommerce.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.fashionis.ecommerce.model.Employee;

public interface EmployeeRepo extends CrudRepository<Employee, Integer> {
	
	public Employee save(Employee em);
	
	public Employee findById(Integer id);
	
	public List<Employee> findAll();
	
	public void delete(Employee em);
	
	boolean exists(Integer primaryKey);
	
	long count();
	
}
