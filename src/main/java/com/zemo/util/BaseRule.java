package com.zemo.util;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: BaseRule
 * @author: SuperZemo
 * @email: zemochen@gmail.com
 * @Date 2016-05-30
 * @Description Base Rule of Roman number to Arabic number
 *  =================
 *  |Symbol | Value |
 *  |   I   |   1   |
 *  |   V   |   5   |
 *  |   X   |   10  |
 *  |   L   |   50  |
 *  |   C   |   100 |
 *  |   D   |   500 |
 *  |   M   |   1000|
 *  -----------------
 */
public class BaseRule {

    /**
     * Base rule of the Roman number to Arabic number
     */
    protected static final Map<Character,Integer> BASE_RULE_MAP= new HashMap<Character, Integer>() {
        {
            put('I', 1);
            put('V', 5);
            put('X', 10);
            put('L', 50);
            put('C', 100);
            put('D', 500);
            put('M', 1000);
        }
    };
    protected static final Map<Character,Integer> REPEATABLE_MAP= new HashMap<Character, Integer>() {
        {
            put('I', 1);
            put('X', 10);
            put('C', 100);
            put('M', 1000);
        }
    };

    /**
     * The Map to save how many Credits per-goods
     * eg. "glob glob Silver is 34 Credits"
     */
    protected static Map<String, Double> GOODS_CREDITS_MAP = new HashMap<String, Double>();

    /**
     * The Map to save Mars-Roman
     * Value must be Roman symbol which in the BaseRule.BASE_RULE_MAP
     *  we can let the RULE_MAP<String,Integer>,but I'm worry about the final sentence need check in the Roman-rules
     */
    protected static Map<String, Character> MARS_ROMAN_MAP = new HashMap<String, Character>();
}
