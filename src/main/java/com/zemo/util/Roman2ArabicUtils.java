package com.zemo.util;

import com.zemo.commons.StringUtils;


/**
 * @ClassName: Roman2ArabicUtils
 * @author: SuperZemo
 * @email: zemochen@gmail.com
 * @Date 4/27/16 19:20
 * @Description The utils for convert Roman numbers to Arabic numbers
 */
public class Roman2ArabicUtils extends BaseRule {


    /**
     * convert the combining Roman numbers
     * Numbers are formed by combining symbols together and adding the values.
     * For example, MMVI is 1000 + 1000 + 5 + 1 = 2006. Generally, symbols are placed in order of value,
     * starting with the largest values. When smaller values precede larger values, the smaller values are
     * subtracted from the larger values, and the result is added to the total.
     * For example MCMXLIV = 1000 + (1000 − 100) + (50 − 10) + (5 − 1) = 1944.
     * ps. we shouldn't worry about that the result of value less than 0,because the larger value always more than triple of the smaller value
     *
     * @param romanString the combining Roman numbers eg:MMVI
     * @return
     */
    public static Integer getResult(String romanString) {
        //TODO here can verify the input whether the romanNumber great than MAX_VALUE of Integer
        Integer result = 0, symbolRepeat = 0;
        Character lastSymbol = null;
        char[] romanSymbols = romanString.toUpperCase().toCharArray();
        int symbolsLength = romanSymbols.length;
        for (int i = symbolsLength - 1; i >= 0; i--) {
            Character romanSymbol = romanSymbols[i];
            //check
            switch (checkRomanNumbersInRules(romanSymbol, lastSymbol, symbolRepeat)) {
                case -1:
                    return null;
                case 0:
                    symbolRepeat = 0;
                    break;
                case 1:
                    symbolRepeat += 1;
                    break;
                default:
                    break;
            }
            result = calculate(romanSymbol, lastSymbol, result);
            lastSymbol = romanSymbol;
        }

        return result;
    }

    /**
     * check whether input is valid
     *
     * @param curSymbol  current symbol
     * @param lastSymbol last symbol
     * @param repeat     repeat times
     * @return 1: repeat += 1
     * 0: repeat = 0
     * -1: error
     */
    public static int checkRomanNumbersInRules(Character curSymbol, Character lastSymbol, int repeat) {

        if (!checkInBase(curSymbol)) return -1;
        if (curSymbol.equals(lastSymbol)) {
            if (!canRepeat(curSymbol) && repeat >= 1) {     //check whether symbol can repeat
                System.err.println(curSymbol + " shouldn't repeat!");
                return -1;
            } else if (repeat >= 3) {    //I,X,C,M just can repeat three times
                System.err.println("I,X,C,M just can repeat three times and follow a smaller value");
                return -1;
            } else {
                return 1;
            }
        } else {//first symbol repeat = 1;
            // They may appear four times if the third and fourth are separated by a smaller value ,
            // so when bigger value just can repeat 2,we start repeat whith 1
            if (lastSymbol == null || BASE_RULE_MAP.get(lastSymbol) > BASE_RULE_MAP.get(curSymbol)) {
                return 1;
            } else {
                return 0;
            }
        }
    }

    public static boolean checkInBase(char romanSymbol) {
        if (!BASE_RULE_MAP.keySet().contains(romanSymbol)) {
            System.err.println("Base Roman number should in {I,V,X,L,C,D,M}");
            return false;
        }
        return true;
    }

    /**
     * check the symbol whether can repeat,just I,X,C,M can repeat
     *
     * @param romanSymbol
     * @return
     */
    public static boolean canRepeat(char romanSymbol) {
        if (!REPEATABLE_MAP.keySet().contains(romanSymbol)) {
            return false;
        }
        return true;
    }

    /**
     * calculate the current value
     *
     * @param curSymbol
     * @param lastSymbol
     * @param lastResult
     * @return
     */
    public static int calculate(Character curSymbol, Character lastSymbol, int lastResult) {
        if (lastSymbol == null) {
            return BASE_RULE_MAP.get(curSymbol);
        } else {
            int curValue = BASE_RULE_MAP.get(curSymbol);
            int lastValue = BASE_RULE_MAP.get(lastSymbol);
            if (curValue < lastValue) {
                return lastResult - curValue;
            } else {
                return lastResult + curValue;
            }
        }
    }
}
