package com.leviosa.pumpkin.orderservice.controllers;

import com.leviosa.pumpkin.orderservice.controllers.dto.GetOrdersResponseDto;
import com.leviosa.pumpkin.orderservice.controllers.dto.MakeOrderRequestDto;
import com.leviosa.pumpkin.orderservice.domain.*;
import com.leviosa.pumpkin.orderservice.facade.OrderFacade;
import com.leviosa.pumpkin.orderservice.service.*;

import java.security.Principal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @PostMapping(path = "make_order", consumes = "application/json")
    public void makeOrder(@RequestBody MakeOrderRequestDto dto) {
        orderFacade.createOrder(dto.getRestaurantId(), dto.getEmpolyeeId(), dto.getDate(), dto.getMealIdAmountMap());
    }

    @GetMapping("get_orders/{id}")
    public List<GetOrdersResponseDto> getOrdersResponseDto(@PathVariable int id,
            @RequestParam(required = false) String dateFrom, 
            @RequestParam(required = false) String dateTo,
            Principal principal) throws Exception {
                if (!principal.getName().equals(id)) {
                    throw new Exception("Wrong credentials");
                }

                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                return dateFrom == null || dateTo == null ?
                orderFacade.getAllOrdersForEmployee(id) :
                orderFacade.getOrdersForDates(id,format.parse(dateFrom), format.parse(dateTo));
    }
}