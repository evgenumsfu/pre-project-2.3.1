package web.dao;

import web.model.User;
import java.util.List;

public interface UserDao {
    List<User> getAllUsers();

    void addUser(User users);

    void editUser(Long id, User updateUser);

    void deleteUser(Long id);

    User getUserById(Long id);
}