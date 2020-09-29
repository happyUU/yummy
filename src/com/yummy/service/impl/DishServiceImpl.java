package com.yummy.service.impl;

import com.yummy.dao.DishDao;
import com.yummy.entity.Dish;
import com.yummy.factory.BeanFactory;
import com.yummy.service.DishService;

import java.util.List;

/**
 * @author xsr
 * @email 2974112544
 * create time:2020/9/20 07:39
 * a implements to
 */
public class DishServiceImpl implements DishService{
    private DishDao dishDao;

    public DishServiceImpl(){
        dishDao = BeanFactory.getInstance("dishDao");
    }
    /**
     * admin 添加菜品
     * @param dish
     * @return
     */
    @Override
    public boolean addDish(Dish dish) {
        return dishDao.addDish(dish);
    }

    /**
     * admin 删除菜品
     * @param id
     * @return
     */
    @Override
    public boolean subDish(String id) {
        return dishDao.subDish(id);
    }

    /**
     * admin 更新菜品信息
     * @param dish
     * @return
     */
    @Override
    public boolean updateDish(Dish dish) {
        return dishDao.updateDish(dish);
    }

    /**
     * admin 查询单个菜品信息
     * @param id
     * @return
     */
    @Override
    public Dish selectDish(String id) {
        return dishDao.selectDish(id);
    }

    /**
     * admin 查找多个菜品
     * @param name
     * @return
     */
    @Override
    public List<Dish> selectMultipleDish(String name) {
        return dishDao.selectMultipleDish(name);
    }

    /**
     *
     * @return
     */
    @Override
    public List<Dish> selectAllDish() {
        return dishDao.selectAllDish();
    }

    /**
     *
     * @param dish
     * @return
     */
    @Override
    public boolean deleteAllCheck(String[] dish) {
        return dishDao.deleteAllCheck(dish);
    }
}
