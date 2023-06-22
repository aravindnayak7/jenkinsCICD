package com.rest.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.rest.model.Employee;
@Repository
public interface EmployeeRepository extends MongoRepository<Employee, Integer> {

}
//crud
//jpa crud