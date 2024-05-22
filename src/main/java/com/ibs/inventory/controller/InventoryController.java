package com.ibs.inventory.controller;

import com.ibs.inventory.model.Product;
import com.ibs.inventory.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    @PostMapping("/product")
    public void product(@RequestBody Product product){
        inventoryService.addProduct(product);
    }

    @GetMapping("/listProducts")
    public List<Product> displayProducts() {
        return inventoryService.displayProducts();
    }

    @GetMapping("/purchaseProduct/{name}/{count}")
    public String purchaseProduct(@PathVariable("name") String name, @PathVariable("count") Integer count) {
        return inventoryService.purchaseProduct(name, count);
    }
}
