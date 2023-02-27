package iti.jets.config;
import java.util.Properties;
import javax.sql.DataSource;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import iti.jets.repo.daoImplementation.ProductDaoImpl;
import iti.jets.repo.daoImplementation.UserDaoImpl;
import iti.jets.repo.daoInterfaces.ProductDao;

@PropertySource("classpath:Connection.properties")
@Configuration
public class DataBaseConfig {
    
    // dataSource var from property;
    
    @Value("${Connection.driver}")
    private String driver;
    @Value("${Connection.url}")
    private String url;
    @Value("${Connection.userName}")
    private String userName;
    @Value("${Connection.password}")
    private String pass;

//    hibernate persist configuration

    @Value("${hibernate.hbm2ddl.auto}")
    private String hbm2ddl;
    @Value("${hibernate.show_sql}")
    private String showSql;
    @Value("${hibernate.format_sql}")
    private String fromatSql;

    @Bean
    public DriverManagerDataSource getDataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(driver);
        dataSource.setUrl(url);
        dataSource.setUsername(userName);
        dataSource.setPassword(pass);
        return dataSource;
    }

  
    @Bean
    public LocalContainerEntityManagerFactoryBean getEntityManagerFactory(){
        Properties jpaProperties = new Properties();
        jpaProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        jpaProperties.setProperty("hibernate.connection.autocommit", "true");
        // jpaProperties.setProperty("hibernate.hbm2ddl.auto", "true");
        LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();
        // PersistenceProvider persistenceProvider = new HibernatePersistenceProvider();
        // DataSource dataSource ; 
        entityManagerFactory.setDataSource(getDataSource());
        entityManagerFactory.setPackagesToScan("iti.jets.repo.entities");
        entityManagerFactory.setPersistenceProvider(new HibernatePersistenceProvider());
        entityManagerFactory.setJpaProperties(jpaProperties);
        return entityManagerFactory ;
    }

    @Bean
    public JpaTransactionManager transactionManager(){
        JpaTransactionManager jpatransactionManager = new JpaTransactionManager();
        LocalContainerEntityManagerFactoryBean entityManagerFactory ; 
        return jpatransactionManager ;
    }

    @Bean
    public ProductDao getProductDao(){
        ProductDaoImpl productDao = new ProductDaoImpl();
        return productDao ; 
    }
    
    @Bean
    public UserDaoImpl getUserDao(){
        UserDaoImpl userDao = new UserDaoImpl();
        return userDao ; 
    }

}
