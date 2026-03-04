package com.dylangk.springboot.cruddemo.services;

import com.dylangk.springboot.cruddemo.dao.EmployeeRepository;
import com.dylangk.springboot.cruddemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServicesImpl implements EmployeeServices{

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServicesImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(int id) {
        Optional<Employee> result = employeeRepository.findById(id);
        Employee theEmployee = null;

        if (result.isPresent()) {
            theEmployee = result.get();
        }
        else{
            throw new RuntimeException("Employee not found - " + id);
        }
        return theEmployee;
    }

    @Override
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public void deleteById(int id) {
        employeeRepository.deleteById(id);
    }


}
