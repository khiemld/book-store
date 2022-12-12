package com.bookstore.dao;

import com.bookstore.entity.OrderItem;
import com.bookstore.utility.HibernateUtility;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class OrderItemDAO {

    public static void save(OrderItem orderItem){
        Session session = HibernateUtility.getSessionFactory().openSession();
        try{
            session.beginTransaction();
            session.save(orderItem);
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

    public static List<OrderItem> orderItemList(int id){
        Session session = HibernateUtility.getSessionFactory().openSession();
        List<OrderItem> orderItems =  null;
        try {
            // Create query
            final String sqlString = "select o from OrderItem o where o.idOrder = :id";

            Query query = session.createQuery(sqlString);
            query.setParameter("id", id);
            orderItems = query.list();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return orderItems;
    }

    public static List<OrderItem> orderItemListByProduct(int id){
        Session session = HibernateUtility.getSessionFactory().openSession();
        List<OrderItem> orderItems =  null;
        try {
            // Create query
            final String sqlString = "select o from OrderItem o where o.idProduct = :id";

            Query query = session.createQuery(sqlString);
            query.setParameter("id", id);
            orderItems = query.list();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return orderItems;
    }

    public static List<OrderItem> getAll() {
        // open session
        Session session = HibernateUtility.getSessionFactory().openSession();
        List<OrderItem> orderitemEntities = null;
        try {
            // Create query
            final String sqlString = " select ot from OrderItem ot";
            Query query = session.createQuery(sqlString);
            orderitemEntities = query.list();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return orderitemEntities;
    }

}
