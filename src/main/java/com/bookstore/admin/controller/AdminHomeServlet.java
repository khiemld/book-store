package com.bookstore.admin.controller;

import com.bookstore.admin.business.*;
import com.bookstore.dao.CategoryDAO;
import com.bookstore.dao.OrderDAO;
import com.bookstore.dao.ProductDAO;
import com.bookstore.entity.Category;
import com.bookstore.entity.Order;
import com.bookstore.entity.Product;
import com.bookstore.entity.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Date;
import java.util.List;

@WebServlet(name = "AdminHomeServlet", value = "/admin")
public class AdminHomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //      Thêm tiếng việt
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        List<Product> bookList = ProductDAO.getAll();
        request.setAttribute("bookList", bookList);

        List<User> userList = CustomerBS.getAll();
        request.setAttribute("customerList", userList);

        List<User> employeeList = EmployeeBS.getAll();
        request.setAttribute("employeeList", employeeList);

        List<Order> orderList = OrderDAO.get5LastestOrder();
        request.setAttribute("orderList", orderList);

        List<Product> book5List = ProductDAO.get5LastestProduct();
        request.setAttribute("book5List", book5List);

        Product bestSellerBook= ProductBS.BestSellerBook();
        request.setAttribute("bestSellerBook", bestSellerBook);

        List<Category> categoryList = CategoryDAO.getAll();
        request.setAttribute("categoryList", categoryList);

        List<Integer> totalSaleOfCartegory= CategoryBS.totalSaleOfCartegory();
        request.setAttribute("totalSaleOfCartegory", totalSaleOfCartegory);

        List<Date> lastWeekFromNow= OrderBS.aLastWeekFromNow();
        request.setAttribute("lastWeekFromNow", lastWeekFromNow);

        List<Integer> incomeLastWeek=OrderBS.incomeLastWeek();
        request.setAttribute("incomeLastWeek", incomeLastWeek);

        User bestCustomerByPrice= CustomerBS.BestCustomerByPrice();
        request.setAttribute("bestCustomerByPrice", bestCustomerByPrice);

        // Tổng số bán trong ngày
        // Thu nhập trong tháng
        // Khách hàng trong năm
        // Top selling
        request.getRequestDispatcher("/admin/index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
