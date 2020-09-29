package com.yummy.service;


import com.yummy.entity.Food;
import com.yummy.entity.Hall;

import java.util.List;

public interface IFoodService {


    default List<Food> getAllFoods() {return null; }


    default  List<Food> getByTypeName(String foodName){return null; }

    default Food getFoodById(String foodid){return null; }


    default List<Hall> findAllHalls() {
        return null;
    }

    default List<Hall> findByHalllName(String hallName) {
        return null;
    }

    default List<Hall> findByHallId(String hallid) {
        return null;
    }

    default Hall findHallByHallId(String hallid){
        return null;
    }
}
