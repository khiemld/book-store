package com.bookstore.controller.customer;

import com.bookstore.dao.CategoryDAO;
import com.bookstore.dao.ProductDAO;
import com.bookstore.entity.Category;
import com.bookstore.entity.Product;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "SearchController", value = "/search")
public class SearchController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF8");
        request.setCharacterEncoding("UTF-8");

        String nameSearch = request.getParameter("txt");
        ProductDAO productDAO = new ProductDAO();
        CategoryDAO categoryDAO = new CategoryDAO();

        List<Product> productList = productDAO.searchByName(nameSearch);
        List<Category> categories = categoryDAO.getAll();
        Product lastProduct = productDAO.getLatestProduct();

        request.setAttribute("listProduct", productList);
        request.setAttribute("listCategory", categories);
        request.setAttribute("lastProduct", lastProduct);
        request.setAttribute("txtSearch", nameSearch);

        request.getRequestDispatcher("/store/views/category.jsp").forward(request, response);
    }
}
