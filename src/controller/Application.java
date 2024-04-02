package controller;

import java.util.Scanner;

import businesslayer.BusinessLogic;
import dataaccesslayer.UserDao;
import dataaccesslayer.FoodItemDao;
import dataaccesslayer.ClaimDao;
import dataaccesslayer.UserDaoImpl;
import dataaccesslayer.FoodItemDaoImpl;
import dataaccesslayer.ClaimDaoImpl;

public class Application {

    public static void main(String[] args) {
        // Create instances of controllers and scanner
        UserDao userDao = new UserDaoImpl(); // Assuming UserDao implementation
        FoodItemDao foodItemDao = new FoodItemDaoImpl(null); // Assuming FoodItemDao implementation, pass null for now
        ClaimDao claimDao = new ClaimDaoImpl(null); // Assuming ClaimDao implementation, pass null for now
        Scanner scanner = new Scanner(System.in);

        // Create instances of controllers
        UserController userController = new UserController(userDao, scanner);
        FoodItemController foodItemController = new FoodItemController(foodItemDao,scanner);
        ClaimController claimController = new ClaimController(claimDao);

        // Create instance of BusinessLogic
        BusinessLogic businessLogic = new BusinessLogic(userController, foodItemController, claimController, scanner);

        // Start the application
        businessLogic.start();
    }
}
