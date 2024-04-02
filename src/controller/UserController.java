package controller;

import java.util.List;
import java.util.Scanner;

import dataaccesslayer.UserDao;
import model.User;

public class UserController {
    private final UserDao userDao;
    private final Scanner scanner;

    public UserController(UserDao userDao, Scanner scanner) {
        this.userDao = userDao;
        this.scanner = scanner;
    }

 
	public void registerUser(User user) {
        userDao.save(user);
    }

    public User getUserByEmail(String email) {
        return userDao.getUserByEmail(email);
    }

    public void updateUser(User user) {
        userDao.update(user);
    }

    public void deleteUser(int userId) {
        userDao.delete(userId);
    }

    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    public void manageUsers() {
        System.out.println("User Management");
        System.out.println("1. Register User");
        System.out.println("2. Update User");
        System.out.println("3. Delete User");
        System.out.println("4. View All Users");
        System.out.println("5. Go Back");

        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (choice) {
            case 1:
                registerUserMenu();
                break;
            case 2:
                updateUserMenu();
                break;
            case 3:
                deleteUserMenu();
                break;
            case 4:
                viewAllUsers();
                break;
            case 5:
                return;
            default:
                System.out.println("Invalid choice. Please try again.");
                manageUsers();
                break;
        }
    }

    private void registerUserMenu() {
        // Logic for registering a new user
    }

    private void updateUserMenu() {
        // Logic for updating a user
    }

    private void deleteUserMenu() {
        // Logic for deleting a user
    }

    private void viewAllUsers() {
        List<User> users = getAllUsers();
        // Display users
    }
}
