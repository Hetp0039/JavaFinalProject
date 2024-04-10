package dataaccesslayer;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.CharitableOrganization;

public class CharitableOrganizationDaoImpl implements CharitableOrganizationDao {
   
	  Connection con = null;
	    PreparedStatement ps = null;
	    ResultSet rs = null;

	    

    @Override
    public void save(CharitableOrganization organization) {
        String sql = "INSERT INTO charitable_organization (Name, Email, Password,UserType) VALUES (?, ?, ?, ?)";
        try {con = DataSource.getConnection();
       
          ps  = con.prepareStatement(sql); 
            ps.setString(1, organization.getName());
            ps.setString(2, organization.getEmail());
            ps.setString(3, organization.getPassword());
            ps.setString(4, organization.getUserType());
            ps.executeUpdate();
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(CharitableOrganization organization) {
        String sql = "UPDATE charitable_organization SET Name = ?, Email = ?, Password = ?, UserType = ? WHERE User_Id = ?";
        try   
        {
        con = DataSource.getConnection();
        	ps  = con.prepareStatement(sql);
            ps.setString(1, organization.getName());
            ps.setString(2, organization.getEmail());
            ps.setString(3, organization.getPassword());
            ps.setString(4, organization.getUserType());
            ps.setInt(5, organization.getUserId());
            ps.executeUpdate();
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int User_Id) {
        String sql = "DELETE FROM charitable_organization WHERE User_Id = ?";
        try  {
        	con = DataSource.getConnection();
         ps = con.prepareStatement(sql);
         ps.setInt(1, User_Id);
            ps.executeUpdate();
            
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public CharitableOrganization getCharitableOrganizationByEmail(String email) {
        String sql = "SELECT * FROM charitable_organization WHERE Email = ?";
        try  {con = DataSource.getConnection();
            ps.setString(1, email);
            try (ResultSet resultSet = ps.executeQuery()) {
                if (resultSet.next()) {
                    return new CharitableOrganization(
                       
                            resultSet.getString("name"),
                            resultSet.getString("email"),
                            resultSet.getString("password"),
                            resultSet.getString("user_type")
                    );
                }
            }
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<CharitableOrganization> getAllCharitableOrganizations() {
        List<CharitableOrganization> organizations = new ArrayList<>();
        String sql = "SELECT * FROM charitable_organization";
        try { con = DataSource.getConnection();
        
        ps  = con.prepareStatement(sql);
             ResultSet resultSet = ps.executeQuery(); {
            while (resultSet.next()) {
                organizations.add(new CharitableOrganization(
                      
                        resultSet.getString("Name"),
                        resultSet.getString("Email"),
                        resultSet.getString("Password"),
                        resultSet.getString("UserType")
                ));}
            }}
         catch (SQLException | IOException e) {
            e.printStackTrace();
        }
        return organizations;
    }
}
