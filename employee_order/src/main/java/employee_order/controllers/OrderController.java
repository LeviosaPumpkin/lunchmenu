package employee_order.controllers;

import employee_order.domain.Employee;
import employee_order.service.EmployeeService;
import employee_order.service.OrderService;
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