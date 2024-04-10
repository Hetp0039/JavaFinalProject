package dataaccesslayer;

import java.util.List;

import model.FoodItem;

public interface FoodItemDao {
    void save(FoodItem foodItem);
    void update(FoodItem foodItem);
    void delete(int itemId);
    List<FoodItem> getAllFoodItems();
	FoodItem getFoodItemById(int itemId);
}

