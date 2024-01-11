package web.service;

import web.model.User;
import java.util.List;

public interface UserService {
    void addUser(User users);

    List<User> getAllUsers();

    void editUser(Long id, User updateUser);

    void deleteUser(Long id);

    User getUserById(Long id);

}