package com.bookstore.customer.controller.store;

import com.bookstore.dao.*;
import com.bookstore.entity.Product;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "DetailProductController", value = "/detail")
public class DetailProductController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String id = request.getParameter("pid");
        ProductDAO productDAO = new ProductDAO();
        Product product = productDAO.getProductByID(Integer.parseInt(id));
        request.setAttribute("detail", product);
        request.getRequestDispatcher("/store/views/detailProduct.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
