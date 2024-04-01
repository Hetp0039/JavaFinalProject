package controller;

import java.util.List;

import dataaccesslayer.RetailerDao;
import model.Retailer;

public class RetailerController {
    private final RetailerDao retailerDao;

    public RetailerController(RetailerDao retailerDao) {
        this.retailerDao = retailerDao;
    }

    public void registerRetailer(Retailer retailer) {
        retailerDao.save(retailer);
    }

    public Retailer getRetailerByEmail(String email) {
        return retailerDao.getRetailerByEmail(email);
    }

    public void updateRetailer(Retailer retailer) {
        retailerDao.update(retailer);
    }

    public void deleteRetailer(int retailerId) {
        retailerDao.delete(retailerId);
    }

    public List<Retailer> getAllRetailers() {
        return retailerDao.getAllRetailers();
    }
}
