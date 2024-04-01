package dataaccesslayer;
import java.util.List;

import model.Consumer;

public interface ConsumerDao {
    void save(Consumer consumer);
    void update(Consumer consumer);
    void delete(int consumerId);
    Consumer getConsumerByEmail(String email);
    List<Consumer> getAllConsumers();
}
