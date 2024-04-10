package model;

import java.util.Date;

public class Inventory {
    private int inventoryId;
    private int userId;
    private int itemId;
    private int quantity;
    private Date expirationDate;

    
    public Inventory() {
    }

    public Inventory(int userId, int itemId, int quantity, Date expirationDate) {
        this.userId = userId;
        this.itemId = itemId;
        this.quantity = quantity;
        this.expirationDate = expirationDate;
    }

    
    public int getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(int inventoryId) {
        this.inventoryId = inventoryId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public java.sql.Date getExpirationDate() {
        return (java.sql.Date) expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }
}
