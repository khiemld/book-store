package com.bookstore.dao;

import com.bookstore.entity.Product;
import com.bookstore.utility.HibernateUtility;
import org.hibernate.HibernateError;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class ProductDAO {
    public static void save(Product product){
        Session session = HibernateUtility.getSessionFactory().openSession();
        try{
            session.beginTransaction();
            session.save(product);
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

    public static void update(Product product){
        Session session = HibernateUtility.getSessionFactory().openSession();
        try{
            session.beginTransaction();
            session.update(product);
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
            Product product = session.get(Product.class, id);
            if (product != null) {
                session.delete(product);
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

    public static List<Product> getAll(){
        // open session
        Session session = HibernateUtility.getSessionFactory().openSession();
        List<Product> products= null;
        try {
            // Create query
            final String sqlString = "select ct from Product ct where active=true";
            Query query = session.createQuery(sqlString);
            products = query.list();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return products;
    }

    public static Product getLatestProduct(){
        Session session = HibernateUtility.getSessionFactory().openSession();
        Product product = new Product();
        List<Product> products = null;
        try{
            final String sqlString = "Select p from Product p where p.active = true order by p.id desc";
            Query query = session.createQuery(sqlString);
            products = query.list();
            product = products.get(0);
        }
        catch(RuntimeException e){
            e.printStackTrace();
        } finally {
            session.close();
        }
        return product;
    }

    public static List<Product> get4LastestProduct(){
        Session session = HibernateUtility.getSessionFactory().openSession();
        Product product = new Product();
        List<Product> products = null;

//        int num = session.createQuery("select count(id) from Product p where active = 1");

        try{
            final String sqlString = "Select p from Product p where p.active = true order by p.id desc";
            Query query = session.createQuery(sqlString);
            products = query.setMaxResults(4).list();
        }
        catch(RuntimeException e){
            e.printStackTrace();
        } finally {
            session.close();
        }
        return products;
    }

    public static List<Product> get5LastestProduct(){
        Session session = HibernateUtility.getSessionFactory().openSession();
        Product product = new Product();
        List<Product> products = null;

//        int num = session.createQuery("select count(id) from Product p where active = 1");

        try{
            final String sqlString = "Select p from Product p where p.active = true order by p.id desc";
            Query query = session.createQuery(sqlString);
            products = query.setMaxResults(5).list();
        }
        catch(RuntimeException e){
            e.printStackTrace();
        } finally {
            session.close();
        }
        return products;
    }

    public static List<Product> getProductByCategoryID(int cateID){
        Session session = HibernateUtility.getSessionFactory().openSession();
        List<Product> products= null;
        try {
            // Create query
            final String sqlString = "select p from Product p where p.idCategory = :cateID and p.active = true";

            Query query = session.createQuery(sqlString);
            query.setParameter("cateID", cateID);
            products = query.list();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return products;
    }

    public static Product getProductByID(int productID){
        Session session = HibernateUtility.getSessionFactory().openSession();
        Product product = new Product();
        List<Product> products= null;
        try {
            // Create query
            final String sqlString = "select p from Product p where p.id = :productID";

            Query query = session.createQuery(sqlString);
            query.setParameter("productID", productID);
            products = query.list();
            product = products.get(0);

        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return product;
    }

    public static List<Product> searchByName(String name) {
        Session session = HibernateUtility.getSessionFactory().openSession();
        List<Product> products= null;
        try {
            // Create query
            final String sqlString = "select p from Product p where p.name like :name and active = true";
            Query query = session.createQuery(sqlString);
            query.setParameter("name", "%" + name + "%");
            products = query.list();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return products;
    }

    public static int getSalePrice(int id){
        int price = 0;
        Product product = getProductByID(id);
        price = product.getSalePrice();
        return price;
    }

    public static void updateAfterOrder(int id, int quantity){
        try{
            Product product = getProductByID(id);
            product.setQuantity(product.getQuantity() - quantity);
            update(product);
        }
        catch(RuntimeException e){
            e.printStackTrace();
        }

    }

    public static List<Product> searchByname(String name) {
        // open session
        Session session = HibernateUtility.getSessionFactory().openSession();
        List<Product> books = null;
        try {
            // Create query string
            String queryString = "select p from Product p where p.name like :name and p.active=true";

            // Create query
            Query query = session.createQuery(queryString, Product.class);
            query.setParameter("name", "%" + name + "%");

            // Return result List
            books = query.list();
        } catch (HibernateError error) {
            System.err.println(error);
        } finally {
            session.close();
        }
        return books;
    }
}


