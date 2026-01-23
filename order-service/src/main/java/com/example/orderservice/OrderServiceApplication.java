package com.example.orderservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RestController
public class OrderServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderServiceApplication.class, args);
    }

    @GetMapping("/orders")
    public List<Order> getOrders() {
        return List.of(
            new Order(1, "Laptop", 2),
            new Order(2, "Phone", 5),
            new Order(3, "Headphones", 3)
        );
    }
}

class Order {
    private int id;
    private String item;
    private int quantity;

    public Order(int id, String item, int quantity) {
        this.id = id;
        this.item = item;
        this.quantity = quantity;
    }

    public int getId() { return id; }
    public String getItem() { return item; }
    public int getQuantity() { return quantity; }
}
