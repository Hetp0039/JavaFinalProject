package dataaccesslayer;
import java.util.List;

import model.Alert;

public interface AlertDao {
    void save(Alert alert);
    void delete(int alertId);
    List<Alert> getAllAlerts();
}
