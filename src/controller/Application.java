package controller;

import java.util.Scanner;
import businesslayer.BusinessLogic;
import dataaccesslayer.UserDao;
import dataaccesslayer.FoodItemDao;
import dataaccesslayer.ClaimDao;
import dataaccesslayer.InventoryDao;
import dataaccesslayer.UserDaoImpl;
import dataaccesslayer.FoodItemDaoImpl;
import dataaccesslayer.ClaimDaoImpl;
import dataaccesslayer.InventoryDaoImpl;
import dataaccesslayer.RetailerDaoImpl;
import dataaccesslayer.RetailerDao;

public class Application {

    public static void main(String[] args) {
        // Create instances of controllers and scanner
        UserDao userDao = new UserDaoImpl();
        FoodItemDao foodItemDao = new FoodItemDaoImpl();
        ClaimDao claimDao = new ClaimDaoImpl();
        RetailerDao retailerDao = new RetailerDaoImpl(); // Import RetailerDao and RetailerDaoImpl if not already done
        InventoryDao inventoryDao = new InventoryDaoImpl();
        Scanner scanner = new Scanner(System.in);

        // Create instances of controllers
        UserController userController = new UserController(userDao, scanner);
        FoodItemController foodItemController = new FoodItemController(foodItemDao, scanner);
        ClaimController claimController = new ClaimController(claimDao, scanner);
        RetailerController retailerController = new RetailerController(retailerDao, scanner);
        InventoryController inventoryController = new InventoryController(inventoryDao, scanner);

        // Create instance of BusinessLogic
        BusinessLogic businessLogic = new BusinessLogic(userController, foodItemController, claimController, retailerController, inventoryController, scanner);

        // Start the application
        businessLogic.start();
    }
}
