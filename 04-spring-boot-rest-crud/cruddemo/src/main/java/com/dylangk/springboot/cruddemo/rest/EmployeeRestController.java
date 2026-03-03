package com.dylangk.springboot.cruddemo.rest;

// import com.dylangk.springboot.cruddemo.dao.EmployeeDAO;
import com.dylangk.springboot.cruddemo.entity.Employee;
import com.dylangk.springboot.cruddemo.services.EmployeeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    // private EmployeeDAO employeeDAO;
    private EmployeeServices employeeServices;

    // quick and dirty: inject employee dao

    @Autowired
    public EmployeeRestController(EmployeeServices theEmployeeService) {
        employeeServices = theEmployeeService;
    }

    // expose "/employees" and return a list of employees
    @GetMapping("/employees")
    public List<Employee> findAll() {
        return employeeServices.findAll();
    }
}
