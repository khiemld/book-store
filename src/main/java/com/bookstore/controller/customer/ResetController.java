package com.bookstore.controller.customer;

import com.bookstore.dao.UserDAO;
import com.bookstore.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet(name = "ResetController", value = "/reset")
public class ResetController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html");
        User user = (User) request.getSession().getAttribute("acc");
        System.out.println("acc: " + user.getEmail());
        request.getRequestDispatcher("/store/views/editprofile.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        String error = "";
        String message = "";
        String url = "/store/views/editprofile.jsp";
        HttpSession session = request.getSession();
        response.setContentType("text/html");

        System.out.println("Vào được doPost ResetController");

        User user = new User();

        //Kiểm tra User có tồn tại bằng id
        UserDAO userDAO = new UserDAO();

        String checkSession = "";
        Enumeration enumeration = session.getAttributeNames();
        while (enumeration.hasMoreElements()){
            String current = (String) enumeration.nextElement();

            checkSession = " - " + current + ": " + session.getAttribute(current) + "\n";
        }
        System.out.println(checkSession + "isNew: " + session.isNew());

        //Kiểm tra, nếu đây là đổi mật khẩu cho người dùng Quên mật khẩu (Mật khẩu cữ == null)
        if(request.getParameterMap().containsKey("opass")){
            user = (User) request.getSession().getAttribute("acc");
            if(userDAO.findById(user.getId()) == null) {
                System.out.println("Người dùng không tồn tại, vui lòng kiểm tra lại hoặc đăng nhập lại");
                error = "Người dùng không tồn tại, vui lòng kiểm tra lại hoặc đăng nhập lại";
            } else if (!request.getParameter("opass").trim().equals(user.getPassword())) { //Kiểm tra mật khẩu cũ có đúng không\
                error = "Mật khẩu không chính xác, vui lòng nhập lại";
            }
        }
        else {
            String email = session.getAttribute("resetEmail").toString().trim();
            user = (User) userDAO.findByEmail(email);
        }

        if(error != null) { //Thỏa hết điều kiện
            try {
                String npassword = request.getParameter("npass").trim();
                user.setPassword(npassword);
                userDAO.update(user);
                message = "Thay đổi mật khẩu thành công\nVui lòng đăng nhập lại";

//                Đăng nhập lại
                url = "/store/views/login.jsp";

                if(session.getAttribute("acc") != null) {
                    session.removeAttribute("acc");
                }

                System.out.println("Update mật khẩu User thành công");
            } catch (Exception e) {
                // TODO Auto-generated catch block
                error = "Thay đổi mật khẩu không thành công\nLỗi: " + e.getMessage();
                System.out.println("Update mật khẩu User không thành công");
                e.printStackTrace();
            }
        }
        request.setAttribute("error", error);
        request.setAttribute("message", message);
        request.getRequestDispatcher(url).forward(request,response);
    }
}
