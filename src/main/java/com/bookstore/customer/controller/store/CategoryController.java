package com.bookstore.customer.controller.store;

import com.bookstore.dao.*;
import com.bookstore.entity.Category;
import com.bookstore.entity.Product;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;


@WebServlet(name = "CategoryController", value = "/category")
public class CategoryController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=UTF8");

        String cateID = request.getParameter("cid");


        ProductDAO productDAO = new ProductDAO();
        CategoryDAO categoryDAO = new CategoryDAO();

        List<Product> products = productDAO.getAll();
        List<Category> categories = categoryDAO.getAll();
        Product lastProduct = productDAO.getLatestProduct();
        List<Product> productByCateID = productDAO.getProductByCategoryID(Integer.parseInt(cateID));

        if("0".equals(cateID)){
            request.setAttribute("listProduct", products);
        }
        else{
            request.setAttribute("listProduct", productByCateID);
        }

        request.setAttribute("listCategory", categories);
        request.setAttribute("lastProduct", lastProduct);
        request.setAttribute("tag", cateID); //Đánh dấu để load dữ liệu lên Category
        request.getRequestDispatcher("/store/views/category.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        doGet(request, response);
    }
}
