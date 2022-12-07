package com.bookstore.controller.customer;

import com.bookstore.dao.UserDAO;
import com.bookstore.entity.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html");
        System.out.println("Loading: LoginController DoGet");

        request.setAttribute("statusRegisterForm", 0); //0: hiện khung đăng nhập, 1: hiện khung đăng ký

        request.getRequestDispatcher("/store/views/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String email = request.getParameter("user");
        String password = request.getParameter("pass");

        System.out.println("Loading: LoginController DoPost");

        UserDAO userDAO = new UserDAO();
        User account = userDAO.testLogin(email, password);
        if(account.getName() != null){
            HttpSession session = request.getSession();
            session.setAttribute("acc", account);
            request.getRequestDispatcher("/store/views/home.jsp").forward(request, response);
        }
        else{
            request.setAttribute("error", "Wrong email or password");
            request.getRequestDispatcher("/store/views/login.jsp").forward(request, response);
        }
    }
}
