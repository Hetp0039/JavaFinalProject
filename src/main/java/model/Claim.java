package model;

import java.util.Date;

public class Claim {
    private int claimId;
    private int userId;
    private int itemId;
    private Date claimDate;

    // Constructors
    public Claim() {
    }

    public Claim(int userId, int itemId, Date claimDate) {
        this.userId = userId;
        this.itemId = itemId;
        this.claimDate = claimDate;
    }

    // Getters and Setters
    public int getClaimId() {
        return claimId;
    }

    public void setClaimId(int claimId) {
        this.claimId = claimId;
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

    public Date getClaimDate() {
        return claimDate;
    }

    public void setClaimDate(Date claimDate) {
        this.claimDate = claimDate;
    }
}

