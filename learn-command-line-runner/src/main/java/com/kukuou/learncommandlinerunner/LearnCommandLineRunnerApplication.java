package com.kukuou.learncommandlinerunner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class LearnCommandLineRunnerApplication {

    public static void main(String[] args) {
        System.out.println(
                "启动前"
        );
        SpringApplication.run(LearnCommandLineRunnerApplication.class, args);
        System.out.println("启动后");

    }
}
