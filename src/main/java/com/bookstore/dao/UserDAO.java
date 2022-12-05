package com.bookstore.dao;

import com.bookstore.entity.Product;
import com.bookstore.entity.User;
import com.bookstore.utility.HibernateUtility;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class UserDAO {

    public void save(User user){
        Session session = HibernateUtility.getSessionFactory().openSession();
        try{
            session.beginTransaction();
            session.save(user);
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

    public void update(User user){
        Session session = HibernateUtility.getSessionFactory().openSession();
        try{
            session.beginTransaction();
            session.update(user);
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

    public User findById(int id) {
        Session session = HibernateUtility.getSessionFactory().openSession();
        User user = session.load(User.class, id);
        return user;
    }

    public List<User> getAll(){
        // open session
        Session session = HibernateUtility.getSessionFactory().openSession();
        List<User> users= null;
        try {
            // Create query
            final String sqlString = "select u from User u";
            Query query = session.createQuery(sqlString);
            users = query.list();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return users;
    }

    public List<User> searchByName(String name) {
        Session session = HibernateUtility.getSessionFactory().openSession();
        List<User> users= null;
        try {
            // Create query
            final String sqlString = "select u from User u where u.name like :name";
            Query query = session.createQuery(sqlString);
            query.setParameter("name", "%" + name + "%");
            users = query.list();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return users;
    }


    public User testLogin(String email, String password){
        Session session = HibernateUtility.getSessionFactory().openSession();
        List<User> users= null;
        User user = new User();
        try {
            // Create query
            final String sqlString = "select u from User u where u.email = :email and u.password = :password";

            Query query = session.createQuery(sqlString);
            query.setParameter("email", email);
            query.setParameter("password", password);

            users= query.list();
            user = users.get(0);

        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return user;
    }
}
