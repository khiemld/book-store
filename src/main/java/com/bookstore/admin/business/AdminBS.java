package com.bookstore.admin.business;

import com.bookstore.dao.UserDAO;
import com.bookstore.entity.User;

import java.util.List;

public class AdminBS {
    public static List<User> getAll() {
        List<User> admins = UserDAO.findByRole(1); // 1 - admin
        return admins;
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
}
