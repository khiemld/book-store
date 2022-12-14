package com.bookstore.admin.controller;

import com.bookstore.admin.business.ProductBS;
import com.bookstore.dao.CategoryDAO;
import com.bookstore.dao.ProductDAO;
import com.bookstore.entity.Category;
import com.bookstore.entity.Email;
import com.bookstore.entity.Product;
import com.bookstore.utility.EmailUtils;

import javax.mail.MessagingException;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "BookServlet", value = "/admin/book")
public class BookServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> bookList = ProductDAO.getAll();
        List<Category> categoryList = CategoryDAO.getAll();
        int totalBook = ProductBS.totalBook(bookList);
        request.setAttribute("total", totalBook);

        int sellBook = ProductBS.sellBook(bookList);
        request.setAttribute("sell", sellBook);

        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        request.setAttribute("bookList", bookList);
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
                actionHome(request, response);
                break;
            default:
                request.getRequestDispatcher("/admin/book.jsp").forward(request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> bookList = ProductDAO.getAll();
        int totalBook = ProductBS.totalBook(bookList);
        request.setAttribute("total", totalBook);
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        request.setAttribute("bookList", bookList);
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
                actionHome(request, response);
                break;
            default:
                request.getRequestDispatcher("/admin/book.jsp").forward(request, response);
                break;
        }
    }

    protected void actionInsert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Category> categoryList = CategoryDAO.getAll();
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        request.setAttribute("action", "insert");
        request.setAttribute("categoryList", categoryList);
        request.getRequestDispatcher("/admin/book-form.jsp").forward(request, response);
    }

    protected void actionSave(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        List<Category> categoryList = CategoryDAO.getAll();
        request.setAttribute("categoryList", categoryList);

        String pID = request.getParameter("pID");
        String pName = request.getParameter("bookName");
        String pOriginalPrice = request.getParameter("bookOriginalPrice");
        String pSalePrice = request.getParameter("bookSalePrice");
        String pDescription = request.getParameter("bookDescription");
        String pQuantity = request.getParameter("bookQuantity");
        String pCategoryID = request.getParameter("bookCategoryID");
        String pImageLink = request.getParameter("bookImageLink");

//        Ki???m tra ng?????i d??ng c?? nh???p d??? li???u v??o hay ch??a
        if (!pName.trim().equals("") && !pOriginalPrice.trim().equals("") && !pSalePrice.trim().equals("") && !pQuantity.trim().equals("")) {
//            Th???c hi???n ki???m tra d??? li???u v??o

//            T???o m???t ?????i t?????ng Product ????? l??u d??? li???u
            Product book = new Product();
            if (!pID.equals("")) {
                book.setId(Integer.parseInt(pID));
            }
            book.setName(pName);
            book.setOriginalPrice(Integer.parseInt(pOriginalPrice));
            book.setSalePrice(Integer.parseInt(pSalePrice));
            book.setDiscription(pDescription);
            book.setQuantity(Integer.parseInt(pQuantity));
            book.setIdCategory(Integer.parseInt(pCategoryID));
            book.setImage(pImageLink);
            book.setActive(true);

//            Ki???m tra d??? li???u ?????u v??o ??ang ???????c l??u trong book
//            N??u d??? li???u ch??a h???p l???
            if (!"OK".equals(ProductBS.CheckInputData(book))) {
                categoryList = CategoryDAO.getAll();
                request.setAttribute("book", book);
                request.setAttribute("categoryList", categoryList);
                request.setAttribute("message", ProductBS.CheckInputData(book));
                request.getRequestDispatcher("/admin/book-form.jsp").forward(request, response);
            }
//            N???u d??? li???u h???p l???
            else {
//              Ki???m tra xem c?? ID ch??a, n???u ch??a l?? th??m m???i, n???u c?? l?? c???p nh???t
//              ??ang th??m s??ch m???i
                if (book.getId() == 0) {
//                  Ki???m tra xem t??n c?? ch??a
//                  N???u t??n s??ch ???? t???n t???i
                    if (!"OK".equals(ProductBS.CheckNameAvailable(book))) {
                        categoryList = CategoryDAO.getAll();
                        request.setAttribute("book", book);
                        request.setAttribute("categoryList", categoryList);
                        request.setAttribute("message", ProductBS.CheckNameAvailable(book));
                        request.getRequestDispatcher("/admin/book-form.jsp").forward(request, response);
                    }
//                  N???u t??n ch??a t???n t???i
                    else {
                        ProductDAO.save(book);
                        String message = new String("V???a th??m s??ch <b>" + book.getName() + "</b>");
                        request.setAttribute("message", message);
                        List<Product> bookList = ProductDAO.getAll();
                        int totalBook = ProductBS.totalBook(bookList);
                        request.setAttribute("total", totalBook);
                        request.setAttribute("bookList", bookList);
                        int sellBook = ProductBS.sellBook(bookList);
                        request.setAttribute("sell", sellBook);
                        request.getRequestDispatcher("/admin/book.jsp").forward(request, response);
                    }
                }
//                ??ang c???p nh???t s??ch
                else {
                    ProductDAO.update(book);
                    String message = new String("V???a c???p nh???t s??ch <b>" + book.getName() + "</b>");
                    request.setAttribute("message", message);
                    List<Product> bookList = ProductDAO.getAll();

                    request.setAttribute("bookList", bookList);
                    int totalBook = ProductBS.totalBook(bookList);

                    request.setAttribute("total", totalBook);
                    int sellBook = ProductBS.sellBook(bookList);

                    request.setAttribute("sell", sellBook);
                    request.getRequestDispatcher("/admin/book.jsp").forward(request, response);
                }
            }
        }
    }

    protected void actionEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        Th??m ti???ng vi???t
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
//        L???y id c???a product ???????c truy???n xu???ng n??
        String pID = request.getParameter("productID");
//        L???y product c?? id t????ng ???ng ra
        Product selectedBook = ProductDAO.getProductByID(Integer.parseInt(pID));
        request.setAttribute("book", selectedBook);
        request.setAttribute("action", "edit");

        List<Category> categoryList = CategoryDAO.getAll();
        request.setAttribute("categoryList", categoryList);
        request.getRequestDispatcher("/admin/book-form.jsp").forward(request, response);
    }

    protected void actionDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        Th??m ti???ng vi???t
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
//        L???y id c???a product ???????c truy???n xu???ng n??
        String pID = request.getParameter("productID");
//        L???y product c?? id t????ng ???ng ra
        Product selectedBook = ProductDAO.getProductByID(Integer.parseInt(pID));
        String message;
        if (selectedBook != null) {
            message = new String("V???a x??a s??ch <b>" + selectedBook.getName() + "</b>");
            selectedBook.setActive(false);
            ProductDAO.update(selectedBook);
        } else {
            message = new String("S??ch <b>" + selectedBook.getName() + "</b> hong t???n t???i!");
        }
        request.setAttribute("message", message);
        List<Product> bookList = ProductDAO.getAll();
        request.setAttribute("bookList", bookList);
        int totalBook = ProductBS.totalBook(bookList);
        request.setAttribute("total", totalBook);
        List<Category> categoryList = CategoryDAO.getAll();
        request.setAttribute("categoryList", categoryList);
        request.getRequestDispatcher("/admin/book.jsp").forward(request, response);
    }

    protected void actionHome(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        Th??m ti???ng vi???t
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
//        L???y id c???a category ???????c truy???n xu???ng n??
        String cID = request.getParameter("cID");
        Category selectedCategory = new Category();
        List<Category> categoryList = CategoryDAO.getAll();
        request.setAttribute("categoryList", categoryList);
        if (cID == null) {
            cID = "0";
        }
//        L???y product c?? id t????ng ???ng ra
        if (cID.equals("0")) {
            List<Product> bookList = ProductDAO.getAll();
            request.setAttribute("bookList", bookList);
            selectedCategory.setName("To??n b??? s??ch");
            request.setAttribute("category", selectedCategory);
            int totalBook = ProductBS.totalBook(bookList);
            request.setAttribute("total", totalBook);
            int sellBook = ProductBS.sellBook(bookList);
            request.setAttribute("sell", sellBook);
            request.getRequestDispatcher("/admin/book.jsp").forward(request, response);
        } else {
            selectedCategory = CategoryDAO.findById(Integer.parseInt(cID));
            List<Product> bookList = ProductDAO.getProductByCategoryID(Integer.parseInt(cID));
            request.setAttribute("bookList", bookList);
            request.setAttribute("category", selectedCategory);
            int totalBook = ProductBS.totalBook(bookList);
            request.setAttribute("total", totalBook);
            int sellBook = ProductBS.sellBook(bookList);
            request.setAttribute("sell", sellBook);
            request.getRequestDispatcher("/admin/book.jsp").forward(request, response);
        }
    }
}
