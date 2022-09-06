package com.polaris.utils;

import java.util.Map;
/**
 * @author polaris
 */
public class QueryParam {
    private Map<String,Object> params;

    public void addParam(String key, Object value){
        params.put(key,value);
    }
    public Map<String,Object> getParams(){
        return params;
    }
}
