package iti.jets;
import javax.sql.DataSource;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.orm.jpa.JpaTransactionManager;

import iti.jets.config.DataBaseConfig;
import iti.jets.repo.daoInterfaces.ProductDao;
import iti.jets.repo.daoInterfaces.UserDao;
import iti.jets.repo.entities.Product;
import iti.jets.repo.entities.User;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(DataBaseConfig.class);
        context.refresh();
        // JpaTransactionManager ds = (JpaTransactionManager) context.getBean("getTransactionManager");
        // System.out.println(ds.getEntityManagerFactory());
        UserDao userDao = context.getBean("getUserDao" , UserDao.class);
        userDao.save(new User( "h", "m", "h", "h"));
    }
}
