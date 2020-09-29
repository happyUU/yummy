package com.yummy.servlet;

import com.alibaba.fastjson.JSON;
import com.google.gson.JsonArray;
import com.yummy.factory.BeanFactory;
import com.yummy.entity.Food;
import com.yummy.entity.Hall;
import com.yummy.service.IFoodService;
import net.sf.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "food", urlPatterns = {"*.do"})
public class FoodServlet extends HttpServlet {
    private IFoodService foodService;
    public FoodServlet() {
        foodService = BeanFactory.getInstance("foodservice");
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }


    protected void queryall(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Food> list = foodService.getAllFoods();
        request.getSession().setAttribute("allfoods", list);
        /*for (Food fo:list) {
            System.out.println(fo);
        }*/
        String json= JSON.toJSONString(list);
        response.getWriter().print(json);
    }

    private void querybytypename(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String foodName = request.getParameter("name");

        List<Food> list = foodService.getByTypeName(foodName);
        //System.out.println(JSONArray.fromObject(list));
        if(list!=null){
            request.getSession().setAttribute("typefoods", list);
            request.getSession().setAttribute("food1",list.get(0));
            request.getSession().setAttribute("food2",list.get(1));
            request.getSession().setAttribute("food3",list.get(2));
            String json= JSON.toJSONString(list);
            response.getWriter().print(json);
        }else {
            response.getWriter().write("<script>alert('查询为空');window.location.href='/template/recipe.jsp'</script>");
        }


    }
    private void foodsp(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String foodid = request.getParameter("method");
        //System.out.println(foodid);
        Food food= foodService.getFoodById(foodid);
        //System.out.println(food);
        request.getSession().setAttribute("food", food) ;
        response.sendRedirect(request.getContextPath()+"/template/foodsp.jsp");

    }
    private void foodcp(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String foodid = request.getParameter("method");
        //System.out.println(foodid);
        Food food= foodService.getFoodById(foodid);
        //System.out.println(food);
        request.getSession().setAttribute("food", food) ;
        response.sendRedirect(request.getContextPath()+"/template/foodcp.jsp");

    }


    protected void queryhallall(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Hall> list = foodService.findAllHalls();
        request.getSession().setAttribute("allhalls", list);
        /*for (Hall hall:list) {
            System.out.println(hall);
        }*/
        response.sendRedirect(request.getContextPath()+"/template/hall.jsp");

    }

    private void querybyhallname(HttpServletRequest request, HttpServletResponse response) throws IOException {
        /*String foodName = request.getParameter("name");

        List<Food> list = foodService.getByTypeName(foodName);
        request.getSession().setAttribute("typefoods", list);
        request.getSession().setAttribute("food1",list.get(0));
        request.getSession().setAttribute("food2",list.get(1));
        request.getSession().setAttribute("food3",list.get(2));
        String json= JSON.toJSONString(list);
        response.getWriter().print(json);
*/
    }
    private void dining(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String hallid = request.getParameter("method");
        Hall hall=foodService.findHallByHallId(hallid);
        List<Hall> halls= foodService.findByHallId(hallid);
        Food food1=foodService.getFoodById(halls.get(0).getDishid());
        Food food2=foodService.getFoodById(halls.get(1).getDishid());
        Food food3=foodService.getFoodById(halls.get(2).getDishid());

        request.getSession().setAttribute("hall",hall);
        request.getSession().setAttribute("food1",food1);
        request.getSession().setAttribute("food2",food2);
        request.getSession().setAttribute("food3",food3);
        response.sendRedirect(request.getContextPath()+"/template/dining.jsp");
    }






    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=UTF-8");

        String serlvetPath = request.getServletPath();
        /*if (serlvetPath.contains("insert.do")) {
            register(request, response);
        } else if (serlvetPath.contains("update.do")) {
            update(request, response);
        } else*/
        if (serlvetPath.contains("querybytypename.do")) {
            querybytypename(request,response);
        } else if (serlvetPath.contains("queryall.do")) {
            queryall(request, response);
        }else if (serlvetPath.contains("foodsp.do")) {
            foodsp(request, response);
        }else if (serlvetPath.contains("foodcp.do")) {
            foodcp(request, response);
        }

        else if (serlvetPath.contains("querybyhallname.do")) {
            querybyhallname(request, response);
        } else if (serlvetPath.contains("queryhallall.do")) {
            queryhallall(request, response);
        }else if (serlvetPath.contains("dining.do")) {
            dining(request, response);
        }
    }




}
