package com.bookstore.customer.controller.store;

import com.bookstore.dao.*;
import com.bookstore.entity.Email;
import com.bookstore.entity.User;
import com.bookstore.util.EmailUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ForgotPassword", value = "/forgot")
public class ForgotPasswordController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html");
        request.getRequestDispatcher("/store/views/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html");

        System.out.println("Forgot DoPost");

        try {

            String resetEmail = request.getParameter("resetEmail").trim();

            UserDAO userDAO = new UserDAO();
            User user = userDAO.findByEmail(resetEmail);

            if(user == null){
                request.setAttribute("error", "Email không tồn tại. Vui lòng nhập lại");
            }
            else {
                System.out.println("Xử lý forgot");
                Email email = new Email();
                email.setFrom("hau.trantrungg@gmail.com");
                email.setFromPassword("rdobhlqlzqazyrrt");
                email.setTo(resetEmail);
                email.setSubject("Tìm kiếm mật khẩu");

                StringBuilder content = new StringBuilder();
                content.append("Gửi ").append(user.getName()).append(",<br><br>");
                content.append("Mật khẩu của bạn là ").append(user.getPassword()).append("<br>");
                content.append("Trân trọng. <br><br>");
                content.append("Administrator <br> Giấy Bookstore.");

                email.setContent(content.toString());
                EmailUtils.send(email);

                request.setAttribute("message", "Mật khẩu đã được gửi đến địa chỉ email của bạn."
                        + "Vui lòng kiểm tra email và xem password");
            }
        }
        catch (Exception e){
            e.printStackTrace();
            request.setAttribute("error", e.getMessage());
        }

        request.getRequestDispatcher("/store/views/login.jsp").forward(request, response);
    }
}
