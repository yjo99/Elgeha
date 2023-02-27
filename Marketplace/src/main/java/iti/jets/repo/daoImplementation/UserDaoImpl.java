package iti.jets.repo.daoImplementation;
import org.springframework.transaction.annotation.Transactional;
import iti.jets.repo.daoInterfaces.UserDao;
import iti.jets.repo.entities.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.PersistenceContextType;

public class UserDaoImpl implements UserDao {
    
    @PersistenceContext
    EntityManager entityManager ; 

    @Override
    @Transactional
    public void save(User user) {
        System.out.println(entityManager);
    };
}
