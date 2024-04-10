package dataaccesslayer;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.User;

public class UserDaoImpl implements UserDao {
    private Connection connection;
    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    

    @Override
    public void save(User user) {
    	
		try {
            con = DataSource.getConnection();
            ps = con.prepareStatement("INSERT INTO user (Name,Email,Password,UserType) VALUES (?,?,?,?)",
                    PreparedStatement.RETURN_GENERATED_KEYS);
            
            ps.setString(1, user.getName());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getPassword());
            ps.setString(4, user.getUserType());
            ps.executeUpdate();
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public User getUserByEmail(String email) {
       
        return null; 
    }

    @Override
    public void update(User user) {
        String query = "UPDATE user SET Name = ?, Password = ?, Email = ? UserType=? WHERE UserId = ?";

        try { con = DataSource.getConnection();
             ps = con.prepareStatement(query);{
             ps.setString(1, user.getName());
             ps.setString(2, user.getPassword());
             ps.setString(3, user.getEmail());
             ps.setString(4, user.getUserType ());
             ps.setInt(5,user.getUserId());
            int rowsUpdated = ps.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("User updated successfully.");
            } else {
                System.out.println("No user found with the given ID.");
            }}}
         catch (SQLException | IOException e) {
            System.out.println("Error updating user: " + e.getMessage());
        }
    }



    @Override
    public void delete(int userId) {
        String query = "DELETE FROM user WHERE User_Id = ?";

        try {
        	con = DataSource.getConnection();
            ps= con.prepareStatement(query); {
            	ps.setInt(1, userId);

            int rowsDeleted = ps.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("User with ID " + userId + " has been deleted successfully.");
            } else {
                System.out.println("No user found with ID " + userId + ".");
            }
             }
        }catch (SQLException | IOException e) {
            System.out.println("Error deleting user: " + e.getMessage());
        }
    }

    @Override
    public List<User> getAllUsers() {
        List<User> userList = new ArrayList<>();
        String query = "SELECT * FROM user";

        try {con = DataSource.getConnection();
            ps= con.prepareStatement(query);
             rs = ps.executeQuery(); {
            while (rs.next()) {
                String Name = rs.getString("Name");
                String Password = rs.getString("Password");
                String Email = rs.getString("Email");
                String UserType=rs.getString("UserType");
                User user = new User( Name, Password, Email,UserType);
                userList.add(user);
            }
        }
        }catch (SQLException | IOException e) {
            System.out.println("Error retrieving users: " + e.getMessage());
        }

        return userList;
    }
}
    
