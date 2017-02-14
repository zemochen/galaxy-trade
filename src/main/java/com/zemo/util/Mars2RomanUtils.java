package com.zemo.util;

import com.zemo.commons.StringUtils;


/**
 * @ClassName: Mars2RomanUtils
 * @author: SuperZemo
 * @email: zemochen@gmail.com
 * @Date 5/1/16 00:28
 * @Description The utils for set Mars to Roman rules
 */
public class Mars2RomanUtils extends BaseRule{

    public static void putRule(String key,Character value) {
        if (StringUtils.isNotBlank(key) && value != null) {
            MARS_ROMAN_MAP.put(key, value);
        }
    }

    public static Character getResult(String key) {
        if (checkInBase(key)) {
            return MARS_ROMAN_MAP.get(key);
        } else {
            return null;
        }
    }

    public static boolean checkInBase(String key) {
        if (!MARS_ROMAN_MAP.keySet().contains(key)) {
            System.err.println("I don't know " + key);
            return false;
        }
        return true;
    }
}
