package controller;
import java.util.List;

import dataaccesslayer.FoodItemDao;
import model.FoodItem;

public class FoodItemController {
    private final FoodItemDao foodItemDao;

    public FoodItemController(FoodItemDao foodItemDao) {
        this.foodItemDao = foodItemDao;
    }

    public void addFoodItem(FoodItem foodItem) {
        foodItemDao.save(foodItem);
    }

    public void updateFoodItem(FoodItem foodItem) {
        foodItemDao.update(foodItem);
    }

    public void removeFoodItem(int itemId) {
        foodItemDao.delete(itemId);
    }

    public List<FoodItem> getAllFoodItems() {
        return foodItemDao.getAllFoodItems();
    }
}
