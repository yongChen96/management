package com.example.commons.enums;

/**
 * @ClassName: AccStatusEnum
 * @Description: 用户账号状态枚举类
 * @Author: yongchen
 * @Date: 2020/9/1 16:18
 **/
public enum  AccStatusEnum {

    ACC_NORMAL("0","正常"),
    ACC_FREEZE("1","已冻结"),
    ACC_LOGOUT("2","已注销");


    private String code;
    private String name;

    AccStatusEnum(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
