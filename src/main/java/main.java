import com.bookstore.dao.*;
import com.bookstore.entity.*;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class main {
    public static void main(String[] args) {
        Order order = new Order(2, "0982235145", "Đà Nẵng", "Khiem", 1, 1);
        OrderDAO orderDAO = new OrderDAO();
        orderDAO.save(order);

        orderDAO.addOrder(order, 2);

    }
}
