package iti.jets.repo.daoImplementation;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import iti.jets.repo.daoInterfaces.ImageDao;
import iti.jets.repo.entities.Image;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

public class ImageDaoImpl implements ImageDao{

	@PersistenceContext
    private EntityManager entityManager ;

    @Override
    @Transactional
    public void save(Image image) {
        entityManager.persist(image);
    }

    @Transactional
    @Override
    public void deleteById(int id) {
        Image image = entityManager.find( Image.class, id);
        entityManager.remove(image);
    }

    @Transactional
    @Override
    public void update(Image image) {
        entityManager.merge(image);
    }

    @Override
    public Image selectImage(int id) {
        Image image = entityManager.find(Image.class, id);
        return image;
    }

    @Override
    public List<Image> selectImages() {
       TypedQuery<Image> query = entityManager.createQuery("SELECT c FROM Image c", Image.class);
       List<Image> images = query.getResultList();
       return images;
        
    };
}