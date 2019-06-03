package com.ems.hibernate.controller;

import com.ems.hibernate.model.Designation;
import com.ems.hibernate.model.Employee;
import com.ems.hibernate.service.DesignationService;
import com.ems.hibernate.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequestMapping("/record/*")
public class RecordController {
    @Autowired
    private ApplicationContext context;

    private DesignationService designationService;
    private EmployeeService employeeService;


    @RequestMapping
    public String getReadForm() {
        return "search";
    }

    @RequestMapping(value = "/create")
    public String getRecordForm(Model model) {
        designationService = (DesignationService) context.getBean("designationService");
        model.addAttribute("designations", designationService.findAllDesignations());
        model.addAttribute("employee", new Employee());
        return "create";
    }

    @RequestMapping(value = "/read", method = RequestMethod.POST)
    public String getRecord(@ModelAttribute("email") String email, Model model) {
        employeeService = (EmployeeService) context.getBean("employeeService");
        designationService = (DesignationService) context.getBean("designationService");
        model.addAttribute("employeeDetails", employeeService.findEmployee(email));
        model.addAttribute("designations", designationService.findAllDesignations());

        return "search";
    }


    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String deleteRecord(@ModelAttribute("id") String id) {
        employeeService = (EmployeeService) context.getBean("employeeService");
        employeeService.deleteEmployee(Integer.parseInt(id));

        return "redirect:/";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String updateRecord(@ModelAttribute Employee em) {
        employeeService = (EmployeeService) context.getBean("employeeService");
        employeeService.updateEmployee(em);

        return "redirect:/";
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public String insertRecord(@ModelAttribute("employee") @Valid Employee em, BindingResult bindingResult, Model model) {
        designationService = (DesignationService) context.getBean("designationService");
        if (bindingResult.hasErrors()) {
            bindingResult.getAllErrors().forEach(System.out::println);
            model.addAttribute("designations", designationService.findAllDesignations());
            return "create";
        }

        employeeService = (EmployeeService) context.getBean("employeeService");
        employeeService.saveEmployee(em);
        return "redirect:/";
    }
}
