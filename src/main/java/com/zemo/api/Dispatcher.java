package com.zemo.api;

import com.zemo.analysis.AnalysisInput;
import com.zemo.commons.StringUtils;

/**
 * @ClassName: Dispatcher
 * @author: SuperZemo
 * @email: zemochen@gmail.com
 * @Date 5/1/16 07:09
 * @Description the controller of analysis input
 */
public class Dispatcher {
    /**
     * dispatch
     * @param sentence
     */
    public static void analysisInput(String sentence) {
        sentence = sentence.replaceAll(" *[^a-zA-Z]*$", "").replaceAll(" {2,}", " ").trim();
        if (StringUtils.isBlank(sentence)) {
            System.out.println("please input something just like:");
            System.out.println("glob is I");
            System.out.println("glob glob Silver is 34 Credits");
            System.out.println("how much is pish tegj glob glob ?");
        } else if(sentence.contains(" is ")){
            boolean result = false;
            String[] sentenceArray = sentence.split(" is ");
            if (sentenceArray.length != 2) {
                System.out.println("I have no idea what you are talking about");
                return;
            }
            if (sentence.startsWith("how")) {
                if (sentence.startsWith("how many ")) {             //how many Credits is glob prok Iron?
                    result = AnalysisInput.analysisQuestionGoods(sentenceArray);
                } else if (sentence.startsWith("how much ")) {      //how much is pish tegj glob glob ?
                    result = AnalysisInput.analysisQuestionMars(sentenceArray);
                }
            } else if (sentence.toLowerCase().endsWith("credits")) {//pish pish Iron is 3910 Credits
                result = AnalysisInput.analysisRuleGoods(sentenceArray);
            } else {                                                //tegj is L
                result = AnalysisInput.analysisRuleMars(sentenceArray);
            }
            if (!result) {
                System.out.println("I have no idea what you are talking about");
            }
        }else {
            System.out.println("I have no idea what you are talking about");
        }
    }
}
