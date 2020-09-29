package com.yummy.controller;

import com.yummy.dao.DishDao;
import com.yummy.entity.Dish;
import com.yummy.entity.Users;
import com.yummy.factory.BeanFactory;
import com.yummy.service.DishService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@WebServlet(name = "dishServlet",urlPatterns = "*.dish")
public class DishServlet extends HttpServlet{
    private DishService dishService;
    public DishServlet(){
        dishService = BeanFactory.getInstance("dishService");
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String servletPath = request.getServletPath();
        if (servletPath.contains("add.dish")) {

        } else if (servletPath.contains("delete.dish")) {
            delete(request, response);
        }else if (servletPath.contains("deleteAll.dish")) {
            deleteAll(request, response);
        }  else if (servletPath.contains("queryAll.dish")) {
            queryAll(request, response);
        } else  if(servletPath.contains("queryByType")){
            queryByType(request,response);
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        doGet(request, response);
    }
    public void queryByType(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("utf-8");
        response.setHeader("Content-type", "text/html;charset=UTF-8");
        response.setCharacterEncoding("utf-8");

        String dishType = request.getParameter("search-sort");
        System.out.println(dishType);
        List<Dish> list = dishService.selectMultipleDish(dishType);
        //System.out.println(JSONArray.fromObject(list));
        if (list.size() != 0) {
            request.getSession().setAttribute("dishList", list);
            response.sendRedirect(request.getContextPath() + "/template/dishsign.jsp");
        } else {
            response.getWriter().write("<script>alert('该菜为空');window.location.href='template/dishsign.jsp'</script>");
        }
    }

    public void queryAll(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("utf-8");
        response.setHeader("Content-type", "text/html;charset=UTF-8");
        response.setCharacterEncoding("utf-8");

        List<Dish> list = dishService.selectAllDish();
        //System.out.println(JSONArray.fromObject(list));
        if (list.size() != 0) {
            request.getSession().setAttribute("dishList", list);
            response.sendRedirect(request.getContextPath() + "/template/dishsign.jsp");
        } else {
            response.getWriter().write("<script>alert('查询为空');window.location.href='template/dishsign.jsp'</script>");
        }
    }

    public void delete(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("utf-8");
        response.setHeader("Content-type", "text/html;charset=UTF-8");
        response.setCharacterEncoding("utf-8");
        String dishid = request.getParameter("dishid");
        boolean flag = dishService.subDish(dishid);
        if(flag){
            //response.getWriter().write("<script>alert('删除成功');window.location.href='template/design.jsp'</script>");
            List<Dish> list = dishService.selectAllDish();
            //System.out.println(JSONArray.fromObject(list));
            if (list.size() != 0) {
                request.getSession().setAttribute("dishList", list);
                response.sendRedirect(request.getContextPath() + "/template/dishsign.jsp");
            } else {
                response.getWriter().write("<script>alert('查询为空');window.location.href='template/dishsign.jsp'</script>");
            }
        }
        else {
            response.getWriter().write("<script>alert('删除失败');window.location.href='template/dishsign.jsp'</script>");
        }
    }
    public void deleteAll(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("utf-8");
        response.setHeader("Content-type", "text/html;charset=UTF-8");
        response.setCharacterEncoding("utf-8");
        //String[] phone = request.getParameter("deleteList");
        String[] dish = request.getParameter("deleteList").split(",");

        System.out.println(Arrays.toString(dish));
        boolean flag = dishService.deleteAllCheck(dish);
        if(flag){
            List<Dish> list = dishService.selectAllDish();
            //System.out.println(JSONArray.fromObject(list));
            if (list.size() != 0) {
                request.getSession().setAttribute("dishList", list);
                response.sendRedirect(request.getContextPath() + "/template/dishsign.jsp");
            } else {
                response.getWriter().write("<script>alert('查询为空');window.location.href='template/dishsign.jsp'</script>");
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
