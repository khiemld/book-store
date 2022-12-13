package com.bookstore.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "product", schema = "bookstore")
public class Product {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "idCategory", nullable = true)
    private Integer idCategory;
    @Basic
    @Column(name = "name", nullable = false, length = 200)
    private String name;
    @Basic
    @Column(name = "image", nullable = true, length = 2000)
    private String image;
    @Basic
    @Column(name = "originalPrice", nullable = false)
    private int originalPrice;
    @Basic
    @Column(name = "salePrice", nullable = false)
    private int salePrice;
    @Basic
    @Column(name = "discription", nullable = true, length = 2000)
    private String discription;
    @Basic
    @Column(name = "quantity", nullable = false)
    private int quantity;
    @Basic
    @Column(name = "active", nullable = false)
    private boolean active = true;
    @OneToMany(mappedBy = "product")
    private List<CartItem> cartItems;

    @OneToMany(mappedBy = "product")
    private List<OrderItem> orderitems;

    @OneToOne
    @JoinColumn(name = "idCategory", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    private Category category;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(Integer idCategory) {
        this.idCategory = idCategory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(int originalPrice) {
        this.originalPrice = originalPrice;
    }

    public int getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(int salePrice) {
        this.salePrice = salePrice;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Product() {
    }

    ;

    public Product(int id, Integer idCategory, String name, String image, int originalPrice, int salePrice, String discription, int quantity, boolean active, List<CartItem> cartItems, List<OrderItem> orderitems, Category category) {
        this.id = id;
        this.idCategory = idCategory;
        this.name = name;
        this.image = image;
        this.originalPrice = originalPrice;
        this.salePrice = salePrice;
        this.discription = discription;
        this.quantity = quantity;
        this.active = active;
        this.cartItems = cartItems;
        this.orderitems = orderitems;
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (id != product.id) return false;
        if (originalPrice != product.originalPrice) return false;
        if (salePrice != product.salePrice) return false;
        if (quantity != product.quantity) return false;
        if (active != product.active) return false;
        if (idCategory != null ? !idCategory.equals(product.idCategory) : product.idCategory != null) return false;
        if (name != null ? !name.equals(product.name) : product.name != null) return false;
        if (image != null ? !image.equals(product.image) : product.image != null) return false;
        if (discription != null ? !discription.equals(product.discription) : product.discription != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (idCategory != null ? idCategory.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (image != null ? image.hashCode() : 0);
        result = 31 * result + originalPrice;
        result = 31 * result + salePrice;
        result = 31 * result + (discription != null ? discription.hashCode() : 0);
        result = 31 * result + quantity;
        result = 31 * result + (active ? 1 : 0);
        return result;
    }

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    public List<OrderItem> getOrderitems() {
        return orderitems;
    }

    public void setOrderitems(List<OrderItem> orderitems) {
        this.orderitems = orderitems;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category categoryById) {
        this.category = categoryById;
    }
}
