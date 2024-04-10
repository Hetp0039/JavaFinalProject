package dataaccesslayer;
import java.util.List;

import model.User;

public interface UserDao {
    void save(User user);
    void update(User user);
    void delete(int userId);
    User getUserByEmail(String email);
    List<User> getAllUsers();
}
