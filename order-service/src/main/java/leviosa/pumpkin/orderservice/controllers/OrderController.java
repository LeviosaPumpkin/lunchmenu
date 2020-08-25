package leviosa.pumpkin.orderservice.controllers;

import leviosa.pumpkin.orderservice.domain.*;
import leviosa.pumpkin.orderservice.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "order")
class OrderController {

    @Autowired
    EmployeeService employeeService;
    
    @GetMapping("get_employee/{id}")
    public void getEmployee(@PathVariable("id") int id) {
        Employee employee = employeeService.get(id);
        System.out.println(employee.getName());
    }
    
}