package com.bookstore.customer.controller.buy;

import com.bookstore.dao.*;
import com.bookstore.entity.CartItem;
import com.bookstore.entity.Product;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProcessCartServlet", value = "/process")
public class ProcessCartController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String num_raw = request.getParameter("num");
        String id_raw = request.getParameter("id");
        String id_User_raw = request.getParameter("u");
        CartItemDAO cartItemDAO = new CartItemDAO();
        try{
            int id = Integer.parseInt(id_raw);
            ProductDAO productDAO = new ProductDAO();
            Product product = productDAO.getProductByID(id);
            int numStore = product.getQuantity();
            int num = Integer.parseInt(num_raw);
            int idUser = Integer.parseInt(id_User_raw);

            CartItem cartItem = cartItemDAO.testCartItem(idUser, id).get(0);

            if(num == -1){
                if(cartItem.getQuantity() > 1){
                    cartItemDAO.RemoveItem(cartItem);
                }
                if(cartItem.getQuantity() == 1){
                    cartItemDAO.delete(cartItem.getId());
                }
            }
            else{
                if(num == 1 && (cartItem.getQuantity() >= numStore)){
                    CartItem cartItem1 = new CartItem(idUser, id, 0, product.getSalePrice());
                    cartItemDAO.addCartItem(cartItem1);
                }
                else{
                    CartItem cartItem1 = new CartItem(idUser, id, 1, product.getSalePrice());
                    cartItemDAO.addCartItem(cartItem1);
                }

            }

        }
        catch (NumberFormatException e){

        }
        int idUser = Integer.parseInt(request.getParameter("u"));
        List<CartItem> cartItems =cartItemDAO.getItemListByUId(idUser);
        int total = cartItemDAO.totalPrice(cartItems);
        request.setAttribute("total", total);
        request.setAttribute("listItem",cartItems);
        request.getRequestDispatcher("/store/views/cart.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
