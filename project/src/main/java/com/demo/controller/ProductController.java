package com.demo.controller;

import com.demo.model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductController {

    @GetMapping("/product")
    public String productForm(Model model) {
        model.addAttribute("product", new Product(0, "", 0.0));
        return "product";
    }

    @PostMapping("/saveProduct")
    public String saveProduct(@RequestParam("productId") int productId,
                              @RequestParam("productName") String productName,
                              @RequestParam("productPrice") double productPrice,
                              Model model) {
        Product product = new Product(productId, productName, productPrice);
        model.addAttribute("product", product);
        return "productResult";
    }
}
