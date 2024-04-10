package dataaccesslayer;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.FoodItem;

public class FoodItemDaoImpl implements FoodItemDao {
    


    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;



    @Override
    public void save(FoodItem foodItem) {
        String query = "INSERT INTO food_item (Item_Name, Item_Type, quantity, expiration_date, price) VALUES (?, ?, ?, ?, ?)";

        try {con = DataSource.getConnection();
        	ps = con.prepareStatement(query); 
            ps.setString(1, foodItem.getItemName());
            ps.setString(2, foodItem.getItemType());
            ps.setInt(3, foodItem.getQuantity());
            ps.setDate(4, new java.sql.Date(foodItem.getExpirationDate().getTime()));
            ps.setBigDecimal(5, foodItem.getPrice());

            int rowsInserted = ps.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Food item saved successfully.");
            } else {
                System.out.println("Failed to save food item.");
            }
        } catch (SQLException | IOException e) {
            System.out.println("Error saving food item: " + e.getMessage());
        }
    }
    public FoodItem getFoodItemById(int itemId) {
        
        return null; 
    }
    @Override
    public void update(FoodItem foodItem) {
        String query = "UPDATE food_item SET Item_Name = ?, Item_Type = ?, quantity = ?, expiration_date = ?, price = ? WHERE itemId = ?";

        try {con = DataSource.getConnection(); 
            ps = con.prepareStatement(query);
            ps.setString(1, foodItem.getItemName());
            ps.setString(2, foodItem.getItemType());
            ps.setInt(3, foodItem.getQuantity());
            ps.setDate(4, new java.sql.Date(foodItem.getExpirationDate().getTime()));
            ps.setBigDecimal(5, foodItem.getPrice());
            ps.setInt(6, foodItem.getItemId());

            int rowsUpdated = ps.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Food item updated successfully.");
            } else {
                System.out.println("No food item found with the given ID.");
            }
        } catch (SQLException | IOException e) {
            System.out.println("Error updating food item: " + e.getMessage());
        }
    }
    @Override
    public void delete(int Item_Id) {
        String query = "DELETE FROM food_item WHERE Item_Id = ?";

        try{con = DataSource.getConnection(); 
         ps = con.prepareStatement(query);
         ps.setInt(1, Item_Id);

            int rowsDeleted = ps.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Food item with ID " + Item_Id + " has been deleted successfully.");
            } else {
                System.out.println("No food item found with ID " + Item_Id + ".");
            }
        } catch (SQLException | IOException e) {
            System.out.println("Error deleting food item: " + e.getMessage());
        }
    }
    @Override
    public List<FoodItem> getAllFoodItems() {
        List<FoodItem> foodItemList = new ArrayList<>();
        String query = "SELECT * FROM food_item";

        try {con = DataSource.getConnection();
         ps = con.prepareStatement(query);
             ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
               
                String Item_Name = resultSet.getString("Item_Name");
                String Item_Type = resultSet.getString("Item_Type");
                int quantity = resultSet.getInt("quantity");
                Date expirationDate = resultSet.getDate("expiration_date");
                BigDecimal price = resultSet.getBigDecimal("price");

                FoodItem foodItem = new FoodItem(Item_Name,  Item_Type,  quantity,  expirationDate,  price);
                foodItemList.add(foodItem);
            }
        } catch (SQLException | IOException e) {
            System.out.println("Error retrieving food items: " + e.getMessage());
        }

        return foodItemList;
    }
}
