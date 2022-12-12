package com.bookstore.admin.business;

import com.bookstore.dao.OrderDAO;
import com.bookstore.entity.Order;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class OrderBS {
    public static List<OrderStatusBS> statusList() {
        List<OrderStatusBS> statuses = new ArrayList<>();
        OrderStatusBS st1 = new OrderStatusBS(1, "Chờ xác nhận");
        OrderStatusBS st2 = new OrderStatusBS(2, "Chờ lấy hàng");
        OrderStatusBS st3 = new OrderStatusBS(3, "Đang giao");
        OrderStatusBS st4 = new OrderStatusBS(4, "Đã giao");
        OrderStatusBS st5 = new OrderStatusBS(5, "Đã hủy");
        statuses.add(st1);
        statuses.add(st2);
        statuses.add(st3);
        statuses.add(st4);
        statuses.add(st5);
        return statuses;
    }

    public static Date estimateReceiveDate(Order order) {
        Date dt = order.getCreateTime();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dt);
        int delivery = order.getIdDelivery();
        int deleveryTime = 0;
        switch (delivery) {
            case 1:
                deleveryTime = 3;
                break;
            case 2:
                deleveryTime = 2;
                break;
            default:
                deleveryTime = 3;
                break;
        }
        calendar.add(Calendar.DATE, deleveryTime);
        String newYear = String.valueOf(calendar.get(Calendar.YEAR));
        String newMonth = String.valueOf(calendar.get(Calendar.MONTH)+1);
        String newDate = String.valueOf(calendar.get(Calendar.DATE));
        String receiveDate = newYear + "-" + newMonth + "-" + newDate;
        Date newdt = Date.valueOf(receiveDate);
        return newdt;
    }

    public static OrderStatusBS findStatusByID(int id) {
        OrderStatusBS selectedStatus = null;
        for (OrderStatusBS status : statusList()) {
            if (status.getId() == id) {
                selectedStatus = status;
            }
        }
        return selectedStatus;
    }

    //    Lấy ra doanh thu mỗi ngày trong một tuần vừa qua
    public static List<Integer> incomeLastWeek() {
        List<Date> lastWeek = aLastWeekFromNow();
        List<Integer> income = new ArrayList<>();
        for (Date date : lastWeek) {
            int count = 0;
            for (Order order : OrderDAO.getAll()) {
                if (order.getStatus() == 5 || order.getStatus() == 1) {
                    continue;
                }
                if (order.getCreateTime().compareTo(date) == 0) {
                    count += order.getTotalPay();
                }
            }
            income.add(count);
        }
        return income;
    }

    //    Lấy ra một tuần trước bao gồm ngày hôm nay
    public static List<Date> aLastWeekFromNow() {
        List<Date> lastWeek = new ArrayList<>();
        Date now = Date.valueOf(LocalDate.now());
        Calendar calendar = Calendar.getInstance();
        for (int i = 6; i >= 1; i--) {
            calendar.setTime(now);
            calendar.add(Calendar.DATE, -i);
            String newYear = String.valueOf(calendar.get(Calendar.YEAR));
            String newMonth = String.valueOf(calendar.get(Calendar.MONTH) + 1);
            String newDate = String.valueOf(calendar.get(Calendar.DATE));
            String dayAgo = newYear + "-" + newMonth + "-" + newDate;
            Date newdt = Date.valueOf(dayAgo);
            lastWeek.add(newdt);
        }
        lastWeek.add(now);
        return lastWeek;
    }

}
