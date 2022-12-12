package com.bookstore.admin.business;

import com.bookstore.dao.PaymentDAO;
import com.bookstore.entity.PayMethod;

import java.util.List;

public class PaymethodBS {
    public static String CheckNameAvailable(PayMethod paymethod) {
        List<PayMethod> foundedList = PaymentDAO.find(paymethod.getName());
        if (foundedList.size() >= 1) {
            return "<b>Tên phương thức đã tồn tại</b>! Vui lòng nhập tên khác";
        }
        return "OK";
    }
}
