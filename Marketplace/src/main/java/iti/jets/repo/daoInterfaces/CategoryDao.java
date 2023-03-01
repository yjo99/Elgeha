package iti.jets.repo.daoInterfaces;

import java.util.List;

import iti.jets.entities.Category;

public interface CategoryDao {
	public void save(Category category);
    public void deleteById(int id);
    public void update(Category category);
    public Category selectCategory(int id);
    public List<Category> selectCategories();
}
