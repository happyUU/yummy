package com.yummy.service.impl;


import com.yummy.dao.IFoodDao;
import com.yummy.dao.impl.FoodDaoImpl;
import com.yummy.factory.BeanFactory;
import com.yummy.entity.Food;
import com.yummy.entity.Hall;
import com.yummy.service.IFoodService;

import java.util.List;

public class FoodServiceImpl implements IFoodService {
    private IFoodDao ifoodDao=new FoodDaoImpl();

    public FoodServiceImpl(){
        ifoodDao= BeanFactory.getInstance("fooddao");
    }

    public List<Food> getAllFoods() {
        return ifoodDao.findAllFoods();
    }
    public List<Food> getByTypeName(String foodName){ return ifoodDao.findByTypeName(foodName); }
    public Food getFoodById(String foodid){return ifoodDao.findById(foodid);  }


    public List<Hall> findAllHalls() {
        return ifoodDao.findAllHalls();
    }
    public List<Hall> findByHalllName(String hallName) {
        return ifoodDao.findByHalllName(hallName);
    }
    public List<Hall> findByHallId(String hallid) {
        return ifoodDao.findByHallId(hallid);
    }
    public Hall findHallByHallId(String hallid){ return ifoodDao.findHallByHallId(hallid); }
}
