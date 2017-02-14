package com.zemo.util;

import com.zemo.commons.StringUtils;


/**
 * @ClassName: Goods2CreditsUtils
 * @author: SuperZemo
 * @email: zemochen@gmail.com
 * @Date 5/1/16 02:39
 * @Description The utils for set goods to credits rules
 */
public class Goods2CreditsUtils extends BaseRule{


    public static void putRule(String key, Double value) {
        if (value > 0 || StringUtils.isNotBlank(key)) {
            GOODS_CREDITS_MAP.put(key, value);
        }
    }

    /**
     * get how many Credits the goods worth
     * @param key
     * @return {@code null} unknown goods
     */
    public static Double getResult(String key) {
        if (checkInBase(key)) {
            return GOODS_CREDITS_MAP.get(key);
        } else {
            return null;
        }
    }

    public static boolean checkInBase(String key) {
        if (!GOODS_CREDITS_MAP.keySet().contains(key)) {
            System.err.println("I don't know " + key);
            return false;
        }
        return true;
    }

}
