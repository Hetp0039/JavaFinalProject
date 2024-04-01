package controller;

import java.util.List;

import dataaccesslayer.InventoryDao;
import model.Inventory;

public class InventoryController {
    private final InventoryDao inventoryDao;

    public InventoryController(InventoryDao inventoryDao) {
        this.inventoryDao = inventoryDao;
    }

    public void addInventoryItem(Inventory item) {
        inventoryDao.save(item);
    }

    public void updateInventoryItem(Inventory item) {
        inventoryDao.update(item);
    }

    public void removeInventoryItem(int itemId) {
        inventoryDao.delete(itemId);
    }

    public List<Inventory> getInventoryItemsByUserId(int userId) {
        return inventoryDao.getInventoryItemsByUserId(userId);
    }
}

