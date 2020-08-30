package leviosa.pumpkin.orderservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@ImportResource({"classpath:context.xml"})
@Configuration
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
@ComponentScan
@SpringBootApplication
@EnableTransactionManagement
@EnableJpaRepositories
@EntityScan

public class Main {  
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Main.class, args);

        //context.close();
    }
}