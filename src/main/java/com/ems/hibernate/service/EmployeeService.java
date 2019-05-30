package com.ems.hibernate.service;

import com.ems.hibernate.model.Employee;

import java.util.List;

public interface EmployeeService {
    void saveEmployee(Employee employee);

    List<Employee> findAllEmployees();

    void deleteEmployee(int id);

    Employee findEmployee(String email);

    void updateEmployee(Employee employee);
}
