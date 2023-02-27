package iti.jets;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.jpa.JpaTransactionManager;


import iti.jets.repo.daoImplementation.UserDaoImpl;
import iti.jets.repo.daoInterfaces.ProductDao;
import iti.jets.repo.daoInterfaces.UserDao;
import iti.jets.repo.entities.Product;
import iti.jets.repo.entities.User;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

public class App {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        UserDao uDao = (UserDao) context.getBean("userdao");

        // JpaTransactionManager ds = (JpaTransactionManager)
        // context.getBean("getTransactionManager");
        // System.out.println(ds.getEntityManagerFactory());
        User u = new User();
        u.setAddress(null);
        u.setUserId(3);
        u.setCreditCard("123345");
        u.setEmail("qweqwe123");
        u.setPhone("123123");
        u.setLastName("ha");
        u.setGender("m");
        u.setPassword("123123123");
        u.setFirstName("hamza");


        uDao.save(u);
    }
}
