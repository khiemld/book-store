package com.bookstore.dao;

import com.bookstore.entity.Category;
import com.bookstore.utility.HibernateUtility;
import org.hibernate.HibernateError;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class CategoryDAO {
    public static void save(Category catagory){
        Session session = HibernateUtility.getSessionFactory().openSession();
        try{
            session.beginTransaction();
            session.save(catagory);
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

    public static void update(Category catagory){
        Session session = HibernateUtility.getSessionFactory().openSession();
        try{
            session.beginTransaction();
            session.update(catagory);
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
            Category category = session.get(Category.class, id);
            if (category != null) {
                session.delete(category);
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

    public static Category findById(int id) {
        Session session = HibernateUtility.getSessionFactory().openSession();
        Category category = session.load(Category.class, id);
        return category;
    }

    public static List<Category> findByName(String name) {
        // open session
        Session session = HibernateUtility.getSessionFactory().openSession();
        List<Category> categories = null;
        try {
            // Create query string
            String queryString = "from Category where name like :name";

            // Create query
            Query query = session.createQuery(queryString, Category.class);
            query.setParameter("name", "%" + name + "%");

            // Return result List
            categories = query.list();
        } catch (HibernateError error) {
            System.err.println(error);
        } finally {
            session.close();
        }
        return categories;
    }

    public static List<Category> getAll(){
        // open session
        Session session = HibernateUtility.getSessionFactory().openSession();
        List<Category> categories = null;
        try {
            // Create query
            final String sqlString = "select ct from Category ct";
            Query query = session.createQuery(sqlString);
            categories = query.list();
        } catch (RuntimeException e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return categories;
    }

    public static List<Category> getCategoryByName(String name) {
        // open session
        Session session = HibernateUtility.getSessionFactory().openSession();
        List<Category> categories = null;
        try {
            // Create query string
            String queryString = "from Category where name like :name";

            // Create query
            Query query = session.createQuery(queryString, Category.class);
            query.setParameter("name", name);

            // Return result List
            categories = query.list();
        } catch (HibernateError error) {
            System.err.println(error);
        } finally {
            session.close();
        }
        return categories;
    }

}
