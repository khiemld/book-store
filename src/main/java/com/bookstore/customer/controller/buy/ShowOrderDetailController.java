package com.bookstore.customer.controller.buy;

import com.bookstore.entity.*;
import com.bookstore.dao.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ShowOrderDetailServlet", value = "/showDetail")
public class ShowOrderDetailController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int oid = Integer.parseInt(request.getParameter("oid"));
        OrderItemDAO orderItemDAO = new OrderItemDAO();
        List<OrderItem> orderItems = orderItemDAO.orderItemList(oid);
        OrderDAO orderDAO = new OrderDAO();

        Order order = orderDAO.getOrderByIdOrder(oid);

        DeliveryDAO deliveryDAO = new DeliveryDAO();
        Delivery delivery = deliveryDAO.getDeliveryByID(order.getIdDelivery());

        PaymentDAO paymentDAO = new PaymentDAO();
        PayMethod payMethod = paymentDAO.getMethodbyID(order.getIdMethod());
        int fee = delivery.getShipFee();
        ProductDAO productDAO = new ProductDAO();


        request.setAttribute("order", order);
        request.setAttribute("fee", fee);
        request.setAttribute("nameDelivery", delivery.getName());
        request.setAttribute("namePay", payMethod.getName());
        request.setAttribute("orderItems", orderItems);
        request.getRequestDispatcher("/store/views/showDetailOrder.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
