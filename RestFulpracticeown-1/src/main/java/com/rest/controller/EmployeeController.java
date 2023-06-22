package com.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.exception.EmployeeAlreadyExistsException;
import com.rest.exception.EmployeeNotFoundException;
import com.rest.model.Employee;
import com.rest.service.EmployeeService;
@RestController
@RequestMapping("/api/v1")
//http://localhost:8080/api/v1/

//http://localhost:8082/api/v1/addEmp
//http://localhost:8082/api/v1/getAllemps
//http://localhost:8082/api/v1/deleteemp
//http://localhost:8082/api/v1/updateemp
//http://localhost:8082/api/v1/getempbyid
public class EmployeeController {
 @Autowired
 private EmployeeService empService;
 private ResponseEntity<?> responseEntity;
 @PostMapping("/addEmp")//working
 	public ResponseEntity<?> saveEmpHandler(@RequestBody Employee eobj) 
 	{
	 Employee newEmp=null;
	 try {
		 newEmp=this.empService.saveEmp(eobj);
	 }catch(EmployeeAlreadyExistsException e) {
		 e.printStackTrace();
	 }
	 responseEntity=new ResponseEntity<>(newEmp,HttpStatus.CREATED);
	 return responseEntity;
 	}
 @PutMapping("/updateemp/{eid}")//working
 public ResponseEntity<?> updateEmpHandler(@RequestBody Employee eobj,@PathVariable int eid)throws EmployeeNotFoundException{
 	Employee updatedata=this.empService.updateEmp(eobj, eid);
 	responseEntity=new ResponseEntity<>(updatedata,HttpStatus.OK);
 	return responseEntity;
 }
 @GetMapping("/getempbyid/{eid}")//http://localhost:8082/api/v1/getempbyid/4 working
 public ResponseEntity<?> getEmpByIdHandler(@PathVariable int eid)throws EmployeeNotFoundException{
	 Employee eobject=this.empService.getEmpById(eid);
	 responseEntity=new ResponseEntity<>(eobject,HttpStatus.OK);
	 return responseEntity;
 }
 @GetMapping("/getAllemps")//working
	public ResponseEntity<?> getAllNotesHandler()
	{
		List<Employee> allemps = this.empService.getAllEmp();
		responseEntity = new ResponseEntity<>(allemps,HttpStatus.OK);
		return responseEntity;
	}
 @DeleteMapping("/deleteemp/{eid}")//working
 public ResponseEntity<?> deleteEmpHandler(@PathVariable int eid) throws EmployeeNotFoundException{
	 boolean status=this.empService.delEmp(eid);
	 responseEntity=new ResponseEntity<>(status,HttpStatus.OK);
	 return responseEntity;
 }
}


