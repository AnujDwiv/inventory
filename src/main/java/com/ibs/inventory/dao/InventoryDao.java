package com.ibs.inventory.dao;

import com.ibs.inventory.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class InventoryDao {

    Map<String, Integer> inventoryData = new HashMap<>();

    public void addProduct(Product product) {
        if (inventoryData.containsKey(product.getName())) {
            inventoryData.put(product.getName(), inventoryData.get(product.getName()) + 1);
        }else{
            inventoryData.put(product.getName(), 1);
        }
    }

    public List<Product> getAllProducts() {
        List<Product> products = inventoryData.keySet().stream().filter(key -> inventoryData.get(key) > 0).map(name -> new Product(name)).collect(Collectors.toList());
//        for(Map.Entry<String, Integer> entry : inventoryData.entrySet()) {
//            if (entry.getValue() == 0){
//                continue;
//            }
//            Product product = new Product(entry.getKey());
//            products.add(product);
//        }
        return products;
    }

    public String buyProduct(String name, Integer count) {
        if (inventoryData.containsKey(name)) {
            int total = inventoryData.get(name);
            if (total >= count) {
                inventoryData.put(name, inventoryData.get(name) - 1);
                return "Product Purchased Successfully!";
            }else{
                return "The count asked for the product is not available!";
            }
        }else{
            return "Product Unavailable!";
        }

    }
}
