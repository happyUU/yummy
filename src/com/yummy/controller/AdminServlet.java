package com.yummy.controller;

import com.yummy.entity.Users;
import com.yummy.factory.BeanFactory;
import com.yummy.service.AdminService;
import net.sf.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@WebServlet(name = "adminServlet" ,urlPatterns = "*.admin")
public class AdminServlet extends HttpServlet {
    private AdminService adminService;

    public AdminServlet() {
        adminService = BeanFactory.getInstance("adminService");
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String servletPath = request.getServletPath();
        if (servletPath.contains("login.admin")) {
            login(request, response);
        } else if (servletPath.contains("register.admin")) {
            register(request, response);
        } else if (servletPath.contains("delete.admin")) {
            delete(request, response);
        }else if (servletPath.contains("deleteAll.admin")) {
            deleteAll(request, response);
        }  else if (servletPath.contains("queryAll.admin")) {
            queryAll(request, response);
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        doGet(request, response);
    }

    public void login(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("utf-8");
        String phone = request.getParameter("phone");
        String password = request.getParameter("password");
        Users user = adminService.login(phone, password);
        if (user.getName() != null) { //首先有用户
            if (user.getAdmin().equals("1") || user.getAdmin().equals("2")) { //admin or superAdmin
                String rem = request.getParameter("rem");
                if ("check".equals(rem)) {
                    StringBuffer sb = new StringBuffer(phone + "-" + password);
                    Cookie cookie = new Cookie("userMess", sb.toString());
                    cookie.setMaxAge(1 * 60);
                }
                HttpSession session = request.getSession();
                session.setAttribute("user", user);
                response.sendRedirect(request.getContextPath() + "/template/admin.jsp");
            } else {
                response.getWriter().write("<script>alert('非管理员'); window.location.href='login.jsp'</script>");
            }
        } else {
            response.getWriter().write("<script>alert('登录失败');window.location.href='login.jsp' </script>");
            request.getRequestDispatcher("/template.login.jsp").forward(request, response);

        }
    }

    public void register(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Users admin = new Users();
        admin.setPhone(request.getParameter("phone"));
        admin.setPassword(request.getParameter("password"));
        admin.setName(request.getParameter("name"));
        admin.setEmail(request.getParameter("email"));
        //admin.setAdmin(request.getParameter("admin"));
        admin.setPaypswd(request.getParameter("pPassword"));

        boolean flag = adminService.register(admin);
        if (flag) {
            request.getRequestDispatcher("/template/login.jsp").forward(request, response);
        } else {
            response.getWriter().write("<script>alert('注册失败')</script>");
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

        boolean flag = adminService.updateMess(user);
        if (flag) {
            request.getRequestDispatcher("/template/user.jsp").forward(request, response);
        } else {
            response.getWriter().write("<script>alert('修改失败');window.location.href='/template/user.jsp'</script>");
        }
    }

    public void queryAll(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("utf-8");
        response.setHeader("Content-type", "text/html;charset=UTF-8");
        response.setCharacterEncoding("utf-8");

        Users user = (Users) request.getSession().getAttribute("user");
        if (user.getAdmin() != null) {
            List<Users> list = adminService.adminQueryAllUsers(user.getAdmin());
            //System.out.println(JSONArray.fromObject(list));
            if (list.size() != 0) {
                request.getSession().setAttribute("userList", list);
                response.sendRedirect(request.getContextPath() + "/template/design.jsp");
            } else {
                response.getWriter().write("<script>alert('查询为空');window.location.href='template/design.jsp'</script>");
            }
        }
    }

    public void delete(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("utf-8");
        response.setHeader("Content-type", "text/html;charset=UTF-8");
        response.setCharacterEncoding("utf-8");
        String phone = request.getParameter("phone");
        System.out.println(phone);
        boolean flag = adminService.deleteUser(phone);
        if(flag){
            //response.getWriter().write("<script>alert('删除成功');window.location.href='template/design.jsp'</script>");
            response.sendRedirect("queryAll.admin");
        }
        else {
            response.getWriter().write("<script>alert('删除失败');window.location.href='template/design.jsp'</script>");
        }
    }
    public void deleteAll(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("utf-8");
        response.setHeader("Content-type", "text/html;charset=UTF-8");
        response.setCharacterEncoding("utf-8");
        //String[] phone = request.getParameter("deleteList");
        String[] phone = request.getParameter("deleteList").split(",");

        System.out.println(Arrays.toString(phone));
        boolean flag = adminService.deleteAllUsers(phone);
        if(flag){
            Users user = (Users) request.getSession().getAttribute("user");
            List<Users> list = adminService.adminQueryAllUsers(user.getAdmin());
            if (list.size() != 0) {
                request.getSession().setAttribute("userList", list);
                response.sendRedirect(request.getContextPath() + "/template/design.jsp");
            } else {
                response.getWriter().write("<script>alert('查询为空');window.location.href='template/design.jsp'</script>");
            }
            //response.getWriter().write("<script>alert('删除成功');window.location.href='template/design.jsp'</script>");
           // request.getRequestDispatcher("quaryAll.admin").forward(request,response);
            //response.sendRedirect(request.getContextPath()+"/quaryAll.admin");
        }
        else {
            response.getWriter().write("<script>alert('删除失败');window.location.href='design.jsp'</script>");
        }
    }
}
