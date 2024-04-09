package controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import dataaccesslayer.ClaimDao;
import model.Claim;

public class ClaimController {
    private final ClaimDao claimDao;
    private final Scanner scanner;

    public ClaimController(ClaimDao claimDao, Scanner scanner) {
        this.claimDao = claimDao;
        this.scanner = scanner;
    }

    public void addClaim(Claim claim) {
        claimDao.save(claim);
        System.out.println("Claim added successfully.");
    }

    public void removeClaim(int claimId) {
        claimDao.delete(claimId);
        System.out.println("Claim removed successfully.");
    }

    public List<Claim> getAllClaims() {
        return claimDao.getAllClaims();
    }

    public void manageClaims() {
        System.out.println("Claim Management");
        System.out.println("1. Add Claim");
        System.out.println("2. Remove Claim");
        System.out.println("3. View All Claims");
        System.out.println("4. Go Back");

        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (choice) {
            case 1:
                addClaimMenu();
                break;
            case 2:
                removeClaimMenu();
                break;
            case 3:
                viewAllClaims();
                break;
            case 4:
                return;
            default:
                System.out.println("Invalid choice. Please try again.");
                manageClaims();
                break;
        }
    }

    private void addClaimMenu() {
        System.out.println("Enter claim details:");
        System.out.print("User ID: ");
        int userId = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Item ID: ");
        int itemId = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Claim Date (yyyy-MM-dd): ");
        Date claimDate = null;
        try {
            claimDate = new SimpleDateFormat("yyyy-MM-dd").parse(scanner.nextLine());
        } catch (ParseException e) {
            e.printStackTrace(); // Handle parsing exception
        }

        Claim newClaim = new Claim(userId, itemId, claimDate);
        addClaim(newClaim);
    }

    private void removeClaimMenu() {
        System.out.print("Enter claim ID to remove: ");
        int claimId = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        removeClaim(claimId);
    }

    private void viewAllClaims() {
        List<Claim> claims = getAllClaims();
        if (claims.isEmpty()) {
            System.out.println("No claims found.");
        } else {
            System.out.println("List of claims:");
            for (Claim claim : claims) {
                System.out.println(claim);
            }
        }
    }

    // This method was missing before, added to resolve the compilation error
    public void manageClaim() {
        manageClaims();
    }
}
