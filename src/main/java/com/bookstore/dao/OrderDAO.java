package com.bookstore.dao;

import com.bookstore.entity.*;
import com.bookstore.utility.HibernateUtility;
import org.hibernate.Session;

import org.hibernate.query.Query;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.List;

public class OrderDAO {
    public void save(Order order){
        Session session = HibernateUtility.getSessionFactory().openSession();
        try{
            session.beginTransaction();
            session.save(order);
            session.getTransaction().commit();
        }
        catch (RuntimeException e){
            session.getTransaction().rollback();
            e.printStackTrace();
        }
        finally {
            session.flush();
            session.close();
        }
    }

    public Order getLatestOrder(){
        Session session = HibernateUtility.getSessionFactory().openSession();
        Order order = new Order();
        List<Order> orders = null;
        try{
            final String sqlString = "Select o from Order o order by o.id desc";
            Query query = session.createQuery(sqlString);
            orders = query.list();
            order = orders.get(0);
        }
        catch(RuntimeException e){
            e.printStackTrace();
        } finally {
            session.close();
        }
        return order;
    }

    public void update(Order order){
        Session session = HibernateUtility.getSessionFactory().openSession();
        try{
            session.beginTransaction();
            session.update(order);
            session.getTransaction().commit();
        }
        catch (RuntimeException e){
            session.getTransaction().rollback();
            e.printStackTrace();
        }
        finally {
            session.flush();
            session.close();
        }
    }

    public  Date receiveDate(Order order) {
        Date dt = order.getCreateTime();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dt);
        int delivery = order.getIdDelivery();
        int deleveryTime = 0;
        switch (delivery) {
            case 1:
                deleveryTime = 4;
                break;
            case 2:
                deleveryTime = 2;
                break;
            default:
                deleveryTime = 3;
                break;
        }
        calendar.add(Calendar.DATE, deleveryTime);
        String newYear = String.valueOf(calendar.get(Calendar.YEAR));
        String newMonth = String.valueOf(calendar.get(Calendar.MONTH) + 1);
        String newDate = String.valueOf(calendar.get(Calendar.DATE));
        String receiveDate = newYear + "-" + newMonth + "-" + newDate;
        Date newdt = Date.valueOf(receiveDate);
        return newdt;
    }


    public void addOrder(Order order, int uid){
        try{
            Order o = getLatestOrder();
            CartItemDAO cartItemDAO = new CartItemDAO();
            List<CartItem> cartItems = cartItemDAO.getItemListByUId(uid);
            OrderItemDAO orderItemDAO = new OrderItemDAO();
            ProductDAO productDAO = new ProductDAO();
            for(CartItem i : cartItems){
                OrderItem orderItem = new OrderItem(o.getId(), i.getIdProduct(), i.getQuantity(), i.getPrice());
                Product product = productDAO.getProductByID(i.getIdProduct());
                orderItem.setProduct(product);
                orderItemDAO.save(orderItem);
                productDAO.updateAfterOrder(i.getIdProduct(), i.getQuantity());
            }

            List<OrderItem> orderItems =orderItemDAO.orderItemList(o.getId());

            int total = totalOrder(orderItems, o);
            o.setTotalPay(total);
            Date date = Date.valueOf(LocalDate.now());
            o.setCreateTime(date);
            o.setReceiveDate(receiveDate(o));
            o.setOrderItems(orderItems);
            update(o);
            cartItemDAO.deleteAll(uid);
        }
        catch(RuntimeException e){
            e.printStackTrace();
        }
    }

    public int totalOrder(List<OrderItem> orderItems, Order order){
        int subTotal = 0;
        int total = 0;
        for(OrderItem o : orderItems){
            subTotal += o.getPrice();
        }
        DeliveryDAO deliveryDAO = new DeliveryDAO();
        int fee = deliveryDAO.getPayDelivery(order.getIdDelivery());
        total = subTotal + fee;
        return total;
    }

    public List<Order> getOrderByIdUer(int uid){
        Session session = HibernateUtility.getSessionFactory().openSession();
        List<Order> orders = null;
        try{
            final String sqlString = "Select o from Order o where  o.idUser = :uid";
            Query query = session.createQuery(sqlString);
            query.setParameter("uid", uid);
            orders = query.list();
        }
        catch(RuntimeException e){
            e.printStackTrace();
        } finally {
            session.close();
        }
        return orders;
    }

    public List<Order> getOrderByIdStatus(int sid){
        Session session = HibernateUtility.getSessionFactory().openSession();
        List<Order> orders = null;
        try{
            final String sqlString = "Select o from Order o where  o.status = :sid";
            Query query = session.createQuery(sqlString);
            query.setParameter("sid", sid);
            orders = query.list();
        }
        catch(RuntimeException e){
            e.printStackTrace();
        } finally {
            session.close();
        }
        return orders;
    }

    public Order getOrderByIdOder(int oid){
        Session session = HibernateUtility.getSessionFactory().openSession();
        Order order = new Order();
        List<Order> orders = null;
        try{
            final String sqlString = "Select o from Order o where  o.id = :oid";
            Query query = session.createQuery(sqlString);
            query.setParameter("oid", oid);
            orders = query.list();
            order = orders.get(0);
        }
        catch(RuntimeException e){
            e.printStackTrace();
        } finally {
            session.close();
        }
        return order;
    }

    public void deleteOrder(int oid){
        OrderItemDAO orderItemDAO = new OrderItemDAO();
        List<OrderItem> orderItems = orderItemDAO.orderItemList(oid);
        for(OrderItem o: orderItems){
            ProductDAO productDAO = new ProductDAO();
            Product product = productDAO.getProductByID(o.getIdProduct());
            product.setQuantity(product.getQuantity() + o.getQuantity());
            productDAO.update(product);
        }
        OrderDAO orderDAO = new OrderDAO();
        Order order = orderDAO.getOrderByIdOder(oid);
        order.setStatus(5);
        update(order);
    }

    public void updateOrderByStatus(int oid){
        OrderDAO orderDAO = new OrderDAO();
        Order order = orderDAO.getOrderByIdOder(oid);
        order.setStatus(4);
        update(order);
    }

}
