package com.yummy.entity;

import com.yummy.dao.DistrictDao;
import com.yummy.dao.impl.DistrictDaoImpl;

import java.util.HashMap;
import java.util.Map;

/**
 * @author LuckyH
 * @email 2064150592@qq.com
 * @create 2020-09-18 8:49
 */
public class District {
    private final Map<String, Province> provinces = new HashMap<>();
    private final Map<String, Map<String, City>> cities = new HashMap<>();
    private final Map<String, Map<String, County>> counties = new HashMap<>();

    private static volatile District district;
    private static final DistrictDao districtDao = new DistrictDaoImpl();

    private District() {
        init();
    }

    private void init(){
        for (Province province : districtDao.listProvinces()) {
            Map<String, City> cityMap = new HashMap<>();
            for (City city : districtDao.listCitiesByProvinceId(province.getId())) {
                Map<String, County> countyMap = new HashMap<>();
                for (County county : districtDao.listCountiesByCityId(city.getId())) {
                    countyMap.put(county.getId(), county);
                }
                cityMap.put(city.getId(), city);
                this.counties.put(city.getId(), countyMap);
            }
            this.provinces.put(province.getId(), province);
            this.cities.put(province.getId(), cityMap);
        }
    }

    public static District getInstance(){
        if(district == null){
            synchronized (District.class){
                if(district == null)
                    district = new District();
            }
        }
        return district;
    }

    public void reset(){
        init();
    }

    public Map<String, Province> getProvinces(){
        return this.provinces;
    }
    public Map<String, City> getCitiesByProvinceId(String id){
        return this.cities.get(id);
    }
    public Map<String, County> getCountiesByCityId(String id){
        return this.counties.get(id);
    }

}
