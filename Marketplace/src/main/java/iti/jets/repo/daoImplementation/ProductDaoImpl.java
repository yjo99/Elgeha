package iti.jets.repo.daoImplementation;
import org.springframework.transaction.annotation.Transactional;
import iti.jets.repo.daoInterfaces.ProductDao;
import iti.jets.repo.entities.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

public class ProductDaoImpl implements ProductDao {
    @PersistenceContext
    private EntityManager entityManager ;

    @Override
    @Transactional
    public void save(Product product) {
        entityManager.persist(product);
    }
    
}
