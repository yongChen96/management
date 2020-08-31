package com.example.commons.exception;

/**
 * @ClassName: BizException
 * @Description: 自定义异常处理类
 * @Author: yongchen
 * @Date: 2020/8/31 10:02
 **/
public class BizException extends RuntimeException {
    private static final long serialVersionUID = -8683144354080746901L;

    protected String msg;
    protected int code;

    public BizException(String message) {
        new BizException(-1, message);
    }

    public BizException(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public BizException(int code, String format, Object... args) {
        this.code = code;
        this.msg = String.format(format, args);
    }

    public String getMsg() {
        return this.msg;
    }
}
