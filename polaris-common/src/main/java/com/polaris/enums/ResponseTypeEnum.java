package com.polaris.enums;

import java.util.HashMap;
import java.util.Map;
/**
 * @author polaris
 */
public enum ResponseTypeEnum {
    SUCCESS(1, "success"),
    ERROR(-1,"error");
    int code;
    String name;
    ResponseTypeEnum(int code, String name) {
        this.code = code;
        this.name = name;
    }
    private static final Map<Integer, ResponseTypeEnum> KEY_MAP = new HashMap<>();
    static {
        for (ResponseTypeEnum item : ResponseTypeEnum.values()) {
            KEY_MAP.put(item.getCode(), item);
        }
    }
    public static ResponseTypeEnum fromCode(Integer code) {
        return KEY_MAP.get(code);
    }
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
