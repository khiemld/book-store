package com.bookstore.dao;

import com.bookstore.entity.Delivery;
import com.bookstore.utility.HibernateUtility;
import org.hibernate.HibernateError;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class DeliveryDAO {
    public static void save(Delivery delivery){
        Session session = HibernateUtility.getSessionFactory().openSession();
        try{
            session.beginTransaction();
            session.save(delivery);
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

    public static void update(Delivery delivery){
        Session session = HibernateUtility.getSessionFactory().openSession();
        try{
            session.beginTransaction();
            session.update(delivery);
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

    public static void delete(int id) {
        Session session = HibernateUtility.getSessionFactory().openSession();
        try{
            session.beginTransaction();
            Delivery delivery = session.get(Delivery.class, id);
            if (delivery != null) {
                session.delete(delivery);
            }
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



    public static List<Delivery> getAll(){
        // open session
        Session session = HibernateUtility.getSessionFactory().openSession();
        List<Delivery> deliveries = null;
        try {
            // Create query
            final String sqlString = "select d from Delivery d";
            Query query = session.createQuery(sqlString);
            deliveries = query.list();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return deliveries;
    }

    public static Delivery getDeliveryByID(int id){
        Session session = HibernateUtility.getSessionFactory().openSession();
        Delivery delivery = new Delivery();
        List<Delivery> deliveries = null;
        try{
            final String sqlString = "Select d from Delivery d order by d.id";
            Query query = session.createQuery(sqlString);
            deliveries = query.list();
            delivery = deliveries.get(0);
        }
        catch(RuntimeException e){
            e.printStackTrace();
        } finally {
            session.close();
        }
        return delivery;
    }

    public static int getPayDelivery(int id){
        int fee = 0;
        Delivery delivery = getDeliveryByID(id);
        if(delivery.getName()!=null){
            fee = delivery.getShipFee();
        }
        return fee;
    }

    public static List<Delivery> getDeliveryByName(String name) {
        // open session
        Session session = HibernateUtility.getSessionFactory().openSession();
        List<Delivery> deliveries = null;
        try {
            // Create query string
            String queryString = "from Delivery where name like :name";

            // Create query
            Query query = session.createQuery(queryString, Delivery.class);
            query.setParameter("name", name);

            // Return result List
            deliveries = query.list();
        } catch (HibernateError error) {
            System.err.println(error);
        } finally {
            session.close();
        }
        return deliveries;
    }
}
