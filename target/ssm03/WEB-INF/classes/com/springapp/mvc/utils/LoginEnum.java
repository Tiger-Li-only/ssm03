package com.springapp.mvc.utils;

import org.apache.commons.lang.StringUtils;

/**
 * Created by Administrator on 2017-09-28 0028.
 */
public enum LoginEnum {
    SUCCESS("1","成功"),
    ERROR("0","失败"),

    LOGIN_ERROR_NO_USER("1000","没有该用户!"),
    LOGIN_ERROR_ERROE_PASSWORD("1001","密码错误!");

    private LoginEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    private String code;

    private String msg;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getIntCode() {
        return Integer.parseInt(code);
    }
    /**
     * 根据枚举码获取枚举
     * @param code 枚举码
     * @return 枚举
     */
    public static final LoginEnum getByCode(String code) {
        if (StringUtils.isBlank(code)) {
            return null;
        }
        for (LoginEnum item : LoginEnum.values()) {
            if (StringUtils.equals(item.getCode(), code)) {
                return item;
            }
        }
        return null;
    }
}
