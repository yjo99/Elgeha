// default package
// Generated Feb 27, 2023, 5:09:25 PM by Hibernate Tools 6.0.0.Alpha3


import java.util.Date;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Userorderproduct generated by hbm2java
 */
@Entity
@Table(name="userorderproduct"
    ,catalog="marketplacedb"
)
public class Userorderproduct  implements java.io.Serializable {


     private UserorderproductId id;
     private Product product;
     private User user;
     private String status;
     private Integer productCount;
     private Date orderDate;

    public Userorderproduct() {
    }

	
    public Userorderproduct(UserorderproductId id, Product product, User user) {
        this.id = id;
        this.product = product;
        this.user = user;
    }
    public Userorderproduct(UserorderproductId id, Product product, User user, String status, Integer productCount, Date orderDate) {
       this.id = id;
       this.product = product;
       this.user = user;
       this.status = status;
       this.productCount = productCount;
       this.orderDate = orderDate;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="userId", column=@Column(name="userId", nullable=false) ), 
        @AttributeOverride(name="productId", column=@Column(name="productId", nullable=false) ) } )
    public UserorderproductId getId() {
        return this.id;
    }
    
    public void setId(UserorderproductId id) {
        this.id = id;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="productId", nullable=false, insertable=false, updatable=false)
    public Product getProduct() {
        return this.product;
    }
    
    public void setProduct(Product product) {
        this.product = product;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="userId", nullable=false, insertable=false, updatable=false)
    public User getUser() {
        return this.user;
    }
    
    public void setUser(User user) {
        this.user = user;
    }

    
    @Column(name="status", length=45)
    public String getStatus() {
        return this.status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }

    
    @Column(name="productCount")
    public Integer getProductCount() {
        return this.productCount;
    }
    
    public void setProductCount(Integer productCount) {
        this.productCount = productCount;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="orderDate", length=19)
    public Date getOrderDate() {
        return this.orderDate;
    }
    
    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }




}

