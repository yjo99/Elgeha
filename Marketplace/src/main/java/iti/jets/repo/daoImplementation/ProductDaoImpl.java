package iti.jets.repo.daoImplementation;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;
import iti.jets.repo.daoInterfaces.ProductDao;
import iti.jets.repo.entities.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

public class ProductDaoImpl implements ProductDao {
    @PersistenceContext
    private EntityManager entityManager ;

    @Override
    @Transactional
    public void save(Product product) {
        entityManager.persist(product);
    }

    @Transactional
    @Override
    public void deleteById(int id) {
        Product product = entityManager.find( Product.class, id);
        entityManager.remove(product);
    }

    @Transactional
    @Override
    public void update(Product product) {
        entityManager.merge(product);
    }

    @Override
    public Product selectProduct(int id) {
        Product product = entityManager.find(Product.class, id);
        return product;
    }

    @Override
    public List<Product> selectProducts() {
       TypedQuery<Product> query = entityManager.createQuery("SELECT p FROM Product p", Product.class);
       List<Product> products = query.getResultList();
       return products;
        
    };
}
