package com.bookstore.dao;

import com.bookstore.entity.User;
import com.bookstore.utility.HibernateUtility;
import org.hibernate.HibernateError;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.hibernate.type.StandardBasicTypes;

import java.util.List;

public class UserDAO {

    public static void save(User user){
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

    public static void update(User user){
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
            session.close();
        }
    }

    /*public User findById(int id) {
        Session session = HibernateUtility.getSessionFactory().openSession();
        User user = session.load(User.class, id);
        return user;
    }*/

    public static User findByEmail(String email){
        Session session = HibernateUtility.getSessionFactory().openSession();
        User user = new User();
        List<User> users = null;

        try {
            final String sqlString = "Select u from User u where u.email = :email";
            Query query = session.createQuery(sqlString);
            query.setParameter("email", email);
            users = query.list();
            user = users.get(0);
            System.out.println("user is" + user.getEmail());
        }
        catch(RuntimeException e){
            e.printStackTrace();
        } finally {
            session.close();
        }
        return user;
    }

    public static List<User> findListUserByEmail(String email) {
        // open session
        Session session = HibernateUtility.getSessionFactory().openSession();
        List<User> users = null;
        try {
            // Create query string
            String queryString = "from User where email like :email and active=true";

            // Create query
            Query query = session.createQuery(queryString, User.class);
            query.setParameter("email", email);

            // Return result List
            users = query.list();
        } catch (HibernateError error) {
            System.err.println(error);
        } finally {
            session.close();
        }
        return users;
    }

    public static List<User> getAll(){
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

    public static List<User> searchByName(String name) {
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

    public static User testLogin(String email, String password){
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
    public static  User getLastestUser(){
        Session session = HibernateUtility.getSessionFactory().openSession();
        User user = new User();
        List<User> users = null;

        try {
            final String sqlString = "Select u from User u order by u.id desc";
            Query query = session.createQuery(sqlString);
            users = query.list();
            user = users.get(0);
        }
        catch(RuntimeException e){
            e.printStackTrace();
        } finally {
            session.close();
        }
        return user;
    }
    public static boolean isExistEmail(String email){
        boolean result = false;

        Session session = HibernateUtility.getSessionFactory().openSession();
        User user = new User();
        try {
            final String sqlString = "Select COUNT(email) AS num From User u WHERE u.email = :email";
            Query query = session.createNativeQuery(sqlString).addScalar("num", StandardBasicTypes.INTEGER);
            query.setParameter("email", email);
            int num = (int) query.uniqueResult();
            System.out.println("Số email: " + num);
            if(num != 0){
                result = true;
            }
        }
        catch(RuntimeException e){
            e.printStackTrace();
        } finally {
            session.close();
        }
        return result;
    }

    public static boolean isExistPhone(String phone){
        boolean result = false;

        Session session = HibernateUtility.getSessionFactory().openSession();
        User user = new User();
        try {
            final String sqlString = "Select COUNT(phone) AS num From User u WHERE u.phone = :phone";
            Query query = session.createNativeQuery(sqlString).addScalar("num", StandardBasicTypes.INTEGER);
            query.setParameter("phone", phone);
            int num = (int) query.uniqueResult();
            System.out.println("Số phone: " + num);
            if(num != 0){
                result = true;
            }
        }
        catch(RuntimeException e){
            e.printStackTrace();
        } finally {
            session.close();
        }
        return result;
    }

    public static User find(int id) {
        // open session
        Session session = HibernateUtility.getSessionFactory().openSession();
        User user = null;
        try {
            if (id != 0) {
                // Return result List
                user = session.load(User.class, id);
            }
        } catch (HibernateError error) {
            System.err.println(error);
        } finally {
            session.close();
        }
        return user;
    }

    public static List<User> findByRole(int id) {
        // open session
        Session session = HibernateUtility.getSessionFactory().openSession();
        List<User> users = null;
        try {
            // Create query string
            String queryString = "from User where isRole = :role and active = true";

            // Create query
            Query query = session.createQuery(queryString, User.class);
            query.setParameter("role", id);

            // Return result List
            users = query.list();
        } catch (HibernateError error) {
            System.err.println(error);
        } finally {
            session.close();
        }
        return users;
    }

    public static List<User> findByPhone(String phone) {
        // open session
        Session session = HibernateUtility.getSessionFactory().openSession();
        List<User> users = null;
        try {
            // Create query string
            String queryString = "from User where phone like :phone and active=true";

            // Create query
            Query query = session.createQuery(queryString, User.class);
            query.setParameter("phone", phone);

            // Return result List
            users = query.list();
        } catch (HibernateError error) {
            System.err.println(error);
        } finally {
            session.close();
        }
        return users;
    }



}
