package com.kukuou.pickage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class PickageApplication {

    public static void main(String[] args) {
     ;
        ApplicationContext ctx = SpringApplication.run(PickageApplication.class, args);
        String[] activeProfiles = ctx.getEnvironment().getActiveProfiles();
        for (String profile : activeProfiles) {
            System.out.println("Spring Boot 使用profile为:{}" + profile);
        }

    }
}
