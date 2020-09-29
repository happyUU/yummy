package com.yummy.controller;

import com.yummy.entity.Users;
import com.yummy.factory.BeanFactory;
import com.yummy.service.UserService;
import com.yummy.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.servlet.jsp.PageContext;
import java.io.IOException;


@WebServlet(name = "UserServlet",urlPatterns = {"*.action"})
public class UserServlet extends HttpServlet {
    private UserService userService;

    public UserServlet() {
        userService = BeanFactory.getInstance("userService");
        //userService = UserServiceImpl.getUserService();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String servletPath = request.getServletPath();
        //System.out.println(servletPath);
        if (servletPath.contains("register.action")) {
            register(request, response);
        } else if (servletPath.contains("login.action")) {
            login(request, response);
        } else if (servletPath.contains("update.action")) {
            updateMess(request,response);
        } else if(servletPath.contains("cancel.action")){
            cancel(request,response);
        }else if (servletPath.contains("delete.action")) {
            // delete(request, response);
        } else if (servletPath.contains("queryall.action")) {
            // queryall(request, response);
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        doGet(request, response);
    }

    public void register(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("utf-8");
        response.setHeader("Content-type", "text/html;charset=UTF-8");
        response.setCharacterEncoding("utf-8");

        Users user = new Users();
        user.setPhone(request.getParameter("phone"));
        user.setPassword(request.getParameter("password"));
        user.setName(request.getParameter("username"));
        user.setEmail(request.getParameter("email"));
        user.setPaypswd(request.getParameter("pPassword"));

        boolean exist = userService.registerCheck(user.getPhone());
        if(exist){ //手机号不存在
            boolean flag = userService.register(user);
            if (flag) {
                response.getWriter().write("<script>alert('注册成功');window.location.href='login.jsp'</script>");
            } else {
                response.getWriter().write("<script>alert('注册失败');window.location.href='register.jsp'</script>");
            }
        }else{
            response.getWriter().write("<script>alert('号码已存在');window.location.href='register.jsp'</script>");
        }

    }

    public void login(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("utf-8");
        response.setHeader("Content-type", "text/html;charset=UTF-8");
        response.setCharacterEncoding("utf-8");
        String phone = request.getParameter("phone");
        String password = request.getParameter("password");
        String rem = request.getParameter("rem");

        //System.out.println("login:" + phone + "  : " + password);
        Users user = userService.login(phone, password);
        String path = request.getContextPath();
        /*String realPath = request.getServletPath();
        System.out.println(path+" :  "+realPath);*/
        if (user != null) {
            if ("check".equals(rem)) {
                StringBuffer sb = new StringBuffer(phone + "-" + password);
                //System.out.println(sb);
                Cookie usercookie = new Cookie("userMess", sb.toString());
                response.addCookie(usercookie);

            }
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            //request.getRequestDispatcher("index.jsp").forward(request, response);
            response.sendRedirect("index.jsp");
        } else {
            response.getWriter().write("<script>alert('登录失败');window.location.href='login.jsp'</script>");
            //response.sendRedirect("/template/login.jsp");window.location.href='"+path+"'/template.login.jsp'
            //request.getRequestDispatcher("/template/login.jsp").forward(request,response);
            //response.sendRedirect(request.getContextPath()+"/template/login.jsp");
        }
    }

    public void updateMess(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("utf-8");
        response.setHeader("Content-type", "text/html;charset=UTF-8");
        response.setCharacterEncoding("utf-8");

        Users user = new Users();
        user.setPhone(request.getParameter("phone"));
        user.setPassword(request.getParameter("password"));
        user.setName(request.getParameter("name"));
        user.setEmail(request.getParameter("email"));
        user.setPaypswd(request.getParameter("pPassword"));

        boolean flag = userService.update(user);
        if(flag){
            request.getRequestDispatcher("/template/user.jsp").forward(request,response);
        }else {
            response.getWriter().write("<script>alert('修改失败');window.location.href='../template/user.jsp'</script>");
        }
    }
    public void cancel(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getSession().removeAttribute("user");
        response.sendRedirect(request.getContextPath()+"/index.jsp");
    }
}
