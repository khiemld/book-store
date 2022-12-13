package com.bookstore.entity;

import javax.persistence.*;

@Entity
@Table(name = "cartitem", schema = "bookstore")
public class CartItem {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "idUser", nullable = false)
    private int idUser;
    @Basic
    @Column(name = "idProduct", nullable = false)
    private int idProduct;
    @Basic
    @Column(name = "quantity", nullable = false)
    private int quantity;
    @Basic
    @Column(name = "price", nullable = false)
    private int price;

    @ManyToOne
    @JoinColumn(name="idProduct", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    private Product product;

    @ManyToOne
    @JoinColumn(name="idUser",  referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    private User user;



    public CartItem(){}

    public CartItem(int idUser, int idProduct, int quantity, int price) {
        this.idUser = idUser;
        this.idProduct = idProduct;
        this.quantity = quantity;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CartItem cartItem = (CartItem) o;

        if (id != cartItem.id) return false;
        if (idUser != cartItem.idUser) return false;
        if (idProduct != cartItem.idProduct) return false;
        if (quantity != cartItem.quantity) return false;
        if (price != cartItem.price) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + idUser;
        result = 31 * result + idProduct;
        result = 31 * result + quantity;
        result = 31 * result + price;
        return result;
    }


}
