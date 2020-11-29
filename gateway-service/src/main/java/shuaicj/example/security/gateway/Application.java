package shuaicj.example.security.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import shuaicj.example.security.filters.AddUsernameFilter;

/**
 * Spring boot app.
 *
 * @author shuaicj 2017/10/18
 */
@SpringBootApplication
@EnableZuulProxy
public class Application {
    @Bean
    public AddUsernameFilter addUsernameFilter() {
        return new AddUsernameFilter();
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
