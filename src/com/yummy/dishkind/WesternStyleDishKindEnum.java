package com.yummy.dishkind;

/**
 * @author Gp
 * @email 13767654524@163.com
 * @create 2020/9/5 15:41
 * <p>
 * 给经典菜系预留 100 个编号
 */
public enum WesternStyleDishKindEnum {
    JAPAN("日本料理", 201), KOREA("韩国料理", 202), ITALY("意大利菜", 203),
    FRANCE("法国料理", 204), MEXICO("墨西哥菜", 205), GERMANY("德国料理", 206),
    EGYPT("埃及美食", 207), MIDDLE_EAST("中东美食", 208);
    private String name;
    private Integer no;

    WesternStyleDishKindEnum(String name, Integer no) {
        this.name = name;
        this.no = no;
    }

    public static String getDishType(int no) {
        for (WesternStyleDishKindEnum value : values()) {
            if (value.no == no) {
                return value.name;
            }
        }
        throw new IllegalArgumentException("非法菜系标号!");
    }
}
