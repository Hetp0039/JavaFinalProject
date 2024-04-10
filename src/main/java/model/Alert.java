package model;

public class Alert {
    private int alertId;
    private int userId;
    private String location;
    private String communicationMethod;
    private String foodPreferences;

    // Constructors
    public Alert() {
    }

    public Alert(int userId, String location, String communicationMethod, String foodPreferences) {
        this.userId = userId;
        this.location = location;
        this.communicationMethod = communicationMethod;
        this.foodPreferences = foodPreferences;
    }

    // Getters and Setters
    public int getAlertId() {
        return alertId;
    }

    public void setAlertId(int alertId) {
        this.alertId = alertId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCommunicationMethod() {
        return communicationMethod;
    }

    public void setCommunicationMethod(String communicationMethod) {
        this.communicationMethod = communicationMethod;
    }

    public String getFoodPreferences() {
        return foodPreferences;
    }

    public void setFoodPreferences(String foodPreferences) {
        this.foodPreferences = foodPreferences;
    }
}
