package com.bookstore.dao;

import com.bookstore.entity.Product;
import com.bookstore.utility.HibernateUtility;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class ProductDAO {
    public void save(Product product){
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

    public void update(Product product){
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

    public void delete(int id) {
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

    public List<Product> getAll(){
        // open session
        Session session = HibernateUtility.getSessionFactory().openSession();
        List<Product> products= null;
        try {
            // Create query
            final String sqlString = "select ct from Product ct";
            Query query = session.createQuery(sqlString);
            products = query.list();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return products;
    }

    public Product getLatestProduct(){
        Session session = HibernateUtility.getSessionFactory().openSession();
        Product product = new Product();
        List<Product> products = null;
        try{
            final String sqlString = "Select p from Product p order by p.id desc";
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

    public List<Product> get4LastestProduct(){
        Session session = HibernateUtility.getSessionFactory().openSession();
        Product product = new Product();
        List<Product> products = null;

//        int num = session.createQuery("select count(id) from Product p where active = 1");

        try{
            final String sqlString = "Select p from Product p order by p.id desc";
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

    public List<Product> getProductByCategoryID(int cateID){
        Session session = HibernateUtility.getSessionFactory().openSession();
        List<Product> products= null;
        try {
            // Create query
            final String sqlString = "select p from Product p where p.idCategory = :cateID";

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

    public Product getProductByID(int productID){
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

    public List<Product> searchByName(String name) {
        Session session = HibernateUtility.getSessionFactory().openSession();
        List<Product> products= null;
        try {
            // Create query
            final String sqlString = "select p from Product p where p.name like :name";
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

    public int getSalePrice(int id){
        int price = 0;
        Product product = getProductByID(id);
        price = product.getSalePrice();
        return price;
    }

    public void updateAfterOrder(int id, int quantity){
        try{
            Product product = getProductByID(id);
            product.setQuantity(product.getQuantity() - quantity);
            update(product);
        }
        catch(RuntimeException e){
            e.printStackTrace();
        }

    }
}


