package com.ibs.inventory.service;

import com.ibs.inventory.dao.InventoryDao;
import com.ibs.inventory.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryService {

    @Autowired
    private InventoryDao inventoryDao;

    public void addProduct(Product product) {
        inventoryDao.addProduct(product);
    }

    public List<Product> displayProducts() {
        return inventoryDao.getAllProducts();
    }

    public String purchaseProduct(String name, Integer count) {
        return inventoryDao.buyProduct(name, count);
    }
}
