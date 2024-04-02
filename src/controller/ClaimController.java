package controller;

import java.util.List;
import java.util.Scanner;

import dataaccesslayer.ClaimDao;

import model.Claim;

public class ClaimController {
    private final ClaimDao claimDao;
    private final Scanner scanner;

    public ClaimController(ClaimDao claimDao) {
        this.claimDao = claimDao;
		this.scanner = null;
       
    }



	public void submitClaim(Claim claim) {
        claimDao.save(claim);
    }

    public List<Claim> getAllClaims() {
        return claimDao.getAllClaims();
    }

    public void manageClaim() {
        System.out.println("Claim Management");
        System.out.println("1. Submit Claim");
        System.out.println("2. View All Claims");
        System.out.println("3. Go Back");

        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (choice) {
            case 1:
                submitClaimMenu();
                break;
            case 2:
                viewAllClaims();
                break;
            case 3:
                return;
            default:
                System.out.println("Invalid choice. Please try again.");
                manageClaim();
                break;
        }
    }

    private void submitClaimMenu() {
        // Logic for submitting a claim
    }

    private void viewAllClaims() {
        List<Claim> claims = getAllClaims();
        // Display all claims
    }
}
