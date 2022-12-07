package com.bookstore.dao;

import com.bookstore.entity.*;
import com.bookstore.utility.HibernateUtility;
import org.hibernate.Session;

import org.hibernate.query.Query;

import java.sql.SQLException;
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

    public void addOrder(Order order, int uid){
        try{
            Order o = getLatestOrder();
            CartItemDAO cartItemDAO = new CartItemDAO();
            List<CartItem> cartItems = cartItemDAO.getItemListByUId(uid);
            OrderItemDAO orderItemDAO = new OrderItemDAO();
            for(CartItem i : cartItems){
                OrderItem orderItem = new OrderItem(o.getId(), i.getIdProduct(), i.getQuantity(), i.getPrice());

                orderItemDAO.save(orderItem);
                ProductDAO productDAO = new ProductDAO();
                productDAO.updateAfterOrder(i.getIdProduct(), i.getQuantity());
            }


            List<OrderItem> orderItems =orderItemDAO.orderItemList(o.getId());

            int total = totalOrder(orderItems, o);
            o.setTotalPay(total);
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


}
