package dataaccesslayer;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Inventory;

public class InventoryDaoImpl implements InventoryDao {
   
  
	Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    
    @Override
    public void save(Inventory item) {
        String sql = "INSERT INTO inventory (User_ID, Item_ID, Quantity, Expiration_Date) VALUES (?, ?, ?, ?)";
        try {con = DataSource.getConnection();
       ps  = con.prepareStatement(sql);
            ps.setInt(1, item.getUserId());
            ps.setInt(2, item.getItemId());
            ps.setInt(3, item.getQuantity());
            ps.setDate(4, item.getExpirationDate());
            ps.executeUpdate();
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Inventory item) {
        String sql = "UPDATE inventory SET Quantity = ?, Expiration_Date = ? WHERE User_ID = ? AND Item_ID = ?";
        try { con = DataSource.getConnection();
        		ps  = con.prepareStatement(sql);
            ps.setInt(1, item.getQuantity());
            ps.setDate(2, item.getExpirationDate());
            ps.setInt(3, item.getUserId());
            ps.setInt(4, item.getItemId());
            ps.executeUpdate();
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int itemId) {
        String sql = "DELETE FROM Inventory WHERE Item_ID = ?";
        try { con = DataSource.getConnection(); 
         ps = con.prepareStatement(sql);
            ps.setInt(1, itemId);
            ps.executeUpdate();
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Inventory> getInventoryItemsByUserId(int userId) {
        List<Inventory> inventoryItems = new ArrayList<>();
        String sql = "SELECT * FROM inventory WHERE User_ID = ?";
        try {
        con = DataSource.getConnection();
        ps  = con.prepareStatement(sql);
            ps.setInt(1, userId);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                Inventory item = new Inventory();
                item.setUserId(resultSet.getInt("User_ID"));
                item.setItemId(resultSet.getInt("Item_ID"));
                item.setQuantity(resultSet.getInt("Quantity"));
                item.setExpirationDate(resultSet.getDate("Expiration_Date"));
                inventoryItems.add(item);
            }
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
        return inventoryItems;
    }

    @Override
    public Inventory getInventoryById(int itemId) {
        String sql = "SELECT * FROM inventory WHERE Item_ID = ?";
        try {con = DataSource.getConnection();
        
        ps  = con.prepareStatement(sql);
            ps.setInt(1, itemId);
            ResultSet resultSet = ps.executeQuery();
            if (resultSet.next()) {
                Inventory item = new Inventory();
                item.setUserId(resultSet.getInt("User_ID"));
                item.setItemId(resultSet.getInt("Item_ID"));
                item.setQuantity(resultSet.getInt("Quantity"));
                item.setExpirationDate(resultSet.getDate("Expiration_Date"));
                return item;
            }
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Inventory> getAllInventory() {
        List<Inventory> inventoryItems = new ArrayList<>();
        String sql = "SELECT * FROM Inventory";
        try {
        con = DataSource.getConnection();
        ps  = con.prepareStatement(sql);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                Inventory item = new Inventory();
                item.setUserId(resultSet.getInt("User_ID"));
                item.setItemId(resultSet.getInt("Item_ID"));
                item.setQuantity(resultSet.getInt("Quantity"));
                item.setExpirationDate(resultSet.getDate("Expiration_Date"));
                inventoryItems.add(item);
            }
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
        return inventoryItems;
    }
}
