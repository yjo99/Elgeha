package iti.jets.mappers;

public class ProductCategory {
  
    ProductMapper pMapper ;
    public ProductCategory() {
         
        pMapper = new ProductMapper();
    }
    public iti.jets.DTO.ProductCategory getProdcutCat(int pId)
    {
        return new iti.jets.DTO.ProductCategory(pMapper.getProduct(pId).getProductName(),pMapper.getProduct(pId).getCatName());
    }
    
}
