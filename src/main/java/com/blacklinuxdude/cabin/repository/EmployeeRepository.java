package com.blacklinuxdude.cabin.repository;

import com.blacklinuxdude.cabin.model.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

//@RepositoryRestResource(collectionResourceRel = "employees", path = "employees")
@Repository
public interface EmployeeRepository extends CrudRepository<Employee, String> {

    public List<Employee> findByOrderByHiredAsc();
}
