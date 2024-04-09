package businesslayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import controller.UserController;
import controller.FoodItemController;
import controller.ClaimController;

public class BusinessLogic {

    private UserController userController;
    private FoodItemController foodItemController;
    private ClaimController claimController;
    private Scanner scanner;

    public BusinessLogic(UserController userController, FoodItemController foodItemController, ClaimController claimController, Scanner scanner) {
        this.userController = userController;
        this.foodItemController = foodItemController;
        this.claimController = claimController;
        this.scanner = scanner;
    }

    public void start() {
        // Initialize database
        initializeDatabase();

        // Your application's main logic goes here
        System.out.println("Welcome to FWRP Project!");

        // Example: Display a menu and handle user input
        displayMenu();
    }

    private void initializeDatabase() {
        String url = "jdbc:mysql://127.0.0.1:3306/javafinalproject";
        String username = "root";
        String password = "Het@00000";

        try (Connection connection = DriverManager.getConnection(url, username, password);
             Statement statement = connection.createStatement()) {
            // Create database
            statement.executeUpdate("DROP DATABASE IF EXISTS FWRP");
            statement.executeUpdate("CREATE DATABASE FWRP");
            statement.executeUpdate("USE FWRP");

            // Execute SQL script to create tables
            String createTablesSQL = "CREATE TABLE Users (userId INT AUTO_INCREMENT PRIMARY KEY, name VARCHAR(255), email VARCHAR(255), password VARCHAR(255), userType VARCHAR(50))";
            statement.executeUpdate(createTablesSQL);
            // Add more SQL statements to create other tables if needed

            System.out.println("Database initialized successfully.");
        } catch (SQLException e) {
            System.out.println("Error initializing database: " + e.getMessage());
        }
    }

    private void displayMenu() {
        // Display menu options
        System.out.println("1. User Management");
        System.out.println("2. Food Item Management");
        System.out.println("3. Transaction Management");
        System.out.println("4. Exit");

        // Read user input
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        // Process user input
        switch (choice) {
            case 1:
                userController.manageUsers();
                break;
            case 2:
                foodItemController.manageFoodItems();
                break;
            case 3:
                claimController.manageClaim();
                break;
            case 4:
                System.out.println("Exiting...");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
                displayMenu(); // Redisplay menu
                break;
        }
    }
}
