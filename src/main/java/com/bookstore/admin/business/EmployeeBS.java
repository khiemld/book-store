package com.bookstore.admin.business;

import com.bookstore.dao.OrderDAO;
import com.bookstore.dao.OrderItemDAO;
import com.bookstore.dao.UserDAO;
import com.bookstore.entity.Order;
import com.bookstore.entity.OrderItem;
import com.bookstore.entity.User;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EmployeeBS {
    public static List<User> getAll() {
        List<User> employees = UserDAO.findByRole(2); // 2 - employee
        return employees;
    }

    public static String CheckInputData(User user) {
        if (user.getPhone().length() < 10) {
            return "Vui lòng <b>nhập số điện thoại có 10 số</b>!";
        }
        if (!isPhoneNumber(user.getPhone())) {
            return "Vui lòng <b>nhập định dạng đúng của số điện thoại</b>!";
        }
        return "OK";
    }

    private static boolean isPhoneNumber(String phone) {
        for (int i = 0; i < phone.length(); i++) {
            if (Character.isLetter(phone.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static String CheckPhoneAvailable(User user) {
        List<User> foundedList = UserDAO.findByPhone(user.getPhone());
        if (foundedList.size() == 1) {
            return "<b>SĐT đã tồn tại</b>! Vui lòng nhập SĐT khác";
        }
        return "OK";
    }

    public static String CheckEmailAvailable(User user) {
        List<User> foundedList = UserDAO.findListUserByEmail(user.getEmail());
        if (foundedList.size() == 1) {
            return "<b>Email đã tồn tại</b>! Vui lòng nhập email khác";
        }
        return "OK";
    }

    public static User BestEmployeeByPrice() {
        class Temp implements Comparable<Temp> {
            public int id;
            public int quantity;

            Temp() {
            }

            ;

            public Temp(int idValue, int quantityValue) {
                id = idValue;
                quantity = quantityValue;
            }


            @Override
            public int compareTo(Temp o) {
                if (quantity == o.quantity)
                    return 0;
                else if (quantity > o.quantity)
                    return 1;
                else
                    return -1;
            }
        }
        List<User> employees = getAll();
        List<Temp> topEmployee = new ArrayList<>();
        for (User emp : employees) {
            List<Order> orderOFThisEmployee = OrderDAO.getOrderByIdEmployee(emp.getId());
            if (orderOFThisEmployee.size() >= 1) {
                Temp tempCustomer = new Temp(emp.getId(), 0);
                for (Order order : orderOFThisEmployee) {
                    tempCustomer.quantity += order.getTotalPay();
                }
                topEmployee.add(tempCustomer);
            }
        }
        if (topEmployee.size() > 0) {
            Collections.sort(topEmployee);
            return UserDAO.find(topEmployee.get(topEmployee.size() - 1).id);
        }
        return null;
    }

    public static User BestEmployeeByBooks() {
        class Temp implements Comparable<Temp> {
            public int id;
            public int quantity;

            Temp() {
            }

            ;

            public Temp(int idValue, int quantityValue) {
                id = idValue;
                quantity = quantityValue;
            }


            @Override
            public int compareTo(Temp o) {
                if (quantity == o.quantity)
                    return 0;
                else if (quantity > o.quantity)
                    return 1;
                else
                    return -1;
            }
        }
        List<User> employees = getAll();
        List<Temp> topEmployee = new ArrayList<>();
        for (User emp : employees) {
            List<Order> orderOFThisEmployee = OrderDAO.getOrderByIdEmployee(emp.getId());
            if (orderOFThisEmployee.size() >= 1) {
                Temp tempEmployee = new Temp(emp.getId(), 0);
                for (Order order : orderOFThisEmployee) {
                    List<OrderItem> orderitemEntityList = OrderItemDAO.orderItemList(order.getId());
                    for (OrderItem item : orderitemEntityList) {
                        tempEmployee.quantity += item.getQuantity();
                    }
                }
                topEmployee.add(tempEmployee);
            }
        }
        if (topEmployee.size() > 0) {
            Collections.sort(topEmployee);
            return UserDAO.find(topEmployee.get(topEmployee.size() - 1).id);
        }
        return null;
    }

    public static int totalOrder(User user) {
        List<Order> orderOFThisEmployee = OrderDAO.getOrderByIdEmployee(user.getId());
        if (orderOFThisEmployee.size() > 0) {
            return orderOFThisEmployee.size();
        }
        return 0;
    }
}
