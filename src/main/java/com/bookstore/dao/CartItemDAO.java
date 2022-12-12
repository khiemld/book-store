package com.bookstore.dao;

import com.bookstore.entity.CartItem;
import com.bookstore.entity.Product;
import com.bookstore.utility.HibernateUtility;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class CartItemDAO {
    public static void save(CartItem cartItem){
        Session session = HibernateUtility.getSessionFactory().openSession();
        try{
            session.beginTransaction();
            session.save(cartItem);
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

    public static void update(CartItem cartItem){
        Session session = HibernateUtility.getSessionFactory().openSession();
        try{
            session.beginTransaction();
            session.update(cartItem);
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
            CartItem cartItem = session.get(CartItem.class, id);
            if (cartItem != null) {
                session.delete(cartItem);
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


    public static  List<CartItem> getAll(){
        // open session
        Session session = HibernateUtility.getSessionFactory().openSession();
        List<CartItem> cartItems = null;
        try {
            // Create query
            final String sqlString = "select ct from CartItem ct";
            Query query = session.createQuery(sqlString);
            cartItems = query.list();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return cartItems;
    }

    public static  CartItem getCartItemByID(int id){
        Session session = HibernateUtility.getSessionFactory().openSession();
        CartItem cartItem = new CartItem();
        List<CartItem> cartItems= null;
        try {
            // Create query
            final String sqlString = "select c from CartItem c where c.id = :id";

            Query query = session.createQuery(sqlString);
            query.setParameter("id", id);
            cartItems = query.list();
            cartItem = cartItems.get(0);

        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return cartItem;
    }



    public static List<CartItem> testCartItem(int uid, int pid){
        Session session = HibernateUtility.getSessionFactory().openSession();
        List<CartItem> cartItems= null;
        /*CartItem cartItem = null;*/
        try {
            // Create query
            final String sqlString = "select c from CartItem c where c.idUser = :uid and c.idProduct = :pid";

            Query query = session.createQuery(sqlString);
            query.setParameter("uid", uid);
            query.setParameter("pid", pid);

            cartItems= query.list();
            /*cartItem = cartItems.get(0);*/

        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return cartItems;
    }

    public static Product setProductbyID(int id){
        ProductDAO productDAO = new ProductDAO();
        Product product = new Product();
        product = productDAO.getProductByID(id);
        return product;
    }

    public static boolean cartItemExist(CartItem i){
        if(testCartItem(i.getIdUser(), i.getIdProduct()).size() != 0){
            return true;
        }
        else{
            return false;
        }
    }

    public static void addCartItem(CartItem item){
        if(cartItemExist(item)){
            Product product = setProductbyID(item.getIdProduct());
            CartItem i = testCartItem(item.getIdUser(), item.getIdProduct()).get(0);
            i.setQuantity(i.getQuantity() + item.getQuantity());
            i.setPrice(i.getQuantity()*product.getSalePrice());
            i.setProduct(setProductbyID(item.getIdProduct()));
            update(i);

        }
        else {
            save(item);

        }
    }

    public static List<CartItem> getItemListByUId(int uid){
        Session session = HibernateUtility.getSessionFactory().openSession();
        List<CartItem> cartItems = null;
        try {
            // Create query
            final String sqlString = "select c from CartItem c where c.idUser = :uid";
            Query query = session.createQuery(sqlString);
            query.setParameter("uid", uid);
            cartItems = query.list();
        } catch (RuntimeException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return cartItems;
    }

    public static void deleteAll(int uid){
        List<CartItem> cartItems = getItemListByUId(uid);
        for(CartItem i : cartItems){
            if(cartItems.size() >= 0) {
                delete(i.getId());
            }
        }
    }


    public static int totalPrice(List<CartItem> itemList){
        int total = 0;
        for(CartItem i : itemList){
            total += i.getPrice();
        }
        return total;
    }

    public static void RemoveItem(CartItem item){
        if(cartItemExist(item)){
            Product product = setProductbyID(item.getIdProduct());
            CartItem i = testCartItem(item.getIdUser(), item.getIdProduct()).get(0);
            i.setQuantity(i.getQuantity() - 1);
            i.setPrice(i.getQuantity()*product.getSalePrice());
            i.setProduct(setProductbyID(item.getIdProduct()));
            update(i);
        }
    }
}
