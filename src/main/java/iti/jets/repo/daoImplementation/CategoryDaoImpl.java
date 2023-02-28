package iti.jets.repo.daoImplementation;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import iti.jets.repo.daoInterfaces.CategoryDao;
import iti.jets.repo.entities.Category;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

public class CategoryDaoImpl implements CategoryDao {

	@PersistenceContext
    private EntityManager entityManager ;

    @Override
    @Transactional
    public void save(Category category) {
        entityManager.persist(category);
    }

    @Transactional
    @Override
    public void deleteById(int id) {
        Category category = entityManager.find( Category.class, id);
        entityManager.remove(category);
    }

    @Transactional
    @Override
    public void update(Category category) {
        entityManager.merge(category);
    }

    @Override
    public Category selectCategory(int id) {
        Category category = entityManager.find(Category.class, id);
        return category;
    }

    @Override
    public List<Category> selectCategories() {
       TypedQuery<Category> query = entityManager.createQuery("SELECT c FROM Category c", Category.class);
       List<Category> categories = query.getResultList();
       return categories;
        
    };
}