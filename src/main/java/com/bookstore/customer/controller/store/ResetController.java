package com.bookstore.customer.controller.store;

import com.bookstore.dao.*;
import com.bookstore.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "ResetController", value = "/reset")
public class ResetController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html");
        User user = (User) request.getSession().getAttribute("acc");
        System.out.println("acc: " + user.getEmail());
        request.getRequestDispatcher("/store/views/profile.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        HttpSession session = request.getSession();
        response.setContentType("text/html");

        System.out.println("Vào được doPost");

        String name = request.getParameter("name").trim();
        String address = request.getParameter("address").trim();
        String phone = request.getParameter("phone").trim();
        String email = request.getParameter("email").trim();
//        String image = request.getParameter("image").trim();

        UserDAO userDAO = new UserDAO();
//      Check unique cho email và phone
        String errorMessage = "";
        if(userDAO.isExistEmail(email)){
            errorMessage = "Email already exists, please enter another email.";
        }
        if(userDAO.isExistPhone(phone)){
            if(errorMessage == ""){
                errorMessage = "Phone number already exists, please enter another phone number.";
            }
            else{
                errorMessage = "Email and phone number already exists, please enter another email and phone number";
            }
        }
        System.out.println("Error Message: " + errorMessage);

        if(errorMessage == ""){
            //      Update: begin
            User user = new User();
            user = (User)   request.getSession().getAttribute("acc");
            user.setName(name);
            user.setPhone(phone);
            user.setEmail(email);
            user.setAddress(address);
            try {
                userDAO.update(user);
                System.out.println("Update User thành công");
            } catch (Exception e) {
                // TODO Auto-generated catch block
                System.out.println("Update User không thành công");
                e.printStackTrace();
            }
            request.setAttribute("acc", user);
//      Update: End
        }
        session.setAttribute("update_error", errorMessage);
        request.getRequestDispatcher("/store/views/profile.jsp").forward(request, response);
    }
}
