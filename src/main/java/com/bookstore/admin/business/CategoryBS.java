package com.bookstore.admin.business;

import com.bookstore.admin.business.ProductBS;
import com.bookstore.dao.CategoryDAO;
import com.bookstore.dao.ProductDAO;
import com.bookstore.entity.Category;
import com.bookstore.entity.Product;

import java.util.ArrayList;
import java.util.List;

public class CategoryBS {
    //    Trả về số lượng sách của mỗi loại đã bán đươc
    public static List<Integer> totalSaleOfCartegory() {
        List<Integer> saleList = new ArrayList<>();
//        Lấy ra tất cả các loại
        List<Category> categories = CategoryDAO.getAll();
//        Ở từng loại sẽ tính từng số sách bán được
        for (Category category : categories) {
            int count = 0;
            List<Product> productList = ProductDAO.getProductByCategoryID(category.getId());
            count = ProductBS.sellBook(productList);
            saleList.add(count);
        }
        return saleList;
    }

    public static String CheckNameAvailable(Category category) {
        List<Category> foundedList = CategoryDAO.getCategoryByName(category.getName());
        if (foundedList.size() >= 1) {
            return "<b>Tên loại sách đã tồn tại</b>! Vui lòng nhập tên khác";
        }
        return "OK";
    }

    public static int totalProduct(Category category) {
        List<Product> foundList = ProductDAO.getProductByCategoryID(category.getId());
        if (foundList.size() != 0) {
            return foundList.size();
        }
        return 0;
    }
}
