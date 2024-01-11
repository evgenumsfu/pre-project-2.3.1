package web.dao;

import org.springframework.stereotype.Service;
import web.model.User;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("SELECT u FROM User u", User.class).getResultList();
    }

    @Override
    public void addUser(User user) {
        entityManager.merge(user);
    }

    @Override
    public void editUser(Long id, User updateUser) {
        User user = entityManager.find(User.class, id);
        if (user != null) {
            user.setName(updateUser.getName());
            user.setCity(updateUser.getCity());
            user.setAge(updateUser.getAge());
            entityManager.merge(user);
        }
    }

    @Override
    public void deleteUser(Long id) {
        entityManager.remove(entityManager.find(User.class, id));
    }

    @Override
    public User getUserById(Long id) {
        return entityManager.find(User.class, id);
    }
}