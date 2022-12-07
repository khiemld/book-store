package com.bookstore.admin.controller;

import com.bookstore.admin.business.*;
import com.bookstore.dao.*;
import com.bookstore.entity.*;
import com.bookstore.util.EmailUtils;

import javax.mail.MessagingException;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Date;
import java.util.List;

@WebServlet(name = "OrderServlet", value = "/admin/order")
public class OrderServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<OrderStatusBS> statusList = OrderBS.statusList();
        request.setAttribute("statusList", statusList);

        List<Order> orderList = OrderDAO.getAll();
        request.setAttribute("orderList", orderList);

        List<Order> waitingConfirmList = OrderDAO.findByStatus(1);
        request.setAttribute("waitingConfirmList", waitingConfirmList);

        List<Order> doneList = OrderDAO.findByStatus(4);
        request.setAttribute("doneList", doneList);
//      Thêm tiếng việt
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        // Lấy action của người dùng
        String action = request.getParameter("action");
        if (action == null) {
            action = new String("home");
        }
        switch (action) {
            case "insert":
//                actionInsert(request, response);
                break;
            case "edit":
                actionEdit(request, response);
                break;
            case "save":
//                actionSave(request, response);
                break;
            case "home":
                actionHome(request, response);
//                request.getRequestDispatcher("/admin/order.jsp").forward(request, response);
                break;
            default:
                request.getRequestDispatcher("/admin/order.jsp").forward(request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<OrderStatusBS> statusList = OrderBS.statusList();
        request.setAttribute("statusList", statusList);

        List<Order> orderList = OrderDAO.getAll();
        request.setAttribute("orderList", orderList);

        List<Order> waitingConfirmList = OrderDAO.findByStatus(1);
        request.setAttribute("waitingConfirmList", waitingConfirmList);

        List<Order> doneList = OrderDAO.findByStatus(4);
        request.setAttribute("doneList", doneList);
//      Thêm tiếng việt
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        // Lấy action của người dùng
        String action = request.getParameter("action");
        if (action == null) {
            action = new String("home");
        }
        switch (action) {
            case "insert":
//                actionInsert(request, response);
                break;
            case "edit":
                actionEdit(request, response);
                break;
            case "save":
                actionSave(request, response);
                break;
            case "confirm":
                actionConfirm(request, response);
                break;
            case "provide":
                actionProvide(request, response);
                break;
            case "cancel":
                actionCancel(request, response);
                break;
            case "home":
                actionHome(request, response);
//                request.getRequestDispatcher("/admin/order.jsp").forward(request, response);
                break;
            default:
                request.getRequestDispatcher("/admin/order.jsp").forward(request, response);
                break;
        }
    }

    protected void actionHome(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        Thêm tiếng việt
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

//        Lấy id của status được truyền xuống nè
        String sID = request.getParameter("sID");
        OrderStatusBS selectedStatus = new OrderStatusBS();
        List<OrderStatusBS> statusList = OrderBS.statusList();
        request.setAttribute("statusList", statusList);

        List<Order> waitingConfirmList = OrderDAO.findByStatus(1);
        request.setAttribute("waitingConfirmList", waitingConfirmList);

        List<Order> doneList = OrderDAO.findByStatus(4);
        request.setAttribute("doneList", doneList);
        if (sID == null) {
            sID = "0";
        }
//        Lấy product có id tương ứng ra
        if (sID.equals("0")) {
            List<Order> orderList = OrderDAO.getAll();
            request.setAttribute("orderList", orderList);
            selectedStatus.setName("Tất cả");
            request.setAttribute("status", selectedStatus);
//            int totalBook= Product.totalBook(bookList);
//            request.setAttribute("total",totalBook);
            request.getRequestDispatcher("/admin/order.jsp").forward(request, response);
        } else {
            selectedStatus = OrderBS.findStatusByID(Integer.parseInt(sID));
            List<Order> orderList = OrderDAO.findByStatus(Integer.parseInt(sID));
            request.setAttribute("orderList", orderList);
            request.setAttribute("status", selectedStatus);
//            int totalBook=Product.totalBook(bookList);
//            request.setAttribute("total",totalBook);
            request.getRequestDispatcher("/admin/order.jsp").forward(request, response);
        }
    }

    protected void actionEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        Thêm tiếng việt
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
//        Lấy id của product được truyền xuống nè
        String oID = request.getParameter("orderID");
//      Lấy product có id tương ứng ra
        Order selectedOrder = OrderDAO.getOrderByIdOrder(Integer.parseInt(oID));
        request.setAttribute("order", selectedOrder);
        request.setAttribute("action", "edit");

        User customer = UserDAO.find(selectedOrder.getIdUser());
        request.setAttribute("customer", customer);

        // Vì order sẽ được xác nhận sau khi nhân viên hoặc admin xác nhận
        if (selectedOrder.getIdSeller() == null) {
            selectedOrder.setIdSeller(0);
        } else {
            User employee = UserDAO.find(selectedOrder.getIdSeller());
            request.setAttribute("employee", employee);
        }

        List<OrderStatusBS> statusList = OrderBS.statusList();
        request.setAttribute("statusList", statusList);

        List<PayMethod> paymethodList = PaymentDAO.getAll();
        request.setAttribute("paymethodList", paymethodList);

        List<Delivery> deliveryList = DeliveryDAO.getAll();
        request.setAttribute("deliveryList", deliveryList);

        List<OrderItem> orderItemList = OrderItemBS.finalOrderItemList(OrderItemDAO.orderItemList(Integer.parseInt(oID)));
        request.setAttribute("orderItemList", orderItemList);
        request.getRequestDispatcher("/admin/order-form.jsp").forward(request, response);
    }

    protected void actionSave(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        String oID = request.getParameter("oID");
        String oReceiveDate = request.getParameter("receiveDate");
        String cIDMethod = request.getParameter("paymethodID");
        String cIDDelivery = request.getParameter("deliveryID");
        String cStatus = request.getParameter("statusID");

//        Kiểm tra người dùng có nhập dữ liệu vào hay chưa
        if (!oID.trim().equals("") && !oReceiveDate.trim().equals("") && !cIDMethod.trim().equals("") && !cIDDelivery.trim().equals("") && !cStatus.trim().equals("")) {
//            Thực hiện kiểm tra dữ liệu vào

//            Tạo một đối tượng Product để lưu dữ liệu
            Order order = new Order();
            order = OrderDAO.getOrderByIdOrder(Integer.parseInt(oID));
            order.setReceiveDate(Date.valueOf(oReceiveDate));
            System.out.println(order.getReceiveDate());
            order.setIdMethod(Integer.parseInt(cIDMethod));
            order.setIdDelivery(Integer.parseInt(cIDDelivery));
            order.setStatus(Integer.parseInt(cStatus));
//            Kiểm tra dữ liệu đầu vào đang được lưu trong book
//            Nêu dữ liệu chưa hợp lệ
            if (!order.getReceiveDate().after(order.getCreateTime())) {
                request.setAttribute("order", order);
                request.setAttribute("action", "edit");

                User customer = UserDAO.find(order.getIdUser());
                request.setAttribute("customer", customer);

                User employee = UserDAO.find(order.getIdSeller());
                request.setAttribute("employee", employee);

                List<OrderStatusBS> statusList = OrderBS.statusList();
                request.setAttribute("statusList", statusList);

                List<PayMethod> paymethodList = PaymentDAO.getAll();
                request.setAttribute("paymethodList", paymethodList);

                List<Delivery> deliveryList = DeliveryDAO.getAll();
                request.setAttribute("deliveryList", deliveryList);

                List<OrderItem> orderItemList = OrderItemBS.finalOrderItemList(OrderItemDAO.orderItemList(Integer.parseInt(oID)));
                request.setAttribute("orderItemList", orderItemList);

                request.setAttribute("message", "Ngày nhận hàng chưa hợp lý! <b>Vui lòng chọn lại ngày nhận hàng dự kiến</b>");
                request.getRequestDispatcher("/admin/order-form.jsp").forward(request, response);
            }
//            Nếu dữ liệu hợp lệ
            else {
                request.setAttribute("action", "edit");
                request.setAttribute("order", order);

                OrderDAO.update(order);
                String message = new String("Vừa cập nhật order số <b>" + order.getId() + "</b>");
                request.setAttribute("message", message);
                List<Order> orderList = OrderDAO.getAll();
                request.setAttribute("orderList", orderList);
                request.getRequestDispatcher("/admin/order.jsp").forward(request, response);
            }

        }
    }

    protected void actionConfirm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        Thêm tiếng việt
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
//      Lấy id của product được truyền xuống nè
        String oID = request.getParameter("orderID");
//      Lấy order có id tương ứng ra
        Order selectedOrder = OrderDAO.getOrderByIdOrder(Integer.parseInt(oID));
        selectedOrder.setStatus(2);

//        Lấy Id của seller mà xác nhận đơn hàng
        HttpSession session = request.getSession();
        User seller = (User) session.getAttribute("acc");
        selectedOrder.setIdSeller(seller.getId());
        OrderDAO.update(selectedOrder);
        List<Order> orderList = OrderDAO.getAll();
        request.setAttribute("orderList", orderList);
        String message = new String("Vừa xác nhận order số <b>" + selectedOrder.getId() + "</b>");
        request.setAttribute("message", message);

//        //  Chỗ này gửi email xác nhận đơn hàng đã được xác nhận
        Email email = new Email();
        email.setFrom("hau.trantrungg@gmail.com");
        email.setFromPassword("rdobhlqlzqazyrrt");
        email.setTo(UserDAO.find(selectedOrder.getIdUser()).getEmail());
        email.setSubject("XÁC NHẬN ĐƠN HÀNG");

        StringBuilder content = new StringBuilder();
        content.append("Thân gửi <b>" + UserDAO.find(selectedOrder.getIdUser()).getName() + "</b><br>");
        content.append("Đại diện <b>Giấy Bookstore</b>, chúng mình xin gửi bạn thông báo đơn hàng của bạn đã được <b style=\"color: #38761D; background-color: #FFF2CC\">XÁC NHẬN</b>");
        content.append(", đang chuẩn bị hàng để chuyển cho đơn vị vận chuyển.<br>Cảm ơn bạn đã tin tưởng và ủng hộ <b>Giấy Bookstore</b>, vui lòng kiểm tra lại đơn hàng của bạn tại mục <b style=\"background-color: #EEEEEE\">Your Profile -> Đơn hàng của tôi</b>");
        content.append("<br>");
        content.append("<br>");
        List<OrderItem> orderItemList = OrderItemDAO.orderItemList(selectedOrder.getId());
        OrderItemBS.finalOrderItemList(orderItemList);
        int count = 1;
        for (OrderItem orderItem : orderItemList) {
            content.append(count + ". " + orderItem.getProduct().getName() + " x " + orderItem.getQuantity() + "<br>");
            count++;
        }
        content.append("<br>");
        content.append("<b>Tổng hóa đơn: " + selectedOrder.getTotalPay() + " </b><br>");
        content.append("Một lần nữa xin cảm ơn bạn rất nhiều!");
        email.setContent(content.toString());
        try {
            EmailUtils.send(email);
        } catch (MessagingException e) {
            message = new String("Vừa xác nhận order số <b>" + selectedOrder.getId() + "</b>, không thể gửi mail xác nhận!");
            request.setAttribute("message", message);
        }

        request.getRequestDispatcher("/admin/order.jsp").forward(request, response);
    }

    protected void actionCancel(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        Thêm tiếng việt
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
//      Lấy id của product được truyền xuống nè
        String oID = request.getParameter("orderID");
//      Lấy product có id tương ứng ra
        Order selectedOrder = OrderDAO.getOrderByIdOrder(Integer.parseInt(oID));
        selectedOrder.setStatus(5);
        OrderDAO.update(selectedOrder);
        List<Order> orderList = OrderDAO.getAll();
        request.setAttribute("orderList", orderList);
        String message = new String("Vừa hủy order số <b>" + selectedOrder.getId() + "</b>");
        request.setAttribute("message", message);
        request.getRequestDispatcher("/admin/order.jsp").forward(request, response);
    }

    protected void actionProvide(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        Thêm tiếng việt
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
//      Lấy id của product được truyền xuống nè
        String oID = request.getParameter("orderID");
//      Lấy product có id tương ứng ra
        Order selectedOrder = OrderDAO.getOrderByIdOrder(Integer.parseInt(oID));
        selectedOrder.setStatus(3);
        OrderDAO.update(selectedOrder);
        List<Order> orderList = OrderDAO.getAll();
        request.setAttribute("orderList", orderList);
        String message = new String("Vừa giao hàng order số <b>" + selectedOrder.getId() + "</b> cho nhà vận chuyển");
        request.setAttribute("message", message);
        request.getRequestDispatcher("/admin/order.jsp").forward(request, response);
    }
}
