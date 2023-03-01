package iti.jets.dto;

public class ProductCategory {
    private String productName;
    private String categoryName;

    public ProductCategory(String productName, String categoryName) {
        this.productName = productName;
        this.categoryName = categoryName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

}
