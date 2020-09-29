package com.yummy.dishkind;

/**
 * @author Gp
 * @email 13767654524@163.com
 * @create 2020/9/5 15:40
 * <p>
 * 给每个菜系一个编号, 根据编号可以得到菜系名
 */
public enum ChineseStyleDishKindEnum {
    CHUAN("川菜", 101), LU("鲁菜", 102), YUE("粤菜", 103),
    SU("苏菜", 104), ZHE("浙菜", 105), MIN("闽菜", 106),
    XIANG("湘菜", 107), HUI("徽菜", 108);
    private String name;
    private Integer no;

    ChineseStyleDishKindEnum(String name, Integer no) {
        this.name = name;
        this.no = no;
    }

    /**
     * 对外暴露一个方法, 只需要传入一个菜系编号, 即可返回对应的菜系名
     *
     * @param id
     * @return 如果找不到, 返回 null, 请在调用此方法时做判空操作
     */
    public static String getDishType(int id) {
        for (ChineseStyleDishKindEnum value : values()) {
            if (value.no == id) {
                return value.name;
            }
        }
        throw new IllegalArgumentException("非法菜系标号!");
    }
}
