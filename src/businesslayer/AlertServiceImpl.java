package businesslayer;

import java.util.List;

import dataaccesslayer.AlertDao;
import model.Alert;

public class AlertServiceImpl implements AlertService {
    private AlertDao alertDao;

    public AlertServiceImpl(AlertDao alertDao) {
        this.alertDao = alertDao;
    }

    @Override
    public List<Alert> getAlertsByUserId(int userId) {
        return alertDao.getAlertsByUserId(userId);
    }
    // Implement other AlertService methods
}

