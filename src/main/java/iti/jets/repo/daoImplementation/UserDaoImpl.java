package iti.jets.repo.daoImplementation;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.mysql.cj.Query;

import iti.jets.repo.daoInterfaces.UserDao;
import iti.jets.repo.entities.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.PersistenceContextType;
import jakarta.persistence.TypedQuery;

// @Transactional
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    @Transactional
    public void save(User user) {
        entityManager.persist(user);
    }

    @Transactional
    @Override
    public void deleteById(int id) {
        User user = entityManager.find( User.class, id);
        entityManager.remove(user);
    }

    @Transactional
    @Override
    public void update(User user) {
        entityManager.merge(user);
    }

    @Override
    public User selectUser(int id) {
        User user = entityManager.find(User.class, id);
        return user;
    }

    @Override
    public List<User> selectUsers() {
       TypedQuery<User> query = entityManager.createQuery("SELECT u FROM User u", User.class);
       List<User> users = query.getResultList();
       return users;
        
    };
}
