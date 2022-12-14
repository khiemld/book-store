package com.bookstore.admin.controller;

import com.bookstore.admin.business.EmployeeBS;
import com.bookstore.dao.UserDAO;
import com.bookstore.entity.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "EmployeeServlet", value = "/admin/employee")
public class EmployeeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        Thêm tiếng việt
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        List<User> employeeList = EmployeeBS.getAll();
        request.setAttribute("employeeList", employeeList);

        User BestEmployeeByPrice = EmployeeBS.BestEmployeeByPrice();
        request.setAttribute("BestEmployeeByPrice", BestEmployeeByPrice);

        User BestEmployeeByBooks = EmployeeBS.BestEmployeeByBooks();
        request.setAttribute("BestEmployeeByBooks", BestEmployeeByBooks);

        // Lấy action của người dùng
        String action = request.getParameter("action");
        if (action == null) {
            action = new String("home");
        }
        switch (action) {
            case "insert":
                actionInsert(request, response);
                break;
            case "edit":
                actionEdit(request, response);
                break;
            case "save":
                actionSave(request, response);
                break;
            case "home":
//                actionHome(request, response);
                request.getRequestDispatcher("/admin/employee.jsp").forward(request, response);
                break;
            default:
                request.getRequestDispatcher("/admin/employee.jsp").forward(request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        List<User> employeeList = EmployeeBS.getAll();
        request.setAttribute("employeeList", employeeList);

        User BestEmployeeByPrice = EmployeeBS.BestEmployeeByPrice();
        request.setAttribute("BestEmployeeByPrice", BestEmployeeByPrice);

        User BestEmployeeByBooks = EmployeeBS.BestEmployeeByBooks();
        request.setAttribute("BestEmployeeByBooks", BestEmployeeByBooks);
        // Lấy action của người dùng
        String action = request.getParameter("action");
        if (action == null) {
            action = new String("home");
        }
        switch (action) {
            case "insert":
                actionInsert(request, response);
                break;
            case "edit":
                actionEdit(request, response);
                break;
            case "save":
                actionSave(request, response);
                break;
            case "delete":
                actionDelete(request, response);
                break;
            case "home":
//                actionHome(request, response);
                request.getRequestDispatcher("/admin/employee.jsp").forward(request, response);
                break;
            default:
                request.getRequestDispatcher("/admin/employee.jsp").forward(request, response);
                break;
        }
    }

    protected void actionInsert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        request.setAttribute("action", "insert");
        request.getRequestDispatcher("/admin/employee-form.jsp").forward(request, response);
    }

    protected void actionEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        request.setAttribute("action", "edit");
        String eID = request.getParameter("employeeID");
//        Lấy employee có id tương ứng ra
        User selectedEmployee = UserDAO.find(Integer.parseInt(eID));
        request.setAttribute("employee", selectedEmployee);
        request.getRequestDispatcher("/admin/employee-form.jsp").forward(request, response);
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
            user.setIsRole(2);
            user.setActive(true);

//            Kiểm tra dữ liệu đầu vào đang được lưu trong book
//            Nêu dữ liệu chưa hợp lệ
            if (!"OK".equals(EmployeeBS.CheckInputData(user))) {
                request.setAttribute("employee", user);
                request.setAttribute("message", EmployeeBS.CheckInputData(user));
                request.getRequestDispatcher("/admin/employee-form.jsp").forward(request, response);
            }
//            Nếu dữ liệu hợp lệ
            else {
//              Kiểm tra xem có ID chưa, nếu chưa là thêm mới, nếu có là cập nhật
//              Đang thêm nhân viên mới
                if (user.getId() == 0) {
//                  Kiểm tra xem một số thông tin phải là unique
//                  Nếu số điện thoại đã tồn tại
                    if (!"OK".equals(EmployeeBS.CheckPhoneAvailable(user))) {
                        request.setAttribute("employee", user);
                        request.setAttribute("message", EmployeeBS.CheckPhoneAvailable(user));
                        request.getRequestDispatcher("/admin/employee-form.jsp").forward(request, response);
                    }
//                    Nếu email đã tồn tại
                    else if (!"OK".equals(EmployeeBS.CheckEmailAvailable(user))) {
                        request.setAttribute("employee", user);
                        request.setAttribute("message", EmployeeBS.CheckPhoneAvailable(user));
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
                    String message = new String("Vừa cập nhật nhân viên <b>" + user.getName() + "</b>");
                    request.setAttribute("message", message);
                    List<User> employeeList = EmployeeBS.getAll();
                    request.setAttribute("employeeList", employeeList);
                    request.getRequestDispatcher("/admin/employee.jsp").forward(request, response);
                }
            }
        }
    }

    protected void actionDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        Thêm tiếng việt
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
//        Lấy id của product được truyền xuống nè
        String eID = request.getParameter("employeeID");
//        Lấy product có id tương ứng ra
        User selectedUser = UserDAO.find(Integer.parseInt(eID));
        String message;
        if (selectedUser != null && EmployeeBS.totalOrder(selectedUser) == 0) {
            message = new String("Vừa xóa nhân viên <b>" + selectedUser.getName() + "</b>");
            selectedUser.setActive(false);
            UserDAO.update(selectedUser);
        } else {
            message = new String("Nhân viên <b>" + selectedUser.getName() + "</b> hong thể xóa do có dữ liệu cần dùng!");
        }
        request.setAttribute("message", message);

        List<User> employeeList = EmployeeBS.getAll();
        request.setAttribute("employeeList", employeeList);

        User BestEmployeeByPrice = EmployeeBS.BestEmployeeByPrice();
        request.setAttribute("BestEmployeeByPrice", BestEmployeeByPrice);

        User BestEmployeeByBooks = EmployeeBS.BestEmployeeByBooks();
        request.setAttribute("BestEmployeeByBooks", BestEmployeeByBooks);

        request.getRequestDispatcher("/admin/employee.jsp").forward(request, response);
    }
}
