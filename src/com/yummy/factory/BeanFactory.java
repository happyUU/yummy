package com.yummy.factory;

import java.util.ResourceBundle;

public class BeanFactory {
    private static ResourceBundle bundle;

    static {
        bundle = ResourceBundle.getBundle("instance");
    }

    public static <T> T getInstance(String key) {
        try {
            Class cls = Class.forName(bundle.getString(key));
            return (T) cls.newInstance();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}
