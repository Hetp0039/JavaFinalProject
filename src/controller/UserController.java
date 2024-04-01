package controller;
import java.util.List;

import dataaccesslayer.UserDao;
import model.User;

public class UserController {
    private final UserDao userDao;

    public UserController(UserDao userDao) {
        this.userDao = userDao;
    }

    public void registerUser(User user) {
        userDao.save(user);
    }

    public User getUserByEmail(String email) {
        return userDao.getUserByEmail(email);
    }

    public void updateUser(User user) {
        userDao.update(user);
    }

    public void deleteUser(int userId) {
        userDao.delete(userId);
    }

    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }
}
