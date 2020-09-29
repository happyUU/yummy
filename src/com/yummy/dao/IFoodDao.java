package com.yummy.dao;

import com.yummy.entity.Food;
import com.yummy.entity.Hall;

import java.util.List;

public interface IFoodDao {

    default List<Food> findAllFoods() {
        return null;
    }

    default List<Food> findByTypeName(String foodName) {
        return null;
    }

    default Food findById(String foodid) {
        return null;
    }



    default List<Hall> findAllHalls() {
        return null;
    }

    default List<Hall> findByHalllName(String hallName) {
        return null;
    }

    default List<Hall> findByHallId(String hallid) {
        return null;
    }
    default Hall findHallByHallId(String hallid){ return null; }


}
