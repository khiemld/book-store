package com.bookstore.admin.business;

import com.bookstore.dao.ProductDAO;
import com.bookstore.entity.OrderItem;
import com.bookstore.entity.Product;

import java.util.ArrayList;
import java.util.List;

public class OrderItemBS {
    public static List<OrderItem> finalOrderItemList(List<OrderItem> itemList) {
        List<OrderItem> finalList = new ArrayList<>();
        for (OrderItem item : itemList) {
            Product product = ProductDAO.getProductByID(item.getIdProduct());
            item.setProductByIdProduct(product);
            finalList.add(item);
        }
        return finalList;
    }
}
