package dataaccesslayer;

import java.util.List;

import model.Retailer;

public interface RetailerDao {
    void save(Retailer retailer);
    void update(Retailer retailer);
    void delete(int retailerId);
    Retailer getRetailerByEmail(String email);
    List<Retailer> getAllRetailers();
}
