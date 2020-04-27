package com.aoher;

import com.aoher.types.order.Order;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OrderApp {

    public static void main(String[] args) {
        SpringApplication.run(Order.class, args);
    }
}
