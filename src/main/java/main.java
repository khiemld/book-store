import com.bookstore.dao.CategoryDAO;
import com.bookstore.dao.ProductDAO;
import com.bookstore.dao.UserDAO;
import com.bookstore.entity.Category;
import com.bookstore.entity.Product;
import com.bookstore.entity.User;

import java.util.List;

public class main {
    public static void main(String[] args) {
        UserDAO userDAO = new UserDAO();
        List<User> users = userDAO.getAll();

        for(User u : users){
            System.out.println(u.getName());
        }
}
}
