package com.bookstore.customer.controller.buy;



import com.bookstore.dao.*;


import com.bookstore.entity.Order;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "OrderProfileServlet", value = "/orderProfile")
public class OrderProfileController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int uid = Integer.parseInt(request.getParameter("uid"));
        OrderDAO orderDAO = new OrderDAO();

        List<Order> orders = orderDAO.getOrderByIdCustomer(uid);


        request.setAttribute("orders", orders);
        request.getRequestDispatcher("/store/views/myOrder.jsp").forward(request, response);
    }
}
