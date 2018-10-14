package com.kukuou.learncommandlinerunner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @author olx
 * @date 2018/10/14/014
 */
@Component
public class TaskRunner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        System.out.println("这是为通过实现命令行方法来获取自启动功能");
    }
}
