package dataaccesslayer;

import java.sql.*;
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
        // Implementation similar to UserDaoImpl
    }

    @Override
    public Retailer getRetailerByEmail(String email) {
        // Implementation similar to UserDaoImpl
    }

    @Override
    public List<Retailer> getAllRetailers() {
        // Implementation similar to UserDaoImpl
    }

    @Override
    public void save(Retailer retailer) {
        // Implementation similar to UserDaoImpl
    }

    @Override
    public void update(Retailer retailer) {
        // Implementation similar to UserDaoImpl
    }

    @Override
    public void delete(int retailerId) {
        // Implementation similar to UserDaoImpl
    }

    // Helper method to extract retailer from ResultSet
    private Retailer extractRetailerFromResultSet(ResultSet resultSet) throws SQLException {
        Retailer retailer = new Retailer();
        // Populate retailer fields from ResultSet
        return retailer;
    }
}
