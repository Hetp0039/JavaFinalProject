package controller;

import java.util.List;
import java.util.Scanner;
import dataaccesslayer.RetailerDao;
import model.Retailer;

public class RetailerController {
    private final RetailerDao retailerDao;
    private final Scanner scanner;

    public RetailerController(RetailerDao retailerDao, Scanner scanner) {
        this.retailerDao = retailerDao;
        this.scanner = scanner;
    }

    public void registerRetailer(Retailer retailer) {
        retailerDao.save(retailer);
        System.out.println("Retailer registered successfully.");
    }

    public void updateRetailer(Retailer retailer) {
        retailerDao.update(retailer);
        System.out.println("Retailer updated successfully.");
    }

    public void removeRetailer(int retailerId) {
        retailerDao.delete(retailerId);
        System.out.println("Retailer removed successfully.");
    }

    public List<Retailer> getAllRetailers() {
        return retailerDao.getAllRetailers();
    }

    public void manageRetailers() {
        System.out.println("Retailer Management");
        System.out.println("1. Register Retailer");
        System.out.println("2. Update Retailer");
        System.out.println("3. Remove Retailer");
        System.out.println("4. View All Retailers");
        System.out.println("5. Go Back");

        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (choice) {
            case 1:
                registerRetailerMenu();
                break;
            case 2:
                updateRetailerMenu();
                break;
            case 3:
                removeRetailerMenu();
                break;
            case 4:
                viewAllRetailers();
                break;
            case 5:
                return;
            default:
                System.out.println("Invalid choice. Please try again.");
                manageRetailers();
                break;
        }
    }

    private void registerRetailerMenu() {
        System.out.println("Enter retailer details:");
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();
        System.out.print("User Type: ");
        String userType = scanner.nextLine();

        Retailer newRetailer = new Retailer(name, email, password, userType);
        registerRetailer(newRetailer); // Corrected method call
    }

    private void updateRetailerMenu() {
        System.out.print("Enter retailer ID to update: ");
        int retailerId = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        Retailer existingRetailer = retailerDao.getRetailerById(retailerId); // Use dao method to get retailer
        if (existingRetailer != null) {
            System.out.println("Enter updated details for retailer ID " + retailerId + ":");
            System.out.print("Name: ");
            existingRetailer.setName(scanner.nextLine());
            System.out.print("Email: ");
            existingRetailer.setEmail(scanner.nextLine());
            System.out.print("Password: ");
            existingRetailer.setPassword(scanner.nextLine());
            System.out.print("User Type: ");
            existingRetailer.setUserType(scanner.nextLine());
            updateRetailer(existingRetailer); // Corrected method call
        } else {
            System.out.println("Retailer with ID " + retailerId + " not found.");
        }
    }

    private void removeRetailerMenu() {
        System.out.print("Enter retailer ID to remove: ");
        int retailerId = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        removeRetailer(retailerId); // Corrected method call
    }

    private void viewAllRetailers() {
        List<Retailer> retailers = getAllRetailers(); // Corrected method call
        if (retailers.isEmpty()) {
            System.out.println("No retailers found.");
        } else {
            System.out.println("List of retailers:");
            for (Retailer retailer : retailers) {
                System.out.println(retailer);
            }
        }
    }
}
