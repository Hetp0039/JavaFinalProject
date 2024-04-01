package dataaccesslayer;

import java.util.List;

import model.Inventory;

public interface InventoryDao {
    void save(Inventory item);
    void update(Inventory item);
    void delete(int itemId);
    List<Inventory> getInventoryItemsByUserId(int userId);
}
