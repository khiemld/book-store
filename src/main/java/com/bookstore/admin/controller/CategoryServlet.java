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
//        L???y delivery c?? id t????ng ???ng ra
        Category selectedCategory = CategoryDAO.findById(Integer.parseInt(cID));
        request.setAttribute("category", selectedCategory);
        request.getRequestDispatcher("/admin/category-form.jsp").forward(request, response);
    }

    protected void actionSave(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        String cID = request.getParameter("cID");
        String cName = request.getParameter("categoryName");

//        Ki???m tra ng?????i d??ng c?? nh???p d??? li???u v??o hay ch??a
        if (!cName.trim().equals("")) {
//            Th???c hi???n ki???m tra d??? li???u v??o

//            T???o m???t ?????i t?????ng Product ????? l??u d??? li???u
            Category category = new Category();
            if (!cID.equals("")) {
                category.setId(Integer.parseInt(cID));
            }
            category.setName(cName);

//          Ki???m tra xem c?? ID ch??a, n???u ch??a l?? th??m m???i, n???u c?? l?? c???p nh???t
            if (category.getId() == 0) {
                request.setAttribute("action", "insert");
                request.setAttribute("category", category);
//                  Ki???m tra xem m???t s??? th??ng tin ph???i l?? unique
//              N???u s??? t??n ???? t???n t???i
                if (!"OK".equals(CategoryBS.CheckNameAvailable(category))) {
                    request.setAttribute("message", CategoryBS.CheckNameAvailable(category));
                    request.getRequestDispatcher("/admin/category-form.jsp").forward(request, response);
                }
//              N???u l?? t??n m???i
                else {
                    CategoryDAO.save(category);
                    String message = new String("V???a th??m lo???i s??ch <b>" + category.getName() + "</b>");
                    request.setAttribute("message", message);

                    List<Category> categoryList = CategoryDAO.getAll();
                    request.setAttribute("categoryList", categoryList);
                    request.getRequestDispatcher("/admin/category.jsp").forward(request, response);
                }
            }
//          ??ang c???p nh???t s??ch
            else {
                CategoryDAO.update(category);
                String message = new String("V???a c???p nh???t lo???i s??ch <b>" + category.getName() + "</b>");
                request.setAttribute("message", message);

                List<Category> categoryList = CategoryDAO.getAll();
                request.setAttribute("categoryList", categoryList);
                request.getRequestDispatcher("/admin/category.jsp").forward(request, response);
            }
        }
    }

    protected void actionDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        Th??m ti???ng vi???t
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
//        L???y id c???a delivery ???????c truy???n xu???ng n??
        String cID = request.getParameter("categoryID");
//        L???y product c?? id t????ng ???ng ra
        Category selectedCategory = CategoryDAO.findById(Integer.parseInt(cID));
        String message;

        if (CategoryBS.totalProduct(selectedCategory) == 0) {
            message = new String("V???a x??a lo???i s??ch <b>" + selectedCategory.getName() + "</b>");
            CategoryDAO.delete(selectedCategory.getId());
        } else {
            message = new String("Lo???i s??ch <b>" + selectedCategory.getName() + "</b> hong th??? x??a do c?? d??? li???u c???n d??ng!");
        }
        request.setAttribute("message", message);

        List<Category> categoryList = CategoryDAO.getAll();
        request.setAttribute("categoryList", categoryList);

        request.getRequestDispatcher("/admin/category.jsp").forward(request, response);
    }

}
