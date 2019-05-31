package com.ems.hibernate;

import com.ems.hibernate.config.AppConfig;
import com.ems.hibernate.service.EmployeeService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class Main {
    public static void main(String[] args) {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        EmployeeService service = (EmployeeService) context.getBean("employeeService");
        service.findAllEmployees().forEach(System.out::println);

        service.deleteEmployee(7);
        service.findAllEmployees().forEach(System.out::println);
    }
}
