package com.bookstore.customer.controller.store;

import com.bookstore.dao.*;
import com.bookstore.entity.Email;
import com.bookstore.entity.User;
import com.bookstore.utility.EmailUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Enumeration;

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

        HttpSession session = request.getSession(true);
        System.out.println("Forgot DoPost");
        String url = "";

        String action = request.getParameter("action");
        System.out.println("action:" + action);

        if (action.equals("enterOTP")) {
            String resetEmail = request.getParameter("resetEmail");
//            request.setAttribute("resetEmail", resetEmail);
            url = "/store/views/enterOTP.jsp";

            try {
                UserDAO userDAO = new UserDAO();
                User user = userDAO.findByEmail(resetEmail);
                System.out.println("userrest: " + user.getId() + user.getName() + user);

                if(user.getName() == null){
                    request.setAttribute("error", "Email không tồn tại. Vui lòng nhập lại");
                    url = "/store/views/login.jsp";
                    request.setAttribute("resetEmail", resetEmail);
                }
                else {
                    System.out.println("send email");
                    Email email = new Email();
                    email.setFrom("hau.trantrungg@gmail.com");
                    email.setFromPassword("rdobhlqlzqazyrrt");
                    email.setTo(resetEmail);
                    email.setSubject("Mã OTP");

                    String otp = EmailUtils.generateOTP();

                    StringBuilder content = new StringBuilder();
                    content.append("Gửi ").append(user.getName()).append(",<br><br>");
                    content.append("Mã OTP của bạn là ").append(otp).append("<br>");
                    content.append("Trân trọng. <br><br>");
                    content.append("Administrator <br> Giấy Bookstore.");

                    email.setContent(content.toString());
                    EmailUtils.send(email);

                    session.setAttribute("resetEmail", resetEmail);
                    session.setAttribute("otp", otp);
                }
            }
            catch (Exception e){
                e.printStackTrace();
                request.setAttribute("error", e.getMessage());
            }
            System.out.println(url);
            request.getRequestDispatcher(url).forward(request, response);
        }
        else { //action = checkOTP, kiểm tra mã OTP, nếu đúng chuyển sang trang edit mật khẩu editProfile
            String resetEmail = session.getAttribute("resetEmail").toString();
            System.out.println("session.getAttribute(\"resetEmail\").toString()");
            url = "/store/views/editprofile.jsp";
            String otp = session.getAttribute("otp").toString().trim();
            System.out.println("session.getAttribute(\"otp\").toString().trim()");
            String inputOTP = request.getParameter("inputOTP").trim();
            System.out.println("request.getParameter(\"inputOTP\").trim():" + inputOTP);

            String checkSession = "";
            Enumeration enumeration = session.getAttributeNames();
            while (enumeration.hasMoreElements()){
                String current = (String) enumeration.nextElement();

                checkSession = " - " + current + ": " + session.getAttribute(current) + "\n";
            }
            System.out.println(checkSession + "isNew: " + session.isNew());

            //kiểm tra xem otp mà người dùng nhập có bằng với otp được gửi vào mail không
            if (!otp.equals(inputOTP)){ //nếu không giống
                System.out.println("!otp.equals(inputOTP)");
                url = "/store/views/enterOTP.jsp";
            }
            else {
                System.out.println("otp.equals(inputOTP)");
//
//                request.setAttribute("resetEmail", resetEmail);
//                session.removeAttribute("resetEmail");
                session.removeAttribute("otp");
            }
//            response.sendRedirect(request.getContextPath() + url);
            System.out.println(url);
            request.getRequestDispatcher(url).forward(request, response);
        }
    }
}
