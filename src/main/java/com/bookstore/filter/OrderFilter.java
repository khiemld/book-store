package com.bookstore.filter;

import com.bookstore.dao.CartItemDAO;
import com.bookstore.entity.CartItem;
import com.bookstore.entity.User;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebFilter(filterName = "OrderFilter")
public class OrderFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String url = request.getRequestURI();
        if (url.startsWith("/order")) {
            HttpSession session = request.getSession();
            User user = (User) session.getAttribute("acc");
            if (user == null) {
                response.sendRedirect("/login");
            } else {
                List<CartItem> cartItemList= CartItemDAO.getItemListByUId(user.getId());
                if(cartItemList.size()==0){
                    response.sendRedirect("/home");
                }
                else{
                    chain.doFilter(request, response);
                }
            }
        }
    }
}
