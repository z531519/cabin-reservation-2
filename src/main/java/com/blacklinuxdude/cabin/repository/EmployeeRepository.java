package com.blacklinuxdude.cabin.repository;

import com.blacklinuxdude.cabin.model.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "employees", path = "employees")
public interface EmployeeRepository extends CrudRepository<Employee, String> {
}
