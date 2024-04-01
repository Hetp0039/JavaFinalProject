package businesslayer;

import java.util.List;

import model.Alert;

public interface AlertService {
    List<Alert> getAlertsByUserId(int userId);
    // Other methods related to alerts
}

