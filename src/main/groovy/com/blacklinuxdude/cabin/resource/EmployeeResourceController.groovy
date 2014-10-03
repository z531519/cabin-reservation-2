package com.blacklinuxdude.cabin.resource

import com.blacklinuxdude.cabin.model.Employee
import com.blacklinuxdude.cabin.repository.EmployeeRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController

/**
 * Created by kdeleon on 10/2/14.
 */
@RestController
@RequestMapping("/employees")
class EmployeeResourceController {

    @Autowired
    EmployeeRepository employeeRepository;

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET)
    public List<Employee> getEmployees() {
        return employeeRepository.findAll()
    }

    @ResponseBody
    @RequestMapping( value = "/{id}", method = RequestMethod.POST)
    public Employee updateEmployee(@PathVariable('id') String id, @RequestBody Employee employee) {
        employeeRepository.save(employee);
        return employee;
    }

    @ResponseBody
    @RequestMapping( method = RequestMethod.POST)
    public Employee updateEmployee(@RequestBody Employee employee) {
        employeeRepository.save(employee);
        return employee;
    }


}
