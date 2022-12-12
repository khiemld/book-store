package com.bookstore.customer.controller.store;

import com.bookstore.dao.*;
import com.bookstore.entity.Product;
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
        String url ="/store/views/login.jsp";

//        request.setAttribute("statusRegisterForm", 0); //0: hiện khung đăng nhập, 1: hiện khung đăng ký
//        String action = request.getParameter("action").trim();
//        if(action.equals("register-form")){
//            url = "/store/views/login.jsp";
//        } else if (action.equals("signin-form")) {
//            url = "/store/views/login.jsp";
//        }
        if(request.getAttribute("error") != null){
            request.removeAttribute("error");
        }
        if(request.getAttribute("register_error") != null){
            request.removeAttribute("register_error");
        }

//        request.setAttribute("error", "");
//        request.setAttribute("register_error", "");

        request.getRequestDispatcher(url).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        System.out.println("Loading: LoginController DoPost");
        String action = request.getParameter("action").trim();
        System.out.println("action = " + action);

        if(action.equals("signin")){
            String email = request.getParameter("user");
            String password = request.getParameter("pass");

            System.out.println("Loading: LoginController DoPost");

            UserDAO userDAO = new UserDAO();
            User account = userDAO.testLogin(email, password);
            if(account.getName() != null){

                if(account.getIsRole() == 3){
                    HttpSession session = request.getSession();
                    session.setAttribute("acc", account);
                    ProductDAO productDAO = new ProductDAO();
                    List<Product> product4Lastest = null;
                    product4Lastest = productDAO.get4LastestProduct();

                    Product product1Lastest = productDAO.getLatestProduct();

                    request.setAttribute("list1product", product1Lastest);
                    request.setAttribute("list4last",  product4Lastest);
                    request.getRequestDispatcher("/store/views/home.jsp").forward(request, response);
                }
                else {
                    HttpSession session = request.getSession();
                    session.setAttribute("admin", account);
                    response.sendRedirect("admin");
                }

            }
            else{
                request.setAttribute("error", "Wrong email or password");
                request.getRequestDispatcher("/store/views/login.jsp").forward(request, response);
            }
        } else if (action.equals("createAccount")) {
            String name = request.getParameter("name").trim();
            String address = request.getParameter("address").trim();
            String phone = request.getParameter("phone").trim();
            String email = request.getParameter("email").trim();
            String password = request.getParameter("password").trim();

//        Kiểm tra để đảm bảo phone và email là unique
            UserDAO userDAO = new UserDAO();
            String errorMessage = "";
            if(userDAO.isExistEmail(email)){
                errorMessage = "Địa chỉ Email được đã đăng ký trước đó. Vui lòng nhập email mới";
            }
            if(userDAO.isExistPhone(phone)){
                if(errorMessage == ""){
                    errorMessage = "Số điện thoại được đã đăng ký trước đó. Vui lòng nhập email mới";
                }
                else{
                    errorMessage = "Số điện thoại và địa chỉ Email được đã đăng ký trước đó. Vui lòng nhập email mới";
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
                    System.out.println("Thêm User thành công");
                    request.setAttribute("message", "Đăng ký tài khoản thành công");
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    System.out.println("Thêm User không thành công");
                    e.printStackTrace();
                }
            }
            request.setAttribute("error", errorMessage);
            request.getRequestDispatcher("/store/views/login.jsp").forward(request, response);
//        response.setContentType("text/html");
//        request.getRequestDispatcher("/store/views/register.jsp").forward(request, response);
        }
    }
}
