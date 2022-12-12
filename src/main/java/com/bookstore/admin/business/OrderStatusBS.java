package com.bookstore.admin.business;

public class OrderStatusBS {
    private int id;
    private String name;

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

    public OrderStatusBS() {
    }

    public OrderStatusBS(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
