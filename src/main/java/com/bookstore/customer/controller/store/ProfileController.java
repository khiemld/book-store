package com.bookstore.customer.controller.store;

import com.bookstore.dao.*;
import com.bookstore.entity.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ProfileController", value = "/profile")
public class ProfileController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html");
        User user = (User) request.getSession().getAttribute("acc");
        System.out.println("acc: " + user.getEmail());
        request.getRequestDispatcher("/store/views/profile.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");

        HttpSession session = request.getSession();
        response.setContentType("text/html");
        String message = "";

        System.out.println("Vào được doPost");

        String name = request.getParameter("name").trim();
        String address = request.getParameter("address").trim();
        String phone = request.getParameter("phone").trim();
        String email = request.getParameter("email").trim();
        String image = request.getParameter("image").trim();

        User user = new User();
        user = (User) session.getAttribute("acc");
        int id = user.getId();

        UserDAO userDAO = new UserDAO();
//      Check unique cho email và phone
        String errorMessage = "";
        if(!userDAO.isValidUpdateEmail(email, id) && userDAO.isExistEmail(email)){
            errorMessage = "Địa chỉ Email đã tồn tại, vui lòng nhập Địa chỉ Email khác";
        }
        if(!userDAO.isValidUpdatePhone(phone, id) && userDAO.isExistPhone(phone)){
            if(errorMessage == ""){
                errorMessage = "Số điện thoại đã tồn tại, vui lòng nhập Số điện thoại khác";
            }
            else{
                errorMessage = "Email và số điện thoại đã tồn tại\nVui lòng nhập lại.";
            }
        }
        System.out.println("Error Message: " + errorMessage);

        if(errorMessage == ""){
            //      Update: begin
            user.setName(name);
            user.setPhone(phone);
            user.setEmail(email);
            user.setAddress(address);
            user.setImage(image);
            try {
                userDAO.update(user);
                System.out.println("Update User thành công");
                message = "Cập nhật thông tin thành công.";
            } catch (Exception e) {
                // TODO Auto-generated catch block
                System.out.println("Update User không thành công");
                e.printStackTrace();
            }
            request.setAttribute("acc", user);
//      Update: End
        }
        session.setAttribute("update_error", errorMessage);
        session.setAttribute("message", message);
        request.getRequestDispatcher("/store/views/profile.jsp").forward(request, response);
    }
}
