package com.bookstore.admin.controller;

import com.bookstore.admin.business.CategoryBS;
import com.bookstore.dao.CategoryDAO;
import com.bookstore.entity.Category;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CategoryServlet", value = "/admin/category")
public class CategoryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Category> categoryList = CategoryDAO.getAll();
        request.setAttribute("categoryList", categoryList);

        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
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
                request.getRequestDispatcher("/admin/category.jsp").forward(request, response);
                break;
            default:
                request.getRequestDispatcher("/admin/category.jsp").forward(request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Category> categoryList = CategoryDAO.getAll();
        request.setAttribute("categoryList", categoryList);

        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
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
                request.getRequestDispatcher("/admin/category.jsp").forward(request, response);
                break;
            default:
                request.getRequestDispatcher("/admin/category.jsp").forward(request, response);
                break;
        }
    }

    protected void actionInsert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        request.setAttribute("action", "insert");
        request.getRequestDispatcher("/admin/category-form.jsp").forward(request, response);
    }

    protected void actionEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        request.setAttribute("action", "edit");
        String cID = request.getParameter("categoryID");
//        Lấy delivery có id tương ứng ra
        Category selectedCategory = CategoryDAO.findById(Integer.parseInt(cID));
        request.setAttribute("category", selectedCategory);
        request.getRequestDispatcher("/admin/category-form.jsp").forward(request, response);
    }

    protected void actionSave(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        String cID = request.getParameter("cID");
        String cName = request.getParameter("categoryName");

//        Kiểm tra người dùng có nhập dữ liệu vào hay chưa
        if (!cName.trim().equals("")) {
//            Thực hiện kiểm tra dữ liệu vào

//            Tạo một đối tượng Product để lưu dữ liệu
            Category category = new Category();
            if (!cID.equals("")) {
                category.setId(Integer.parseInt(cID));
            }
            category.setName(cName);

//          Kiểm tra xem có ID chưa, nếu chưa là thêm mới, nếu có là cập nhật
            if (category.getId() == 0) {
                request.setAttribute("action", "insert");
                request.setAttribute("category", category);
//                  Kiểm tra xem một số thông tin phải là unique
//              Nếu số tên đã tồn tại
                if (!"OK".equals(CategoryBS.CheckNameAvailable(category))) {
                    request.setAttribute("message", CategoryBS.CheckNameAvailable(category));
                    request.getRequestDispatcher("/admin/category-form.jsp").forward(request, response);
                }
//              Nếu là tên mới
                else {
                    CategoryDAO.save(category);
                    String message = new String("Vừa thêm loại sách <b>" + category.getName() + "</b>");
                    request.setAttribute("message", message);

                    List<Category> categoryList = CategoryDAO.getAll();
                    request.setAttribute("categoryList", categoryList);
                    request.getRequestDispatcher("/admin/category.jsp").forward(request, response);
                }
            }
//          Đang cập nhật sách
            else {
                CategoryDAO.update(category);
                String message = new String("Vừa cập nhật loại sách <b>" + category.getName() + "</b>");
                request.setAttribute("message", message);

                List<Category> categoryList = CategoryDAO.getAll();
                request.setAttribute("categoryList", categoryList);
                request.getRequestDispatcher("/admin/category.jsp").forward(request, response);
            }
        }
    }

    protected void actionDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        Thêm tiếng việt
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
//        Lấy id của delivery được truyền xuống nè
        String cID = request.getParameter("categoryID");
//        Lấy product có id tương ứng ra
        Category selectedCategory = CategoryDAO.findById(Integer.parseInt(cID));
        String message;

        if (CategoryBS.totalProduct(selectedCategory) == 0) {
            message = new String("Vừa xóa loại sách <b>" + selectedCategory.getName() + "</b>");
            CategoryDAO.delete(selectedCategory.getId());
        } else {
            message = new String("Loại sách <b>" + selectedCategory.getName() + "</b> hong thể xóa do có dữ liệu cần dùng!");
        }
        request.setAttribute("message", message);

        List<Category> categoryList = CategoryDAO.getAll();
        request.setAttribute("categoryList", categoryList);

        request.getRequestDispatcher("/admin/category.jsp").forward(request, response);
    }

}
