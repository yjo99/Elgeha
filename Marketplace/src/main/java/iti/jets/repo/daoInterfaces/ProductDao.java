package iti.jets.repo.daoInterfaces;

import java.util.List;

import iti.jets.entities.Product;

public interface ProductDao {
    public void save(Product product);
    public void deleteById(int id);
    public void update(Product product);
    public Product selectProduct(int id);
    public List<Product> selectProducts();
}
