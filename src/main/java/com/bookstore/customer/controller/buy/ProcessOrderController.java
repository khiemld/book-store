package com.bookstore.customer.controller.buy;

import com.bookstore.dao.DeliveryDAO;
import com.bookstore.dao.OrderDAO;
import com.bookstore.dao.OrderItemDAO;
import com.bookstore.dao.PaymentDAO;
import com.bookstore.entity.Delivery;
import com.bookstore.entity.Order;
import com.bookstore.entity.OrderItem;
import com.bookstore.entity.PayMethod;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProcessOrderController", value = "/processOrder")
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

       /* DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        String recevieDate = dateFormat.format();
        String orderDate = dateFormat.format(order.getCreateTime());*/
    /*    SimpleDateFormat df=new SimpleDateFormat("dd-MM-yyyy");
        Date sqlDate = );
        String orderDate = .toString();*/

        request.setAttribute("name", name);
        request.setAttribute("address", address);
        request.setAttribute("phone", phone);
        /*request.setAttribute("orderDate",orderDate);*/
        /*request.setAttribute("recieveDate", recevieDate);*/


        request.setAttribute("order", order);
        request.setAttribute("nameDelivery", delivery.getName());
        request.setAttribute("fee", delivery.getShipFee());
        request.setAttribute("namePay", payMethod.getName());
        request.setAttribute("oid", order.getId());
 /*       request.setAttribute("listOrder", orderItems);*/
        request.setAttribute("total", total);
        request.setAttribute("sum", sum);
        request.getRequestDispatcher("/store/views/orderResult.jsp").forward(request, response);
    }
}
