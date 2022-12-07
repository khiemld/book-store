package com.bookstore.dao;

import com.bookstore.entity.Delivery;
import com.bookstore.entity.PayMethod;
import com.bookstore.utility.HibernateUtility;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class PaymentDAO {
    public void save(PayMethod payMethod){
        Session session = HibernateUtility.getSessionFactory().openSession();
        try{
            session.beginTransaction();
            session.save(payMethod);
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

    public void update(PayMethod payMethod){
        Session session = HibernateUtility.getSessionFactory().openSession();
        try{
            session.beginTransaction();
            session.update(payMethod);
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

    public void delete(int id) {
        Session session = HibernateUtility.getSessionFactory().openSession();
        try{
            session.beginTransaction();
            PayMethod payMethod = session.get(PayMethod.class, id);
            if (payMethod != null) {
                session.delete(payMethod);
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


    public List<PayMethod> getAll(){
        // open session
        Session session = HibernateUtility.getSessionFactory().openSession();
        List<PayMethod> payMethods = null;
        try {
            // Create query
            final String sqlString = "select p from PayMethod p";
            Query query = session.createQuery(sqlString);
            payMethods = query.list();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return payMethods;
    }

    public PayMethod getMethodbyID(int id){
        Session session = HibernateUtility.getSessionFactory().openSession();
        PayMethod payMethod = new PayMethod();
        List<PayMethod> payMethods = null;
        try{
            final String sqlString = "Select p from PayMethod p order by p.id";
            Query query = session.createQuery(sqlString);
            payMethods = query.list();
            payMethod = payMethods.get(0);
        }
        catch(RuntimeException e){
            e.printStackTrace();
        } finally {
            session.close();
        }
        return payMethod;
    }
}
