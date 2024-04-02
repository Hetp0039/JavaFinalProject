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

    public void deleteCharitableOrganization(int organizationId) {
        charitableOrganizationDao.delete(organizationId);
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
        // Logic for registering a new charitable organization
    }

    private void updateCharitableOrganizationMenu() {
        // Logic for updating a charitable organization
    }

    private void deleteCharitableOrganizationMenu() {
        // Logic for deleting a charitable organization
    }

    private void viewAllCharitableOrganizations() {
        List<CharitableOrganization> organizations = getAllCharitableOrganizations();
        // Display all charitable organizations
    }
}
