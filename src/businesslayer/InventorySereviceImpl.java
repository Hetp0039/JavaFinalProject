
package businesslayer;

import java.util.List;

import dataaccesslayer.InventoryDao;
import model.Inventory;

public class InventoryServiceImpl implements InventoryService {
    private InventoryDao inventoryDao;

    public InventoryServiceImpl(InventoryDao inventoryDao) {
        this.inventoryDao = inventoryDao;
    }

    @Override
    public List<Inventory> getInventoryByUserId(int userId) {
        return inventoryDao.getInventoryByUserId(userId);
    }
    // Implement other InventoryService methods
}
