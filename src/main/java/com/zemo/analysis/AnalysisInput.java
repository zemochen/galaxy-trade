package com.zemo.analysis;

import com.zemo.commons.StringUtils;
import com.zemo.util.Goods2CreditsUtils;
import com.zemo.util.Mars2RomanUtils;
import com.zemo.util.Roman2ArabicUtils;

/**
 * @ClassName: AnalysisInput
 * @author: SuperZemo
 * @email: zemochen@gmail.com
 * @Date 5/1/16 03:13
 * @Description analysis the sentence of user input
 */
public class AnalysisInput {


    /**
     * analysis "A is V"
     * eg. "glob is I"
     * A is the mars , V is the value
     *
     * @param splitIs the rules split by "is"
     * @return
     */
    public static boolean analysisRuleMars(String[] splitIs) {
        String marString = splitIs[0];
        String romanString = splitIs[1];
        //XXX for update the we can use a circulate let the romanString allow be like II
        if (romanString.length() == 1) {
            Character romanSymbol = romanString.toUpperCase().charAt(0);
            if (Roman2ArabicUtils.checkInBase(romanSymbol)) {
                Mars2RomanUtils.putRule(marString, romanSymbol);
                return true;
            }
        } else {
            System.err.println("I don't know " + romanString);
            return false;
        }
        return false;
    }

    /**
     * analysis "mars1 mars2 Goods is 34 Credits"
     * eg. "glob glob Silver is 34 Credits"
     *
     * @param splitIs the sentence split by "is"
     * @return
     */
    public static boolean analysisRuleGoods(String[] splitIs) {
        String goods = "";
        Integer count = 0;
        //glob glob Silver
        String marsGoods = splitIs[0];
        String[] array = marsGoods.split(" ");
        int arrayLength = array.length;
        if (arrayLength >= 2 && array[arrayLength - 1].matches("^[A-Z].*?")) {
            goods = array[arrayLength - 1];
        } else {
            return false;
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i <= arrayLength - 2; i++) {
            String mars = array[i];
            Character romanSymbol = Mars2RomanUtils.getResult(mars);
            if (romanSymbol == null) {
                System.err.println("what is " + mars);
                return false;
            } else {
                sb.append(romanSymbol);
            }
        }
        count = Roman2ArabicUtils.getResult(sb.toString());
        if (count == null) {
            return false;
        }
        String totalCreditsString = splitIs[1];
        String number = totalCreditsString.toLowerCase().replaceAll("credits", "").trim();
        int worth = number.matches("^[1-9]\\d*$") ? Integer.parseInt(number) : 0;
        if (worth > 0 && count > 0) {
            double perPrice = (double) worth / count;
            Goods2CreditsUtils.putRule(goods, perPrice);
            return true;
        }
        return false;
    }

    /**
     * analysis "how much is mars1 mars2 mars3?"
     * eg. "how much is pish tegj glob glob"
     *
     * @param splitIs the sentence split by "is"
     * @return
     */
    public static boolean analysisQuestionMars(String[] splitIs) {
        String marsString = splitIs[1].trim();
        String[] marsWords = marsString.split(" ");
        StringBuffer sb = new StringBuffer();
        for (String marsWord : marsWords) {
            Character romanSymbol = Mars2RomanUtils.getResult(marsWord);
            if (romanSymbol != null) {
                sb.append(Mars2RomanUtils.getResult(marsWord));
            } else {
                return false;
            }
        }
        Integer result = Roman2ArabicUtils.getResult(sb.toString());
        if (result != null) {
            System.out.println(marsString + " is " + result);
        }
        return false;
    }

    /**
     * analysis "how many Credits is mars1 mars2 Goods ?"
     * eg. "how many Credits is glob prok Silver ?"
     *
     * @param splitIs the sentence split by "is"
     * @return
     */
    public static boolean analysisQuestionGoods(String[] splitIs) {
        String marsGoods = splitIs[1].trim();
        String[] array = marsGoods.split(" ");
        int arrayLength = array.length;
        //split Goods name
        String goods = "";
        if (arrayLength >= 2 && array[arrayLength - 1].matches("^[A-Z].*?")) {
            goods = array[arrayLength - 1];
        } else {
            return false;
        }
        //split Roman symbol
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i <= arrayLength - 2; i++) {
            String mars = array[i];
            Character romanSymbol = Mars2RomanUtils.getResult(mars);
            if (romanSymbol != null) {
                sb.append(romanSymbol);
            } else {
                return false;
            }
        }
        Integer count = Roman2ArabicUtils.getResult(sb.toString());
        if (count == null || StringUtils.isBlank(goods)) {
            System.out.println("I have no idea what you are talking about");
            return false;
        } else {
            Double result = Goods2CreditsUtils.getResult(goods);
            if (result != null) {
                result = count * result;
                System.out.println(marsGoods + " is " + Math.round(result) + " Credits");
                return true;
            }
        }
        return false;
    }
}
