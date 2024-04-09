package businesslayer;

import java.util.Scanner;
import controller.UserController;
import controller.FoodItemController;
import controller.RetailerController;
import controller.ClaimController;
import controller.InventoryController; // Import InventoryController

public class BusinessLogic {

    private UserController userController;
    private FoodItemController foodItemController;
    private ClaimController claimController;
    private RetailerController retailerController;
    private InventoryController inventoryController; // Add InventoryController
    private Scanner scanner;

    public BusinessLogic(UserController userController, FoodItemController foodItemController, ClaimController claimController, RetailerController retailerController, InventoryController inventoryController, Scanner scanner) {
        this.userController = userController;
        this.foodItemController = foodItemController;
        this.claimController = claimController;
        this.retailerController = retailerController;
        this.inventoryController = inventoryController; // Initialize InventoryController
        this.scanner = scanner;
    }

    public void start() {
        initializeDatabase();
        System.out.println("Welcome to FWRP Project!");
        displayMenu();
    }

    private void initializeDatabase() {
        // Initialization code remains the same
    }

    private void displayMenu() {
        System.out.println("1. User Management");
        System.out.println("2. Food Item Management");
        System.out.println("3. Transaction Management");
        System.out.println("4. Retailer Management");
        System.out.println("5. Inventory Management"); // Add inventory management option
        System.out.println("6. Exit");

        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                userController.manageUsers();
                break;
            case 2:
                foodItemController.manageFoodItems();
                break;
            case 3:
                claimController.manageClaims();
                break;
            case 4:
                retailerController.manageRetailers();
                break;
            case 5:
                inventoryController.manageInventory(); // Call inventory management method
                break;
            case 6:
                System.out.println("Exiting...");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
                displayMenu();
                break;
        }
    }
}
