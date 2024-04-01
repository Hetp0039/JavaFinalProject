package dataaccesslayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Retailer;

public class RetailerDaoImpl implements RetailerDao {
    private Connection connection;

    public RetailerDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Retailer getRetailerById(int retailerId) {
        Retailer retailer = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Retailer WHERE User_ID = ?");
            preparedStatement.setInt(1, retailerId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                retailer = extractRetailerFromResultSet(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return retailer;
    }

    @Override
    public Retailer getRetailerByEmail(String email) {
        Retailer retailer = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Retailer WHERE Email = ?");
            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                retailer = extractRetailerFromResultSet(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return retailer;
    }

    @Override
    public List<Retailer> getAllRetailers() {
        List<Retailer> retailers = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Retailer");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Retailer retailer = extractRetailerFromResultSet(resultSet);
                retailers.add(retailer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return retailers;
    }

    @Override
    public void save(Retailer retailer) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Retailer (Name, Email, Password, UserType) VALUES (?, ?, ?, ?)");
            preparedStatement.setString(1, retailer.getName());
            preparedStatement.setString(2, retailer.getEmail());
            preparedStatement.setString(3, retailer.getPassword());
            preparedStatement.setString(4, retailer.getUserType());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Retailer retailer) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE Retailer SET Name = ?, Email = ?, Password = ?, UserType = ? WHERE User_ID = ?");
            preparedStatement.setString(1, retailer.getName());
            preparedStatement.setString(2, retailer.getEmail());
            preparedStatement.setString(3, retailer.getPassword());
            preparedStatement.setString(4, retailer.getUserType());
            preparedStatement.setInt(5, retailer.getUserId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int retailerId) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM Retailer WHERE User_ID = ?");
            preparedStatement.setInt(1, retailerId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
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
