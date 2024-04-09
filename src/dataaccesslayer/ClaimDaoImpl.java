package dataaccesslayer;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.Claim;

public  class ClaimDaoImpl implements ClaimDao {
  
    


    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    
    
    @Override
    public void save(Claim claim) {
        String query = "INSERT INTO claims (User_Id, Item_Id, claim_date) VALUES (?, ?, ?)";

        try{con = DataSource.getConnection(); 
         ps = con.prepareStatement(query);
            ps.setInt(1, claim.getUserId());
            ps.setInt(2, claim.getItemId());
            ps.setDate(3, new java.sql.Date(claim.getClaimDate().getTime()));

            int rowsInserted = ps.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Claim saved successfully.");
            } else {
                System.out.println("Failed to save claim.");
            }
        } catch (SQLException | IOException e) {
            System.out.println("Error saving claim: " + e.getMessage());
        }
    }

    @Override
    public List<Claim> getAllClaims() {
        List<Claim> claimList = new ArrayList<>();
        String query = "SELECT * FROM claims";

        try {con = DataSource.getConnection();
         ps = con.prepareStatement(query);
             ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
             
                int User_Id = resultSet.getInt("User_id");
                int Item_Id = resultSet.getInt("Item_id");
                Date claimDate = resultSet.getDate("claim_date");

                Claim claim = new Claim(User_Id, Item_Id, claimDate);
                claimList.add(claim);
            }
        } catch (SQLException | IOException e) {
            System.out.println("Error retrieving claims: " + e.getMessage());
        }

        return claimList;
    }

    @Override
    public void delete(int Claim_Id) {
        String query = "DELETE FROM claims WHERE Claim_Id = ?";

        try {con = DataSource.getConnection();
        ps  = con.prepareStatement(query);
            ps.setInt(1, Claim_Id);

            int rowsDeleted = ps.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Claim with ID " + Claim_Id + " has been deleted successfully.");
            } else {
                System.out.println("No claim found with ID " + Claim_Id + ".");
            }
        } catch (SQLException | IOException e) {
            System.out.println("Error deleting claim: " + e.getMessage());
        }
    }

    
}
