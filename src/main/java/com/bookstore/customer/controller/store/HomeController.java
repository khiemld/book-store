package com.bookstore.customer.controller.store;

import com.bookstore.dao.*;
import com.bookstore.entity.Product;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "HomeController", value = {"/home"})
public class HomeController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        ProductDAO productDAO = new ProductDAO();
        List<Product> product4Lastest = null;
        product4Lastest = productDAO.get4LastestProduct();

        Product product1Lastest = productDAO.getLatestProduct();

        request.setAttribute("list1product", product1Lastest);
        request.setAttribute("list4last",  product4Lastest);

        RequestDispatcher rq =request.getRequestDispatcher("/store/views/home.jsp");
        rq.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        doGet(request, response);
    }
}
