package com.polaris.utils;

/**
 * @author: polaris
 */

public class PageUtil {
    public static Long getDbPage(Long page, Long limit){
        return (page-1) * limit;
    }
}
