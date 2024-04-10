package controller;

import java.util.List;
import java.util.Scanner;

import dataaccesslayer.UserDao;
import dataaccesslayer.UserDaoImpl;
import model.User;

public class UserController {
    private  UserDao userDao;
    private  Scanner scanner;

    public UserController(UserDao userDao, Scanner scanner) {
        this.userDao = userDao;
        this.scanner = scanner;
    }

    public void registerUser(User user) {
        userDao.save(user);
        System.out.println("User registered successfully.");
    }

    public User getUserByEmail(String userId) {
        return userDao.getUserByEmail(userId);
    }

    public void updateUser(User user) {
        userDao.update(user);
        System.out.println("User updated successfully.");
    }

    public void deleteUser(int userId) {
        userDao.delete(userId);
        System.out.println("User deleted successfully.");
    }

    public List<User> getAllUsers() {
    	UserDao userDao2 = new UserDaoImpl();
        return userDao2.getAllUsers();
    }

    public void manageUsers() {
        System.out.println("User Management");
        System.out.println("1. Register User");
        System.out.println("2. Update User");
        System.out.println("3. Delete User");
        System.out.println("4. View All Users");
        System.out.println("5. Go Back");

        int choice = getUserInput();

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

    private int getUserInput() {
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        return choice;
    }

    private void registerUserMenu() {
        System.out.println("Enter user details:");
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();
        System.out.print("User Type: ");
        String userType = scanner.nextLine();
        
        User newUser = new User(name, email, password, userType);
        registerUser(newUser);
    }
    private void updateUserMenu() {
        System.out.print("Enter user ID to update: ");
        String userId = scanner.toString();
        scanner.nextLine(); // Consume newline
        User existingUser = getUserByEmail(userId);
        if (existingUser != null) {
            System.out.println("Enter updated details:");
            System.out.print("Name: ");
            String name = scanner.nextLine();
            System.out.print("Email: ");
            String email = scanner.nextLine();
            System.out.println("Password");
            String Password=scanner.nextLine();
            System.out.print("User Type: ");
            String userType = scanner.nextLine();
            
            existingUser.setName(name);
            existingUser.setEmail(email);
            existingUser.setPassword(Password);
            existingUser.setUserType(userType);
            updateUser(existingUser);
        } else {
            System.out.println("User with ID " + userId + " not found.");
        }
    }

    private void deleteUserMenu() {
        System.out.print("Enter user ID to delete: ");
        int userId = scanner.nextInt();
        scanner.nextLine(); 
        deleteUser(userId);
    }

    private void viewAllUsers() {
        List<User> users = getAllUsers();
        if (users.isEmpty()) {
            System.out.println("No users found.");
        } else {
            System.out.println("List of users:");
            for (User user : users) {
                System.out.println(user);
            }
        }
    }
}
