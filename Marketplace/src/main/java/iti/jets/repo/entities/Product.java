package iti.jets.repo.entities;
// default package
// Generated Feb 27, 2023, 5:09:25 PM by Hibernate Tools 6.0.0.Alpha3


import java.util.HashSet;
import java.util.Set;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

/**
 * Product generated by hbm2java
 */
@Entity
@Table(name="product"
    ,catalog="marketplacedb"
)
public class Product  implements java.io.Serializable {


     private int productId;
     private Category category;
     private String productName;
     private String productDescription;
     private int productAmount;
     private float price;
     private Set<Image> images = new HashSet<Image>(0);
     private Set<Userreviewproduct> userreviewproducts = new HashSet<Userreviewproduct>(0);
     private Set<Userorderproduct> userorderproducts = new HashSet<Userorderproduct>(0);

    public Product() {
    }

	
    public Product(int productId, Category category, String productName, int productAmount, float price) {
        this.productId = productId;
        this.category = category;
        this.productName = productName;
        this.productAmount = productAmount;
        this.price = price;
    }
    public Product(int productId, Category category, String productName, String productDescription, int productAmount, float price, Set<Image> images, Set<Userreviewproduct> userreviewproducts, Set<Userorderproduct> userorderproducts) {
       this.productId = productId;
       this.category = category;
       this.productName = productName;
       this.productDescription = productDescription;
       this.productAmount = productAmount;
       this.price = price;
       this.images = images;
       this.userreviewproducts = userreviewproducts;
       this.userorderproducts = userorderproducts;
    }
   
     @Id 

    
    @Column(name="productId", unique=true, nullable=false)
    public int getProductId() {
        return this.productId;
    }
    
    public void setProductId(int productId) {
        this.productId = productId;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="categoryId", nullable=true)
    public Category getCategory() {
        return this.category;
    }
    
    public void setCategory(Category category) {
        this.category = category;
    }

    
    @Column(name="productName", nullable=false, length=255)
    public String getProductName() {
        return this.productName;
    }
    
    public void setProductName(String productName) {
        this.productName = productName;
    }

    
    @Column(name="productDescription", length=510)
    public String getProductDescription() {
        return this.productDescription;
    }
    
    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    
    @Column(name="productAmount", nullable=false)
    public int getProductAmount() {
        return this.productAmount;
    }
    
    public void setProductAmount(int productAmount) {
        this.productAmount = productAmount;
    }

    
    @Column(name="price", nullable=false, precision=12, scale=0)
    public float getPrice() {
        return this.price;
    }
    
    public void setPrice(float price) {
        this.price = price;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="product")
    public Set<Image> getImages() {
        return this.images;
    }
    
    public void setImages(Set<Image> images) {
        this.images = images;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="product")
    public Set<Userreviewproduct> getUserreviewproducts() {
        return this.userreviewproducts;
    }
    
    public void setUserreviewproducts(Set<Userreviewproduct> userreviewproducts) {
        this.userreviewproducts = userreviewproducts;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="product")
    public Set<Userorderproduct> getUserorderproducts() {
        return this.userorderproducts;
    }
    
    public void setUserorderproducts(Set<Userorderproduct> userorderproducts) {
        this.userorderproducts = userorderproducts;
    }




}


