package com.bookstore.customer.controller.buy;

import com.bookstore.dao.*;

import com.bookstore.entity.CartItem;


import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "showCartServlet", value = "/showCart")
public class ShowCartController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int uid = Integer.parseInt(request.getParameter("uid"));

        if(uid != 0){
            CartItemDAO cartItemDAO = new CartItemDAO();

            List<CartItem> cartItems =cartItemDAO.getItemListByUId(uid);
            int total = cartItemDAO.totalPrice(cartItems);
            request.setAttribute("total", total);
            request.setAttribute("listItem",cartItems);
            request.getRequestDispatcher("/store/views/cart.jsp").forward(request, response);
        }
        else{
            request.getRequestDispatcher("/store/views/cart.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

            CartItemDAO cartItemDAO = new CartItemDAO();
            int idUser = Integer.parseInt(request.getParameter("uid"));


            List<CartItem> cartItems =cartItemDAO.getItemListByUId(idUser);
            int total = cartItemDAO.totalPrice(cartItems);
            request.setAttribute("total", total);
            request.setAttribute("listItem",cartItems);
            request.getRequestDispatcher("/store/views/cart.jsp").forward(request, response);
    }
}
