package com.yummy.service;

import com.yummy.entity.Dish;

import java.util.List;

/**
 * @author xsr
 * @email 2974112544
 * admin operate dish
 */
public interface DishService{
    /**
     * admin addDish
     * @param dish
     * return
     */
    default  boolean addDish(Dish dish){
        return false;
    }
    /**
     * admin deleteDish
     * @param id
     * return
     */
    default boolean subDish(String id){
        return false;
    }

    /**
     * admin updateDish
     * @param dish
     * @return
     */
    default boolean updateDish(Dish dish){
        return false;
    }

    /**
     * admin select one Dish
     * @param id
     * @return
     */
    default Dish selectDish(String id){
        return null;
    }

    /**
     * admin select multiple Dish
     * @param
     */
    default List<Dish> selectMultipleDish(String name){
        return null;
    }

    /**
     *
     * @return
     */
    default List<Dish> selectAllDish(){ return null;}

    /**
     *
     * @param dish
     * @return
     */
    default boolean deleteAllCheck(String[] dish){
        return false;
    }
}
