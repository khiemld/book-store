package com.bookstore.admin.business;

import com.bookstore.dao.DeliveryDAO;
import com.bookstore.entity.Delivery;

import java.util.List;

public class DeliveryBS {
    public static String CheckInputData(Delivery delivery) {
        if (delivery.getShipFee() <= 0) {
            return "Vui lòng <b>tiền ship dương</b>!";
        }
        if(!"OK".equals(DeliveryBS.CheckNameAvailable(delivery))){
            return "<b>Tên phương thức đã tồn tại</b>! Vui lòng nhập tên khác";
        }
        return "OK";
    }
    public static String CheckNameAvailable(Delivery delivery) {
        List<Delivery> foundedList = DeliveryDAO.getDeliveryByName(delivery.getName());
        if (foundedList.size() >= 1) {
            return "<b>Tên phương thức đã tồn tại</b>! Vui lòng nhập tên khác";
        }
        return "OK";
    }
}
