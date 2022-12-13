package com.bookstore.entity;

import javax.persistence.*;

@Entity
@Table(name = "orderitem", schema = "bookstore")
public class OrderItem {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "idOrder", nullable = false)
    private int idOrder;
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
    @JoinColumn(name = "idOrder", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    private Order order;

    @ManyToOne
    @JoinColumn(name = "idProduct", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    private Product product;

    public OrderItem(){

    }

    public OrderItem(int idOrder, int idProduct, int quantity, int price) {
        this.idOrder = idOrder;
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

    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderItem orderItem = (OrderItem) o;

        if (id != orderItem.id) return false;
        if (idOrder != orderItem.idOrder) return false;
        if (idProduct != orderItem.idProduct) return false;
        if (quantity != orderItem.quantity) return false;
        if (price != orderItem.price) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + idOrder;
        result = 31 * result + idProduct;
        result = 31 * result + quantity;
        result = 31 * result + price;
        return result;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProductByIdProduct() {
        return product;
    }

    public void setProductByIdProduct(Product productByIdProduct) {
        this.product = productByIdProduct;
    }
}
