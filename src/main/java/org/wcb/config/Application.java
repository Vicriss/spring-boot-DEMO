package org.wcb.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by wybe on 11/28/16.
 */

@SpringBootApplication(scanBasePackages = "org.wcb")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
