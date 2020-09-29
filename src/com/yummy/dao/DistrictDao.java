package com.yummy.dao;

import com.yummy.entity.City;
import com.yummy.entity.County;
import com.yummy.entity.Province;

import java.util.List;

/**
 * @author LuckyH
 * @email 2064150592@qq.com
 * @create 2020-09-18 9:18
 */
public interface DistrictDao {

    List<Province> listProvinces();

    List<City> listCitiesByProvinceId(String id);

    List<County> listCountiesByCityId(String id);

    Province getProvinceById(String id);

    City getCityByProvinceId(String id);

    County getCountyByCityId(String id);

}
