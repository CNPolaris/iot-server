package com.polaris.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: polaris
 */

public enum StatusTypeEnum {
    YES(0, "有效"),
    NO(1, "无效");
    int code;
    String name;
    StatusTypeEnum(int code, String name) {
        this.code = code;
        this.name = name;
    }
    private static final Map<Integer, StatusTypeEnum> KEY_MAP = new HashMap<>();
    static {
        for (StatusTypeEnum item : StatusTypeEnum.values()) {
            KEY_MAP.put(item.getCode(), item);
        }
    }
    public static StatusTypeEnum fromCode(Integer code) {
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
