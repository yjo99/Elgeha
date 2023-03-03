package iti.jets.mappers;

public class ProductCategory {
  
    ProductMapper pMapper ;
    public ProductCategory() {
         
        pMapper = new ProductMapper();
    }
    public iti.jets.DTO.ProductCategoryDTO getProdcutCat(int pId)
    {
        return new iti.jets.DTO.ProductCategoryDTO(pMapper.getProduct(pId).getProductName(),pMapper.getProduct(pId).getCatName());
    }
    
}
