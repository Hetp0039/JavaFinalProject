package controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import dataaccesslayer.InventoryDao;
import model.Inventory;

public class InventoryController {
    private final InventoryDao inventoryDao;
    private final Scanner scanner;

    public InventoryController(InventoryDao inventoryDao, Scanner scanner) {
        this.inventoryDao = inventoryDao;
        this.scanner = scanner;
    }

    public void addInventory(Inventory inventory) {
        inventoryDao.save(inventory);
        System.out.println("Inventory added successfully.");
    }

    public void updateInventory(Inventory inventory) {
        inventoryDao.update(inventory);
        System.out.println("Inventory updated successfully.");
    }
    
    public Inventory getInventoryById(int inventoryId) {
        return inventoryDao.getInventoryById(inventoryId);
    }

    public void removeInventory(int inventoryId) {
        inventoryDao.delete(inventoryId);
        System.out.println("Inventory removed successfully.");
    }

    public List<Inventory> getAllInventory() {
        return inventoryDao.getAllInventory();
    }

    public void manageInventory() {
        System.out.println("Inventory Management");
        System.out.println("1. Add Inventory");
        System.out.println("2. Update Inventory");
        System.out.println("3. Remove Inventory");
        System.out.println("4. View All Inventory");
        System.out.println("5. Go Back");

        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (choice) {
            case 1:
                addInventoryMenu();
                break;
            case 2:
                updateInventoryMenu();
                break;
            case 3:
                removeInventoryMenu();
                break;
            case 4:
                viewAllInventory();
                break;
            case 5:
                return;
            default:
                System.out.println("Invalid choice. Please try again.");
                manageInventory();
                break;
        }
    }


private void addInventoryMenu() {
    System.out.println("Enter inventory details:");
    System.out.print("User ID: ");
    int userId = scanner.nextInt();
    scanner.nextLine(); // Consume newline
    System.out.print("Item ID: ");
    int itemId = scanner.nextInt();
    scanner.nextLine(); // Consume newline
    System.out.print("Quantity: ");
    int quantity = scanner.nextInt();
    scanner.nextLine(); // Consume newline
    System.out.print("Expiration Date (yyyy-MM-dd): ");
    String dateString = scanner.nextLine();

    Date expirationDate = null;
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    try {
        expirationDate = dateFormat.parse(dateString);
    } catch (ParseException e) {
        System.out.println("Invalid date format. Please enter the date in yyyy-MM-dd format.");
        return; // Exit the method if date parsing fails
    }
        // Create a new Inventory object with the provided details
        Inventory newInventory = new Inventory(userId, itemId, quantity, expirationDate);

        // Call addInventory method passing the new Inventory object
        addInventory(newInventory);
    }


private void updateInventoryMenu() {
    System.out.print("Enter inventory ID to update: ");
    int inventoryId = scanner.nextInt();
    scanner.nextLine(); // Consume newline

    // Retrieve existing inventory from DAO using the ID
    Inventory existingInventory = getInventoryById(inventoryId);
    if (existingInventory != null) {
        System.out.println("Enter updated details for inventory ID " + inventoryId + ":");
        System.out.print("User ID: ");
        existingInventory.setUserId(scanner.nextInt());
        scanner.nextLine(); // Consume newline
        System.out.print("Item ID: ");
        existingInventory.setItemId(scanner.nextInt());
        scanner.nextLine(); // Consume newline
        System.out.print("Quantity: ");
        existingInventory.setQuantity(scanner.nextInt());
        scanner.nextLine(); // Consume newline

        // Parse and set the expiration date
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        System.out.print("Expiration Date (yyyy-MM-dd): ");
        String dateString = scanner.nextLine();
        try {
            Date expirationDate = dateFormat.parse(dateString);
            existingInventory.setExpirationDate(expirationDate);

            // Call updateInventory method passing the existing Inventory object
            updateInventory(existingInventory);
        } catch (ParseException e) {
            System.out.println("Invalid date format. Please enter the date in yyyy-MM-dd format.");
        }
    } else {
        System.out.println("Inventory with ID " + inventoryId + " not found.");
    }
}

    private void removeInventoryMenu() {
        System.out.print("Enter inventory ID to remove: ");
        int inventoryId = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        // Call removeInventory method passing the inventory ID
        removeInventory(inventoryId);
    }

    private void viewAllInventory() {
        // Retrieve all inventory items from DAO
        List<Inventory> inventoryList = getAllInventory();

        if (inventoryList.isEmpty()) {
            System.out.println("No inventory found.");
        } else {
            System.out.println("List of inventory items:");
            for (Inventory inventory : inventoryList) {
                System.out.println(inventory);
            }
        }
    }
}
