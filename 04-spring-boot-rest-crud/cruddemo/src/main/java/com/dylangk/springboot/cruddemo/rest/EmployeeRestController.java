package com.dylangk.springboot.cruddemo.rest;

// import com.dylangk.springboot.cruddemo.dao.EmployeeDAO;
import com.dylangk.springboot.cruddemo.entity.Employee;
import com.dylangk.springboot.cruddemo.services.EmployeeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tools.jackson.databind.json.JsonMapper;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    // private EmployeeDAO employeeDAO;
    private EmployeeServices employeeServices;

    private JsonMapper jsonMapper;

    // quick and dirty: inject employee dao

    @Autowired
    public EmployeeRestController(EmployeeServices theEmployeeService, JsonMapper theJsonMapper) {
        employeeServices = theEmployeeService;
        jsonMapper = theJsonMapper;
    }

    // expose "/employees" and return a list of employees
    @GetMapping("/employees")
    public List<Employee> findAll() {
        return employeeServices.findAll();
    }

    // add mapping for GET /employees/{employeeId}
    @GetMapping("/employees/{employeeId}")
    public Employee findById(@PathVariable int employeeId) {
        Employee employee = employeeServices.findById(employeeId);

        if (employee == null) {
            throw new RuntimeException("Employee not found - " + employeeId);
        }
        return employee;
    }

    // add mapping for POST/ employees - add new employee
    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee theEmployee){
        // also just in case they pass an id in JSON ... set id to 0

        // thid is to force a save of new item .. instead of update
        theEmployee.setId(0);

        Employee dbEmployee = employeeServices.save(theEmployee);
        return dbEmployee;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee){
        Employee dbEmployee = employeeServices.save(employee);
        return dbEmployee;
    }

    // add mapping for PATCH
    @PatchMapping("employees/{employeeId}")
    public Employee patchEmployee(@PathVariable int employeeId, @RequestBody Map<String, Object> patchPayLoad){
        Employee tempEmployee = employeeServices.findById(employeeId);

        // throw exception if null
        if (tempEmployee == null) {
            throw new RuntimeException("Employee not found - " + employeeId);
        }

        // throw exception if request contains "id" key
        if (patchPayLoad.containsKey("id")) {
            throw new RuntimeException("Cannot update id field");
        }

        Employee patchedEmployee = jsonMapper.updateValue(tempEmployee, patchPayLoad);

        Employee dbEmployee = employeeServices.save(patchedEmployee);
        return dbEmployee;
    }

    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId) {
        Employee tempEmployee = employeeServices.findById(employeeId);

        // throw exception is null
        if (tempEmployee == null) {
            throw new RuntimeException("Employee not found - " + employeeId);
        }

        employeeServices.deleteById(employeeId);
        return "Employee deleted - " + employeeId;
    }
}
