import com.bookstore.dao.*;
import com.bookstore.entity.*;


import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.time.LocalDateTime;

public class main {
    public static void main(String[] args) {

        OrderDAO orderDAO = new OrderDAO();

        Order order = new Order();

        order = orderDAO.getOrderByIdOder(5);

        List<Order> orders = orderDAO.getOrderByIdStatus(2);

        /*for(Order o : orders){
            System.out.println(o.getId());
        }*/

        System.out.println(order.getContactName());


    }
}
