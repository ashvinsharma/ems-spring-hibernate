package com.ems.hibernate;

import com.ems.hibernate.config.AppConfig;
import com.ems.hibernate.service.DesignationService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class Main {
    public static void main(String[] args) {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
//        EmployeeService service = (EmployeeService) context.getBean("employeeService");
//        service.findAllEmployees().forEach(System.out::println);

        DesignationService service = (DesignationService) context.getBean("designationService");
        System.out.println(service.findDesignation("hr"));
//        Employee e = service.findEmployee("a@l.com");
//        e.setContact("7896541230");
//        service.updateEmployee(e);
//
//        service.deleteEmployee(6);
//        Employee e1 = new Employee("b@l.com", e.getName(), e.getDesignationId(), "0123456789");
//        service.saveEmployee(e1);
//
//        service.findAllEmployees().forEach(System.out::println);
//
    }
}
