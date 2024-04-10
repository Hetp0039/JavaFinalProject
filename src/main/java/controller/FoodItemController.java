package controller;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
        System.out.println("Food item added successfully.");
    }

    public void updateFoodItem(FoodItem foodItem) {
        foodItemDao.update(foodItem);
        System.out.println("Food item updated successfully.");
    }

    public void removeFoodItem(int itemId) {
        foodItemDao.delete(itemId);
        System.out.println("Food item removed successfully.");
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
        System.out.println("Enter food item details:");
        System.out.print("Item Name: ");
        String itemName = scanner.nextLine();
        System.out.print("Item Type: ");
        String itemType = scanner.nextLine();
        System.out.print("Quantity: ");
        int quantity = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Expiration Date (yyyy-MM-dd): ");
        Date expirationDate = null;
        try {
            expirationDate = new SimpleDateFormat("yyyy-MM-dd").parse(scanner.nextLine());
        } catch (ParseException e) {
            e.printStackTrace(); // Handle parsing exception
        }
        System.out.print("Price: ");
        BigDecimal price = scanner.nextBigDecimal();
        scanner.nextLine(); // Consume newline

        FoodItem newFoodItem = new FoodItem(itemName, itemType, quantity, expirationDate, price);
        addFoodItem(newFoodItem);
    }

    private void updateFoodItemMenu() {
        System.out.print("Enter item ID to update: ");
        int itemId = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        FoodItem existingItem = foodItemDao.getFoodItemById(itemId);
        if (existingItem != null) {
            System.out.println("Enter updated details for item ID " + itemId + ":");
            System.out.print("Item Name: ");
            existingItem.setItemName(scanner.nextLine());
            System.out.print("Item Type: ");
            existingItem.setItemType(scanner.nextLine());
            System.out.print("Quantity: ");
            existingItem.setQuantity(scanner.nextInt());
            scanner.nextLine(); // Consume newline
            System.out.print("Expiration Date (yyyy-MM-dd): ");
            Date expirationDate = null;
            try {
                expirationDate = new SimpleDateFormat("yyyy-MM-dd").parse(scanner.nextLine());
            } catch (ParseException e) {
                e.printStackTrace(); // Handle parsing exception
            }
            existingItem.setExpirationDate(expirationDate);
            System.out.print("Price: ");
            existingItem.setPrice(scanner.nextBigDecimal());
            scanner.nextLine(); // Consume newline
            updateFoodItem(existingItem);
        } else {
            System.out.println("Food item with ID " + itemId + " not found.");
        }
    }

    private void removeFoodItemMenu() {
        System.out.print("Enter item ID to remove: ");
        int itemId = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        removeFoodItem(itemId);
    }

    private void viewAllFoodItems() {
        List<FoodItem> foodItems = getAllFoodItems();
        if (foodItems.isEmpty()) {
            System.out.println("No food items found.");
        } else {
            System.out.println("List of food items:");
            for (FoodItem foodItem : foodItems) {
                System.out.println(foodItem);
            }
        }
    }
}
