package com.demo.controller;

import com.demo.model.Order;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class OrderController {

    @GetMapping("/order")
    public String orderForm(Model model) {
        model.addAttribute("order", new Order(0, "", 0, 0.0));
        return "order";
    }

    @PostMapping("/saveOrder")
    public String saveOrder(@RequestParam("orderId") int orderId,
                            @RequestParam("product") String product,
                            @RequestParam("quantity") int quantity,
                            @RequestParam("totalPrice") double totalPrice,
                            Model model) {
        Order order = new Order(orderId, product, quantity, totalPrice);
        model.addAttribute("order", order);
        return "orderResult";
    }
}
