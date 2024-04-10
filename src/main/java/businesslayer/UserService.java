package businesslayer;
import model.User;

public interface UserService {
    User getUserByEmail(String email);
    void registerUser(User user);
}
