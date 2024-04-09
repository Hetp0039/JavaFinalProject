package dataaccesslayer;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Retailer;

public class RetailerDaoImpl implements RetailerDao {
 
	  Connection con = null;
	    PreparedStatement ps = null;
	    ResultSet rs = null;


 

    @Override
    public List<Retailer> getAllRetailers() {
        List<Retailer> retailers = new ArrayList<>();
        try {
            con = DataSource.getConnection();
            ps  = con.prepareStatement("SELECT * FROM Retailer");
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                Retailer retailer = extractRetailerFromResultSet(resultSet);
                retailers.add(retailer);
            }
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
        return retailers;
    }

    @Override
    public void save(Retailer retailer) {
        try {
            con = DataSource.getConnection();
            ps  = con.prepareStatement("INSERT INTO Retailer (Name, Email, Password, UserType) VALUES (?, ?, ?, ?)");
            ps.setString(1, retailer.getName());
            ps.setString(2, retailer.getEmail());
            ps.setString(3, retailer.getPassword());
            ps.setString(4, retailer.getUserType());
            ps.executeUpdate();
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Retailer retailer) {
        try {
            con = DataSource.getConnection();
            ps= con.prepareStatement("UPDATE Retailer SET Name = ?, Email = ?, Password = ?, UserType = ? WHERE User_ID = ?");
            ps.setString(1, retailer.getName());
            ps.setString(2, retailer.getEmail());
            ps.setString(3, retailer.getPassword());
            ps.setString(4, retailer.getUserType());
            ps.setInt(5, retailer.getUserId());
            ps.executeUpdate();
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int retailerId) {
        try {
            con = DataSource.getConnection();
            ps  = con.prepareStatement("DELETE FROM Retailer WHERE User_ID = ?");
            ps.setInt(1, retailerId);
            ps.executeUpdate();
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Retailer getRetailerByEmail(String email) {
        Retailer retailer = null;
        try {
            ps  = con.prepareStatement("SELECT * FROM Retailer WHERE Email = ?");
            ps.setString(1, email);
            ResultSet resultSet = ps.executeQuery();
            if (resultSet.next()) {
                retailer = extractRetailerFromResultSet(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return retailer;
    }

    @Override
    public Retailer getRetailerById(int retailerId) {
        Retailer retailer = null;
        try {
            ps  = con.prepareStatement("SELECT * FROM Retailer WHERE User_ID = ?");
            ps.setInt(1, retailerId);
            ResultSet resultSet = ps.executeQuery();
            if (resultSet.next()) {
                retailer = extractRetailerFromResultSet(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return retailer;
    }

    private Retailer extractRetailerFromResultSet(ResultSet resultSet) throws SQLException {
        Retailer retailer = new Retailer();
        retailer.setUserId(resultSet.getInt("User_ID"));
        retailer.setName(resultSet.getString("Name"));
        retailer.setEmail(resultSet.getString("Email"));
        retailer.setPassword(resultSet.getString("Password"));
        retailer.setUserType(resultSet.getString("UserType"));
        return retailer;
    }
}