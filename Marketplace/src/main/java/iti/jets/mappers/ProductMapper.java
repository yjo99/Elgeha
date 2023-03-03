package iti.jets.mappers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import iti.jets.DTO.ProductDTO;
import iti.jets.entities.Product;
import iti.jets.repo.daoImplementation.ProductDaoImpl;
import iti.jets.repo.daoInterfaces.ProductDao;

public class ProductMapper {
    ProductDao pdao;
    ApplicationContext context;

    public ProductMapper() {
        pdao = new ProductDaoImpl();
        context = new ClassPathXmlApplicationContext("beans.xml");
    }

    public ProductDTO getProduct(int id) {

        iti.jets.entities.Product pEntity = context.getBean("productDao", ProductDao.class).selectProduct(id);
        iti.jets.DTO.ProductDTO pDTO = new ProductDTO();
        pDTO.setCatName(pEntity.getCategory().getCategoryName());
        pDTO.setPrice(pEntity.getPrice());
        pDTO.setProductAmount(pEntity.getProductAmount());
        pDTO.setProductDescription(pEntity.getProductDescription());
        pDTO.setProductName(pEntity.getProductName());
        pDTO.setProductId(pEntity.getProductId());
        return pDTO;
    }

    public List<ProductDTO> getProducts() {
        int count = 0;
        List<ProductDTO> pDTO = new ArrayList<>();
        for (Product p : context.getBean("productDao", ProductDao.class).selectProducts()) {
            pDTO.add(new iti.jets.DTO.ProductDTO());
            pDTO.get(count).setCatName(p.getCategory().getCategoryName());
            pDTO.get(count).setPrice(p.getPrice());
            pDTO.get(count).setProductAmount(p.getProductAmount());
            pDTO.get(count).setProductDescription(p.getProductDescription());
            pDTO.get(count).setProductName(p.getProductName());
            pDTO.get(count).setProductId(p.getProductId());
            count++;
        }
        return pDTO;
    }

    public void delete(int id) {
        context.getBean("productDao", ProductDao.class).deleteById(id);
        ;
    }

    public void insert(iti.jets.DTO.ProductDTO p) {
        iti.jets.entities.Product eProduct = new iti.jets.entities.Product();
        eProduct.setPrice(p.getPrice());
        eProduct.setProductName(p.getProductName());
        eProduct.setProductId(p.getProductId());
        eProduct.setImages(null);
        eProduct.setProductDescription(p.getProductDescription());
        eProduct.setProductAmount(p.getProductAmount());
        context.getBean("productDao", ProductDao.class).save(eProduct);
    }

}
