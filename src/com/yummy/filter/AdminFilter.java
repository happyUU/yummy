package com.yummy.filter;

import com.yummy.entity.Cart;
import com.yummy.entity.Users;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author xsr
 * @email 2064150592@qq.com
 * @create 2020-09-14 12:46
 */
@WebFilter(urlPatterns = {"/template/*"})
public class AdminFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        if(request.getSession().getAttribute("user") != null){

            filterChain.doFilter(servletRequest, servletResponse);
        }else{
            //System.out.println("用户未登录");

            //模拟登陆
            /*Users users = new Users();
            users.setPhone("0");
            request.getSession().setAttribute("user", users);
            Cart cart = (Cart) request.getSession().getAttribute("cart");
            if(cart == null){
                cart = new Cart();
                request.getSession().setAttribute("cart", cart);
            }
           */
            response.sendRedirect(request.getContextPath() + "/login.jsp");
        }

    }
}
