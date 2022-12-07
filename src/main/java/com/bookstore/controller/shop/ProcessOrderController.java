package com.bookstore.controller.shop;

import com.bookstore.dao.*;
import com.bookstore.entity.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProcessOrderServlet", value = "/processOrder")
public class ProcessOrderController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        request.setCharacterEncoding("UTF-8");

        String name = request.getParameter("name");
        String address = request.getParameter("address");
        String phone = request.getParameter("phone");
        int idPayment = Integer.parseInt(request.getParameter("payment"));
        int idDelivery = Integer.parseInt(request.getParameter("delivery"));
        int uid = Integer.parseInt(request.getParameter("uid"));

        DeliveryDAO deliveryDAO = new DeliveryDAO();
        Delivery delivery = deliveryDAO.getDeliveryByID(idDelivery);

        PaymentDAO paymentDAO = new PaymentDAO();
        PayMethod payMethod = paymentDAO.getMethodbyID(idPayment);

        OrderDAO orderDAO = new OrderDAO();
        Order order = new Order(uid, phone, address, name, idPayment, idDelivery, 1);

        orderDAO.save(order);
        orderDAO.addOrder(order, uid);

        OrderItemDAO orderItemDAO = new OrderItemDAO();
        List<OrderItem> orderItems = orderItemDAO.orderItemList(order.getId());

        int total = orderDAO.totalOrder(orderItems, order);
        int sum = total - delivery.getShipFee();

        request.setAttribute("order", order);
        request.setAttribute("nameDelivery", delivery.getName());
        request.setAttribute("fee", delivery.getShipFee());
        request.setAttribute("namePay", payMethod.getName());
        request.setAttribute("oid", order.getId());
        request.setAttribute("listOrder", orderItems);
        request.setAttribute("total", total);
        request.setAttribute("sum", sum);
        request.getRequestDispatcher("/store/views/detailOrder.jsp").forward(request, response);
    }
}
