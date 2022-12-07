package com.bookstore.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "`order`", schema = "bookstore")
public class Order {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "idUser", nullable = false)
    private int idUser;
    @Basic
    @Column(name = "idSeller", nullable = true)
    private Integer idSeller;
    @Basic
    @Column(name = "createTime", nullable = true)
    private Date createTime;
    @Basic
    @Column(name = "phone", nullable = false, length = 10)
    private String phone;
    @Basic
    @Column(name = "address", nullable = false, length = 100)
    private String address;
    @Basic
    @Column(name = "contactName", nullable = false, length = 50)
    private String contactName;
    @Basic
    @Column(name = "receiveDate", nullable = true)
    private Date receiveDate;
    @Basic
    @Column(name = "idMethod", nullable = false)
    private int idMethod;
    @Basic
    @Column(name = "idDelivery", nullable = false)
    private int idDelivery;
    @Basic
    @Column(name = "totalPay", nullable = false)
    private int totalPay;
    @Basic
    @Column(name = "status", nullable = false)
    private int status;

    public Order(){}

    public Order(int idUser, String phone, String address, String contactName, int idMethod, int idDelivery, int status) {
        this.idUser = idUser;
        this.phone = phone;
        this.address = address;
        this.contactName = contactName;
        this.idMethod = idMethod;
        this.idDelivery = idDelivery;
        this.status = status;
    }

    @ManyToOne
    @JoinColumn(name = "idDelivery", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    private Delivery delivery;

    @OneToMany(mappedBy = "order")
    private List<OrderItem> orderItems;

    @OneToOne
    @JoinColumn(name = "idMethod", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    private PayMethod payMethod;

    @ManyToOne
    @JoinColumn(name="idUser", referencedColumnName = "id", nullable = false,insertable = false, updatable = false)
    private User user;

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
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

    public Integer getIdSeller() {
        return idSeller;
    }

    public void setIdSeller(Integer idSeller) {
        this.idSeller = idSeller;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public Date getReceiveDate() {
        return receiveDate;
    }

    public void setReceiveDate(Date receiveDate) {
        this.receiveDate = receiveDate;
    }

    public int getIdMethod() {
        return idMethod;
    }

    public void setIdMethod(int idMethod) {
        this.idMethod = idMethod;
    }

    public int getIdDelivery() {
        return idDelivery;
    }

    public void setIdDelivery(int idDelivery) {
        this.idDelivery = idDelivery;
    }

    public int getTotalPay() {
        return totalPay;
    }

    public void setTotalPay(int totalPay) {
        this.totalPay = totalPay;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order that = (Order) o;

        if (id != that.id) return false;
        if (idUser != that.idUser) return false;
        if (idMethod != that.idMethod) return false;
        if (idDelivery != that.idDelivery) return false;
        if (totalPay != that.totalPay) return false;
        if (status != that.status) return false;
        if (idSeller != null ? !idSeller.equals(that.idSeller) : that.idSeller != null) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        if (phone != null ? !phone.equals(that.phone) : that.phone != null) return false;
        if (address != null ? !address.equals(that.address) : that.address != null) return false;
        if (contactName != null ? !contactName.equals(that.contactName) : that.contactName != null) return false;
        if (receiveDate != null ? !receiveDate.equals(that.receiveDate) : that.receiveDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + idUser;
        result = 31 * result + (idSeller != null ? idSeller.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (contactName != null ? contactName.hashCode() : 0);
        result = 31 * result + (receiveDate != null ? receiveDate.hashCode() : 0);
        result = 31 * result + idMethod;
        result = 31 * result + idDelivery;
        result = 31 * result + totalPay;
        result = 31 * result + status;
        return result;
    }
}
