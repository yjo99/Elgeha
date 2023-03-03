package iti.jets.mappers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import iti.jets.dto.CategoryDTO;
import iti.jets.repo.daoImplementation.CategoryDaoImpl;
import iti.jets.repo.daoInterfaces.CategoryDao;

public class CategoryMapper {
    CategoryDao catDao;
    ApplicationContext applicationContext;

    public CategoryMapper() {
        catDao = new CategoryDaoImpl();
        applicationContext = new ClassPathXmlApplicationContext("beans.xml");
    }

    public iti.jets.dto.CategoryDTO getCategory(int id) {
        iti.jets.dto.CategoryDTO catdto = new CategoryDTO();
        CategoryDao cDao = applicationContext.getBean("categoryDao",CategoryDao.class);
        catdto.setCategoryId(cDao.selectCategory(id).getCategoryId());
        catdto.setCategoryName(
                applicationContext.getBean("categoryDao", CategoryDao.class).selectCategory(id).getCategoryName());
        return catdto;
    }

    public List<iti.jets.dto.CategoryDTO> getCategorys() {
        List<iti.jets.dto.CategoryDTO> catlist = new ArrayList<>();
        CategoryDao cDao = applicationContext.getBean("categoryDao",CategoryDao.class);
        int count = 0;
//                                           List of Entitys from JPA
        for (iti.jets.entities.Category c : cDao.selectCategories()) {
            catlist.add(new iti.jets.dto.CategoryDTO());
            catlist.get(count).setCategoryId(c.getCategoryId());
            catlist.get(count).setCategoryName(c.getCategoryName());
            count++;
        }
        return catlist;
    }
}
