package employee_order;

import employee_order.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource({"classpath:context.xml"})
public class Main {  
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Main.class);
        EmployeeService employeeService = context.getBean(EmployeeService.class);
        employeeService.create("Sansa Stark", 2000.0f);
        employeeService.create("Robert Baratheon", 2000.0f);
//        employeeService.create("Arya Stark", 2000.0f);
//        employeeService.create("Tyrion Lannister", 2000.0f);
//        employeeService.create("Sam Tarly", 2000.0f);

        context.close();
    }
}