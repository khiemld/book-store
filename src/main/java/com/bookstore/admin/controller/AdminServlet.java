package com.bookstore.admin.controller;

import com.bookstore.admin.business.AdminBS;
import com.bookstore.admin.business.EmployeeBS;
import com.bookstore.dao.UserDAO;
import com.bookstore.entity.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "AdminServlet", value = "/admin/profile")
public class AdminServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        // Lấy action của người dùng
        String action = request.getParameter("action");
        if (action == null) {
            action = new String("home");
        }
        switch (action) {
            case "home":
                response.sendRedirect("/admin");
                break;
            case "save":
                actionSave(request, response);
                break;
            default:
                request.getRequestDispatcher("/admin/employee.jsp").forward(request, response);
                break;
        }
    }

    protected void actionSave(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        String eID = request.getParameter("eID");
        String eName = request.getParameter("employeeName");
        String eAddress = request.getParameter("employeeAddress");
        String eEmail = request.getParameter("employeeEmail");
        String ePhone = request.getParameter("employeePhone");
        String ePassword = request.getParameter("employeePassword");
        String eImageLink = request.getParameter("employeeImageLink");


//        Kiểm tra người dùng có nhập dữ liệu vào hay chưa
        if (!eName.trim().equals("") && !eAddress.trim().equals("") && !eEmail.trim().equals("") && !ePhone.trim().equals("")) {
//            Thực hiện kiểm tra dữ liệu vào

//            Tạo một đối tượng Product để lưu dữ liệu
            User user = new User();
            if (!eID.equals("")) {
                user.setId(Integer.parseInt(eID));
            }
            user.setName(eName);
            user.setAddress(eAddress);
            user.setEmail(eEmail);
            user.setPhone(ePhone);
            user.setPassword(ePassword);
            user.setImage(eImageLink);
            HttpSession session = request.getSession();
            User whoDoACtion = (User) session.getAttribute("acc");
            if(whoDoACtion.getIsRole()==1){
                user.setIsRole(1);
            }
            else{
                user.setIsRole(2);
            }

            user.setActive(true);

//            Kiểm tra dữ liệu đầu vào đang được lưu trong book
//            Nêu dữ liệu chưa hợp lệ
            if (!"OK".equals(AdminBS.CheckInputData(user))) {
                request.setAttribute("employee", user);
                request.setAttribute("message", AdminBS.CheckInputData(user));
                request.getRequestDispatcher("/admin/employee-form.jsp").forward(request, response);
            }
//            Nếu dữ liệu hợp lệ
            else {
//              Kiểm tra xem có ID chưa, nếu chưa là thêm mới, nếu có là cập nhật
//              Đang thêm nhân viên mới
                if (user.getId() == 0) {
//                  Kiểm tra xem một số thông tin phải là unique
//                  Nếu số điện thoại đã tồn tại
                    if (!"OK".equals(AdminBS.CheckPhoneAvailable(user))) {
                        request.setAttribute("employee", user);
                        request.setAttribute("message", AdminBS.CheckPhoneAvailable(user));
                        request.getRequestDispatcher("/admin/employee-form.jsp").forward(request, response);
                    }
//                    Nếu email đã tồn tại
                    else if (!"OK".equals(AdminBS.CheckEmailAvailable(user))) {
                        request.setAttribute("employee", user);
                        request.setAttribute("message", AdminBS.CheckPhoneAvailable(user));
                        request.getRequestDispatcher("/admin/employee-form.jsp").forward(request, response);
                    }
//                  Nếu email và điện thoại là mới
                    else {
                        UserDAO.save(user);
                        String message = new String("Vừa thêm nhân viên <b>" + user.getName() + "</b>");
                        request.setAttribute("message", message);
                        List<User> employeeList = EmployeeBS.getAll();
                        request.setAttribute("employeeList", employeeList);
                        request.getRequestDispatcher("/admin/employee.jsp").forward(request, response);
                    }
                }
//                Đang cập nhật sách
                else {
                    UserDAO.update(user);
                    session.removeAttribute("acc");
                    session.setAttribute("acc", user);
                    String message;
                    if(whoDoACtion.getIsRole()==1){
                        response.sendRedirect("/admin?message=updated-admin");
                    }
                    else{
                        response.sendRedirect("/admin/order?message=updated-employee");
                    }
                }
            }
        }
    }
}
