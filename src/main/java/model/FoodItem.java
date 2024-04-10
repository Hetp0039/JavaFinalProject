package model;

import java.math.BigDecimal;
import java.util.Date;

public class FoodItem {
    private int itemId;
    private String itemName;
    private String itemType;
    private int quantity;
    private Date expirationDate;
    private BigDecimal price;

    
    public FoodItem() {
    }

    public FoodItem(String itemName, String itemType, int quantity, Date expirationDate, BigDecimal price) {
        this.itemName = itemName;
        this.itemType = itemType;
        this.quantity = quantity;
        this.expirationDate = expirationDate;
        this.price = price;
    }

   
    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
