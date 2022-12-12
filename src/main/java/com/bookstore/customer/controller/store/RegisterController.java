package com.bookstore.customer.controller.store;

import com.bookstore.dao.*;
import com.bookstore.entity.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "RegisterServlet", value = "/register")
public class RegisterController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        System.out.println("Loading: RegisterController DoGet");

        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        HttpSession session = request.getSession();
        response.setContentType("text/html");
        String url = "/login";

        System.out.println("Loading: RegisterController DoPost");


        String name = request.getParameter("name").trim();
        String address = request.getParameter("address").trim();
        String phone = request.getParameter("phone").trim();
        String email = request.getParameter("email").trim();
        String password = request.getParameter("password").trim();

//        Kiểm tra để đảm bảo phone và email là unique
        UserDAO userDAO = new UserDAO();
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
            //Nếu email và phone number hợp lệ thì tiến hành đăng ký thành viên
            User user = new User();
            user.setName(name);
            user.setPhone(phone);
            user.setAddress(address);
            user.setEmail(email);
            user.setPassword(password);
            user.setIsRole(3);
            user.setActive(true);

            request.setAttribute("user", user);

            try {
                userDAO.save(user);
                session.setAttribute("statusRegisterForm", 0);
                System.out.println("Thêm User thành công");
            } catch (Exception e) {
                // TODO Auto-generated catch block
                session.setAttribute("statusRegisterForm", 1);
                System.out.println("Thêm User không thành công");
                e.printStackTrace();
            }
        }
        session.setAttribute("register_error", errorMessage);
        getServletContext().getRequestDispatcher(url).forward(request,response);

//        response.setContentType("text/html");
//        request.getRequestDispatcher("/store/views/register.jsp").forward(request, response);
    }
}
