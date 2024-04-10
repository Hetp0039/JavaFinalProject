package businesslayer;

import java.util.List;

import model.Inventory;

public interface InventoryService {
    List<Inventory> getInventoryByUserId(int userId);
    // Other methods related to inventory management
}

