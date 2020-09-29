package com.yummy.dao.impl;

import com.yummy.dao.DistrictDao;
import com.yummy.entity.City;
import com.yummy.entity.County;
import com.yummy.entity.Province;

import java.util.List;

/**
 * @author LuckyH
 * @email 2064150592@qq.com
 * @create 2020-09-18 9:18
 */
public class DistrictDaoImpl extends BaseDao implements DistrictDao {

    @Override
    public List<Province> listProvinces() {
        String sql = "SELECT `id` `id`,`name` `name` FROM `tb_province`";
        return listInstances(Province.class, sql);
    }

    @Override
    public List<City> listCitiesByProvinceId(String id) {
        String sql = "SELECT `id` `id`,`name` `name`, `province_id` 'provinceId' FROM `tb_city` WHERE `province_id`=?";
        return listInstances(City.class, sql, id);
    }

    @Override
    public List<County> listCountiesByCityId(String id) {
        String sql = "SELECT `id` `id`,`name` `name`, `city_id` 'cityId' FROM `tb_county` WHERE `city_id`=?";
        return listInstances(County.class, sql, id);
    }

    @Override
    public Province getProvinceById(String id) {
        String sql = "SELECT`id` `id`, `name` `name` FROM `tb_province` WHERE `id`=?";
        return getInstance(Province.class, sql, id);
    }

    @Override
    public City getCityByProvinceId(String id) {
        String sql = "SELECT`id` `id`, `name` `name`, `province_id` `provinceId` FROM `tb_city` WHERE `province_id`=?";
        return getInstance(City.class, sql, id);
    }

    @Override
    public County getCountyByCityId(String id) {
        String sql = "SELECT`id` `id`, `name` `name`, `city_id` `cityId` FROM `tb_county` WHERE `city_id`=?";
        return getInstance(County.class, sql, id);
    }
}
