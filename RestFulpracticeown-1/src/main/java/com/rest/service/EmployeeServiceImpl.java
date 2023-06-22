package com.rest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.exception.EmployeeAlreadyExistsException;
import com.rest.exception.EmployeeNotFoundException;
import com.rest.model.Employee;
import com.rest.repository.EmployeeRepository;
@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeRepository emprepository;
	@Override
	public Employee saveEmp(Employee eobj) throws EmployeeAlreadyExistsException{
		Optional<Employee> optional=this.emprepository.findById(eobj.getEmpId());
		Employee addEmp=null;
		if(optional.isPresent()) {
			System.out.println("record already exist");
			throw new EmployeeAlreadyExistsException();
		}else {
			addEmp=this.emprepository.save(eobj);
		}
		return addEmp;
	}

	@Override
	public Employee updateEmp(Employee eobj, int eid) throws EmployeeNotFoundException {
		Optional<Employee> optional=this.emprepository.findById(eid);
		Employee updateEmp=null;
		Employee myobj=null;
		if(optional.isPresent()) {
			System.out.println("Record exist");
			myobj=optional.get();
			myobj.setEmpName(eobj.getEmpName());
			myobj.setPassword(eobj.getPassword());
			
			updateEmp=this.emprepository.save(myobj);
		}else {
			System.out.println("record not exist");
		}
		return updateEmp;
	}

	@Override
	public Employee getEmpById(int eid) throws EmployeeNotFoundException{
		Optional<Employee> optional=this.emprepository.findById(eid);
		Employee getemp=null;
		if(optional.isPresent()) {
			getemp=optional.get();
		}else {
			System.out.println("Employee Not Found");
			throw new EmployeeNotFoundException();
		}
		return getemp;
	}

	@Override
	public List<Employee> getAllEmp() {
		
		return this.emprepository.findAll();
	}

	@Override
	public boolean delEmp(int eid) throws EmployeeNotFoundException{
		Optional<Employee> optional=this.emprepository.findById(eid);
	    boolean status=false;
	    if(optional.isPresent()) {
	    	System.out.println("record exists");
	    	this.emprepository.delete(optional.get());
	    	status=true;
	    }else {
	    	System.out.println("emp record not present");
	    	throw new EmployeeNotFoundException();
	    }
		return false;
	}

}
