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

public class CustomerBS {
    public static List<User> getAll() {
        List<User> customers = UserDAO.findByRole(3); // 3 - customer
        return customers;
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
        if (foundedList.size() >= 1) {
            return "<b>SĐT đã tồn tại</b>! Vui lòng nhập SĐT khác";
        }
        return "OK";
    }

    public static String CheckEmailAvailable(User user) {
        List<User> foundedList = UserDAO.findListUserByEmail(user.getEmail());
       /* List<User> foundedList =UserDAO.findByEmail(user.getEmail());*/
        if (foundedList.size() >= 1) {
            return "<b>Email đã tồn tại</b>! Vui lòng nhập email khác";
        }
        return "OK";
    }

    public static User BestCustomerByPrice() {
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
        List<User> customers = getAll();
        List<Temp> topCustomer = new ArrayList<>();
        for (User cus : customers) {
            List<Order> orderOFThisCustomer = OrderDAO.getOrderByIdCustomer(cus.getId());
            if (orderOFThisCustomer.size() >= 1) {
                Temp tempCustomer = new Temp(cus.getId(), 0);
                for (Order order : orderOFThisCustomer) {
                    tempCustomer.quantity += order.getTotalPay();
                }
                topCustomer.add(tempCustomer);
            }
        }
        if (topCustomer.size() > 0) {
            Collections.sort(topCustomer);
            return UserDAO.find(topCustomer.get(topCustomer.size()-1).id);
        }
        return null;
    }

    public static User BestCustomerByBooks() {
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
        List<User> customers = getAll();
        List<Temp> topCustomer = new ArrayList<>();
        for (User cus : customers) {
            List<Order> orderOFThisCustomer = OrderDAO.getOrderByIdCustomer(cus.getId());
            if (orderOFThisCustomer.size() >= 1) {
                Temp tempCustomer = new Temp(cus.getId(), 0);
                for (Order order : orderOFThisCustomer) {
                    List<OrderItem> orderitemEntityList = OrderItemDAO.orderItemList(order.getId());
                    for (OrderItem item : orderitemEntityList) {
                        tempCustomer.quantity+=item.getQuantity();
                    }
                }
                topCustomer.add(tempCustomer);
            }
        }
        if (topCustomer.size() > 0) {
            Collections.sort(topCustomer);
            return UserDAO.find(topCustomer.get(topCustomer.size()-1).id);
        }
        return null;
    }

    public static int totalOrder(User user) {
        List<Order> orderOFThisCustomer = OrderDAO.getOrderByIdCustomer(user.getId());
        if (orderOFThisCustomer.size() > 0) {
            return orderOFThisCustomer.size();
        }
        return 0;
    }
}
