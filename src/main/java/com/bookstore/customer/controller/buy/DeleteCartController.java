package com.bookstore.customer.controller.buy;

import com.bookstore.dao.*;
import com.bookstore.entity.CartItem;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "DeleteServlet", value = "/deleteCart")
public class DeleteCartController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*response.setContentType("text/html");
        String uid = request.getParameter("uid");
        String pid = request.getParameter("pid");

        PrintWriter printWriter = response.getWriter();

        printWriter.println(uid);
        printWriter.println(pid);*/
        int uid = Integer.parseInt(request.getParameter("uid"));
        int pid = Integer.parseInt(request.getParameter("pid"));

        CartItemDAO cartItemDAO = new CartItemDAO();
        CartItem cartItem = cartItemDAO.testCartItem(uid, pid).get(0);

        cartItemDAO.delete(cartItem.getId());

        request.setAttribute("uid", uid);
        request.getRequestDispatcher("showCart").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
