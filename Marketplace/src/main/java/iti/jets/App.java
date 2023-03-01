package iti.jets;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.jpa.JpaTransactionManager;

import iti.jets.entities.Address;
import iti.jets.entities.Category;
import iti.jets.entities.Image;
import iti.jets.entities.Product;
import iti.jets.entities.User;
import iti.jets.mappers.ProductMapper;
import iti.jets.repo.daoImplementation.UserDaoImpl;
import iti.jets.repo.daoInterfaces.AddressDao;
import iti.jets.repo.daoInterfaces.CategoryDao;
import iti.jets.repo.daoInterfaces.ImageDao;
import iti.jets.repo.daoInterfaces.ProductDao;
import iti.jets.repo.daoInterfaces.UserDao;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

public class App {
        public static void main(String[] args) {
                ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
                context.getBean("categoryDao",CategoryDao.class).selectCategories();

        }
}
