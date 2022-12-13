package com.bookstore.entity;

import javax.persistence.*;

import java.util.List;

@Entity
@Table(name = "user", schema = "bookstore")
public class User {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "name", nullable = false, length = 30)
    private String name;
    @Basic
    @Column(name = "image", nullable = true, length = 2000)
    private String image;
    @Basic
    @Column(name = "address", nullable = false, length = 100)
    private String address;
    @Basic
    @Column(name = "email", nullable = false, length = 50)
    private String email;
    @Basic
    @Column(name = "phone", nullable = false, length = 10)
    private String phone;
    @Basic
    @Column(name = "password", nullable = false, length = 20)
    private String password;
    @Basic
    @Column(name = "isRole", nullable = false)
    private int isRole;
    @Basic
    @Column(name = "active", nullable = false)
    private boolean active;
    @OneToMany(mappedBy = "user")
    private List<CartItem> cartItems;

    @OneToMany(mappedBy = "user")
    private List<Order> orders;

    public User(){ }

    public User(String name, String address, String email, String phone, String password, int isRole) {
        this.name = name;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.isRole = isRole;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getIsRole() {
        return isRole;
    }

    public void setIsRole(int isRole) {
        this.isRole = isRole;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != user.id) return false;
        if (isRole != user.isRole) return false;
        if (active != user.active) return false;
        if (name != null ? !name.equals(user.name) : user.name != null) return false;
        if (image != null ? !image.equals(user.image) : user.image != null) return false;
        if (address != null ? !address.equals(user.address) : user.address != null) return false;
        if (email != null ? !email.equals(user.email) : user.email != null) return false;
        if (phone != null ? !phone.equals(user.phone) : user.phone != null) return false;
        if (password != null ? !password.equals(user.password) : user.password != null) return false;

        return true;
    }

  /*  @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (image != null ? image.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + isRole;
        result = 31 * result + (active ? 1 : 0);
        return result;
    }*/

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
