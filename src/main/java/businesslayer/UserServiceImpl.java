package businesslayer;

import dataaccesslayer.UserDao;
import model.User;

public class UserServiceImpl implements UserService {
    private UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public User getUserByEmail(String email) {
        return userDao.getUserByEmail(email);
    }

    @Override
    public void registerUser(User user) {
        userDao.save(user);
    }
   
}

