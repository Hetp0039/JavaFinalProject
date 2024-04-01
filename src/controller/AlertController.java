package controller;

import java.util.List;

import dataaccesslayer.AlertDao;
import model.Alert;

public class AlertController {
    private final AlertDao alertDao;

    public AlertController(AlertDao alertDao) {
        this.alertDao = alertDao;
    }

    public void addAlert(Alert alert) {
        alertDao.save(alert);
    }

    public void deleteAlert(int alertId) {
        alertDao.delete(alertId);
    }

    public List<Alert> getAllAlerts() {
        return alertDao.getAllAlerts();
    }
}
