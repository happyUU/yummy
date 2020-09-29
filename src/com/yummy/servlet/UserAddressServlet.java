package com.yummy.servlet;

import com.google.gson.Gson;
import com.yummy.entity.*;
import com.yummy.service.UserAddressService;
import com.yummy.service.impl.UserAddressServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author LuckyH
 * @email 2064150592@qq.com
 * @create 2020-09-18 17:02
 */
@WebServlet(urlPatterns = {"*.userAddress"})
public class UserAddressServlet extends BaseServlet {

    private final UserAddressService userAddressService = new UserAddressServiceImpl();

    protected void getUserAddresses(HttpServletRequest request, HttpServletResponse response) throws Exception{
        Users users = (Users) request.getSession().getAttribute("user");
        String userId = users.getPhone();
        Page<UserAddress> addressPage = userAddressService.page(1, 4, userId);

        response.getWriter().write(new Gson().toJson(addressPage));

    }

    protected void getUserAddress(HttpServletRequest request, HttpServletResponse response) throws Exception{
        String id = request.getParameter("addressId");

        response.getWriter().write(new Gson().toJson(userAddressService.getUserAddressById(id)));

    }

    protected void updateAddress(HttpServletRequest request, HttpServletResponse response) throws Exception{
        District district = District.getInstance();

        String addrId = request.getParameter("addr_id");
        UserAddress address = userAddressService.getUserAddressById(addrId);

        String addrName = request.getParameter("addr_name");
        String addrPhone = request.getParameter("addr_phone");
        String addrProvinceId = request.getParameter("addr_province");
        Province province = district.getProvinces().get(addrProvinceId);
        String addrCityId = request.getParameter("addr_city");
        City city = district.getCitiesByProvinceId(addrProvinceId).get(addrCityId);
        String addrCountyId = request.getParameter("addr_county");
        County county = district.getCountiesByCityId(addrCityId).get(addrCountyId);
        String addrDetail = request.getParameter("addr_detail");
        Users users = (Users) request.getSession().getAttribute("user");
        String userId = users.getPhone();

        address.setRecName(addrName);
        address.setRecPhone(addrPhone);
        address.setProvince(province);
        address.setCity(city);
        address.setCounty(county);
        address.setDetailAddress(addrDetail);

        userAddressService.updateUserAddress(address);

        Page<UserAddress> page = userAddressService.page(1, 4, userId);
        response.getWriter().write(new Gson().toJson(page));

    }

    protected void saveAddress(HttpServletRequest request, HttpServletResponse response) throws Exception{
        District district = District.getInstance();

        String addrName = request.getParameter("addr_name");
        String addrPhone = request.getParameter("addr_phone");
        String addrProvinceId = request.getParameter("addr_province");
        Province province = district.getProvinces().get(addrProvinceId);
        String addrCityId = request.getParameter("addr_city");
        City city = district.getCitiesByProvinceId(addrProvinceId).get(addrCityId);
        String addrCountyId = request.getParameter("addr_county");
        County county = district.getCountiesByCityId(addrCityId).get(addrCountyId);
        String addrDetail = request.getParameter("addr_detail");
        Users users = (Users) request.getSession().getAttribute("user");
        String userId = users.getPhone();

        UserAddress userAddress = new UserAddress(addrName, addrPhone, province, city, county, addrDetail, userId);
        userAddressService.saveUserAddress(userAddress);

        Page<UserAddress> page = userAddressService.page(1, 4, userId);

        response.getWriter().write(new Gson().toJson(page));

    }

    protected void deleteAddress(HttpServletRequest request, HttpServletResponse response) throws Exception{
        String id = request.getParameter("addr_id");
        System.out.println(id);
        Message message;
        if(userAddressService.deleteUserAddressById(id) > 0){
            System.out.println("delete");
            message = Message.success("删除成功");
        }else{
            System.out.println("no delete");
            message = Message.failed("删除失败");
        }
        Users users = (Users) request.getSession().getAttribute("user");
        Page<UserAddress> page = userAddressService.page(1, 4, users.getPhone());

        response.getWriter().write(new Gson().toJson(page));

    }

    protected void getDistrict(HttpServletRequest request, HttpServletResponse response) throws Exception{
        District district = District.getInstance();

        response.getWriter().write(new Gson().toJson(district));
    }

    protected void getProvinces(HttpServletRequest request, HttpServletResponse response) throws Exception{
        District district = District.getInstance();

        response.getWriter().write(new Gson().toJson(district.getProvinces()));
    }
    protected void getCities(HttpServletRequest request, HttpServletResponse response) throws Exception{
        District district = District.getInstance();
        String provinceId = request.getParameter("provinceId");

        response.getWriter().write(new Gson().toJson(district.getCitiesByProvinceId(provinceId)));
    }
    protected void getCounties(HttpServletRequest request, HttpServletResponse response) throws Exception{
        District district = District.getInstance();
        String cityId = request.getParameter("cityId");

        response.getWriter().write(new Gson().toJson(district.getCountiesByCityId(cityId)));
    }
}
