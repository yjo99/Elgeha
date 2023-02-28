package iti.jets;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.jpa.JpaTransactionManager;

import iti.jets.repo.daoImplementation.UserDaoImpl;
import iti.jets.repo.daoInterfaces.AddressDao;
import iti.jets.repo.daoInterfaces.CategoryDao;
import iti.jets.repo.daoInterfaces.ImageDao;
import iti.jets.repo.daoInterfaces.ProductDao;
import iti.jets.repo.daoInterfaces.UserDao;
import iti.jets.repo.entities.Address;
import iti.jets.repo.entities.Category;
import iti.jets.repo.entities.Image;
import iti.jets.repo.entities.Product;
import iti.jets.repo.entities.User;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

public class App {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        UserDao userDao = (UserDao) context.getBean("userDao");
        ProductDao productDao = (ProductDao) context.getBean("productDao");
        CategoryDao categoryDao = (CategoryDao) context.getBean("categoryDao");
        AddressDao addressDao = (AddressDao) context.getBean("addressDao");
        ImageDao imageDao = (ImageDao) context.getBean("imageDao");


        // JpaTransactionManager ds = (JpaTransactionManager)
        // context.getBean("getTransactionManager");
        // System.out.println(ds.getEntityManagerFactory());
        User user = new User();
        Product product = new Product();
        Category category = new Category();
        Address address = new Address();
        Image image = new Image();
        // uDao.save(new User(5, "youssef", "zekry","y@gm.com", "123"));
        // uDao.deleteById(2);
        // uDao.update(new User(5, "updated youssef", "zekry","y@gm.com", "123"));
        //    System.out.println(uDao.selectUser(3)); 
        //    System.out.println(uDao.selectUsers()); 
        // productDao.save(new Product(1, null, "mobile" , 5 , 16300));
        //    System.out.println(productDao.selectProduct(1)); 
        // productDao.update(new Product(1, null, "mobile" , 20 , 16300));
        // System.out.println(productDao.selectProducts()); 
        // productDao.deleteById(1);
        // categoryDao.save(new Category(1,"electronics"));
        // addressDao.save(new Address(1, "cairo", "dsgs", "xbcvbc"));
        imageDao.save(new Image(1, null));

    }
}
