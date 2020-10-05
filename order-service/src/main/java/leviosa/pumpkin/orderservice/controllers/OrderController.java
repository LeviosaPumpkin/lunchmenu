package leviosa.pumpkin.orderservice.controllers;

import leviosa.pumpkin.orderservice.controllers.dto.GetOrdersResponseDto;
import leviosa.pumpkin.orderservice.controllers.dto.MakeOrderRequestDto;
import leviosa.pumpkin.orderservice.domain.*;
import leviosa.pumpkin.orderservice.facade.OrderFacade;
import leviosa.pumpkin.orderservice.service.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping(value = "orders")
class OrderController {

    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private OrderFacade orderFacade;
    
    @GetMapping("get_employee/{id}")
    public void getEmployee(@PathVariable("id") int id) {
        Employee employee = employeeService.get(id);
        System.out.println(employee.getName());
    }

    @PostMapping(path="make_order", consumes = "application/json")
    public void makeOrder(@RequestBody MakeOrderRequestDto dto) {
        orderFacade.createOrder(dto.getRestaurantId(), dto.getEmpolyeeId(), dto.getDate(), dto.getMealIdAmountMap());   
    }

    @GetMapping("get_orders/{id}")
    public List<GetOrdersResponseDto> getOrdersResponseDto(@PathVariable int id) {
        return orderFacade.getOrders(id);
    }
}