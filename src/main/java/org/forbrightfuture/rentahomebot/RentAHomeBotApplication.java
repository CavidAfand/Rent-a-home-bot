package org.forbrightfuture.rentahomebot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class RentAHomeBotApplication {

    public static void main(String[] args) {
        SpringApplication.run(RentAHomeBotApplication.class, args);
    }

}
