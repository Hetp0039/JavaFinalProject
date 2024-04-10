package controller;

import java.util.List;
import java.util.Scanner;

import dataaccesslayer.CharitableOrganizationDao;
import model.CharitableOrganization;

public class CharitableOrganizationController {
    private final CharitableOrganizationDao charitableOrganizationDao;
    private final Scanner scanner;

    public CharitableOrganizationController(CharitableOrganizationDao charitableOrganizationDao, Scanner scanner) {
        this.charitableOrganizationDao = charitableOrganizationDao;
        this.scanner = scanner;
    }

    public void registerCharitableOrganization(CharitableOrganization organization) {
        charitableOrganizationDao.save(organization);
    }

    public CharitableOrganization getCharitableOrganizationByEmail(String email) {
        return charitableOrganizationDao.getCharitableOrganizationByEmail(email);
    }

    public void updateCharitableOrganization(CharitableOrganization organization) {
        charitableOrganizationDao.update(organization);
    }

    public void deleteCharitableOrganization(int User_Id) {
        charitableOrganizationDao.delete(User_Id);
    }

    public List<CharitableOrganization> getAllCharitableOrganizations() {
        return charitableOrganizationDao.getAllCharitableOrganizations();
    }

    public void manageCharitableOrganizations() {
        System.out.println("Charitable Organization Management");
        System.out.println("1. Register New Charitable Organization");
        System.out.println("2. Update Charitable Organization");
        System.out.println("3. Delete Charitable Organization");
        System.out.println("4. View All Charitable Organizations");
        System.out.println("5. Go Back");

        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (choice) {
            case 1:
                registerCharitableOrganizationMenu();
                break;
            case 2:
                updateCharitableOrganizationMenu();
                break;
            case 3:
                deleteCharitableOrganizationMenu();
                break;
            case 4:
                viewAllCharitableOrganizations();
                break;
            case 5:
                return;
            default:
                System.out.println("Invalid choice. Please try again.");
                manageCharitableOrganizations();
                break;
        }
    }

    private void registerCharitableOrganizationMenu() {
        System.out.println("Register New Charitable Organization");
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter email: ");
        String email = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        System.out.print("Enter user type: ");
        String userType = scanner.nextLine();

        CharitableOrganization organization = new CharitableOrganization(name, email, password, userType);
        registerCharitableOrganization(organization);
        System.out.println("Charitable Organization registered successfully.");
    }

    private void updateCharitableOrganizationMenu() {
        System.out.println("Update Charitable Organization");
        System.out.print("Enter organization ID: ");
        int User_Id = scanner.nextInt();
        scanner.nextLine(); 
        CharitableOrganization organization = getCharitableOrganizationById(User_Id);
        if (organization != null) {
            System.out.print("Enter new name: ");
            String name = scanner.nextLine();
            System.out.print("Enter new email: ");
            String email = scanner.nextLine();
            System.out.print("Enter new password: ");
            String password = scanner.nextLine();
            System.out.print("Enter new user type: ");
            String userType = scanner.nextLine();

            organization.setName(name);
            organization.setEmail(email);
            organization.setPassword(password);
            organization.setUserType(userType);

            updateCharitableOrganization(organization);
            System.out.println("Charitable Organization updated successfully.");
        } else {
            System.out.println("Charitable Organization with ID " + User_Id + " not found.");
        }
    }

    private void deleteCharitableOrganizationMenu() {
        System.out.println("Delete Charitable Organization");
        System.out.print("Enter organization ID: ");
        int User_Id = scanner.nextInt();
       
  
        deleteCharitableOrganization(User_Id);
        System.out.println("Charitable Organization deleted successfully.");
        
    }

    private void viewAllCharitableOrganizations() {
        List<CharitableOrganization> organizations = getAllCharitableOrganizations();
        System.out.println("All Charitable Organizations:");
        for (CharitableOrganization organization : organizations) {
            System.out.println(organization);
        }
    }

    private CharitableOrganization getCharitableOrganizationById(int organizationId) {
        List<CharitableOrganization> organizations = getAllCharitableOrganizations();
        for (CharitableOrganization organization : organizations) {
            if (organization.getUserId() == organizationId) {
                return organization;
            }
        }
        return null;
    }
}
