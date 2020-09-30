package com.example.commons.enums;

/**
 * @ClassName: DelStateEnum
 * @Description: 删除标识枚举类
 * @Author: yongchen
 * @Date: 2020/9/2 11:30
 **/
public enum DelStateEnum {
    DEL_STATE_NOT("未删除","0"),
    DEL_STATE_YES("已删除","1");

    private String name;
    private String value;

    DelStateEnum(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
