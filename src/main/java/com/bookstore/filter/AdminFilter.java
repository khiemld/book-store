package com.bookstore.filter;

import com.bookstore.entity.User;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "AdminFilter")
public class AdminFilter implements Filter {
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
        if (url.startsWith("/admin")) {
            HttpSession session = request.getSession();
            User user = (User) session.getAttribute("acc");
            if (user == null) {
                response.sendRedirect("/login");
            } else {
                if (user.getIsRole() == 1) {
                    chain.doFilter(request, response);
                    System.out.println("do chain");
                } else if (user.getIsRole() == 3) {
                    String error = new String("manager-only");
                    System.out.println("đăng nhập lại");
                    response.sendRedirect("/login?error=" + error);
                } else {
                    if(url.startsWith("/admin/order") || url.startsWith("/admin/customer") || url.equals("/admin")){
                        chain.doFilter(request, response);
                    }
                    else{
                        String error = new String("admin-only");
                        System.out.println("đăng nhập lại");
                        response.sendRedirect("/login?error=" + error);
                    }
                }
            }
        }
    }
}
