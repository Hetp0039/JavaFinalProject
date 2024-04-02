package controller;

import java.util.List;
import java.util.Scanner;

import dataaccesslayer.FoodItemDao;
import model.FoodItem;

public class FoodItemController {
    private final FoodItemDao foodItemDao;
    private final Scanner scanner;

    public FoodItemController(FoodItemDao foodItemDao, Scanner scanner) {
        this.foodItemDao = foodItemDao;
        this.scanner = scanner;
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

    public void manageFoodItems() {
        System.out.println("Food Item Management");
        System.out.println("1. Add Food Item");
        System.out.println("2. Update Food Item");
        System.out.println("3. Remove Food Item");
        System.out.println("4. View All Food Items");
        System.out.println("5. Go Back");

        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (choice) {
            case 1:
                addFoodItemMenu();
                break;
            case 2:
                updateFoodItemMenu();
                break;
            case 3:
                removeFoodItemMenu();
                break;
            case 4:
                viewAllFoodItems();
                break;
            case 5:
                return;
            default:
                System.out.println("Invalid choice. Please try again.");
                manageFoodItems();
                break;
        }
    }

    private void addFoodItemMenu() {
        // Logic for adding a new food item
    }

    private void updateFoodItemMenu() {
        // Logic for updating a food item
    }

    private void removeFoodItemMenu() {
        // Logic for removing a food item
    }

    private void viewAllFoodItems() {
        List<FoodItem> foodItems = getAllFoodItems();
        // Display food items
    }
}
