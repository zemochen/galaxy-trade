package com.zemo.analysis;

import com.zemo.util.Goods2CreditsUtils;
import com.zemo.util.Mars2RomanUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @ClassName: AnalysisInputTest
 * @author: SuperZemo
 * @email: zemochen@gmail.com
 * @Date 2016-05-01 04:56:38
 * @Description analysis the sentence of user input test
 */
public class AnalysisInputTest {

    /**
     * init Mars rules
     */
    @Before
    public void initMars() {
        Mars2RomanUtils.putRule("glob", 'I');
        Mars2RomanUtils.putRule("prok", 'V');
        Mars2RomanUtils.putRule("pish", 'X');
        Goods2CreditsUtils.putRule("Silver", 17d);
    }

    /**
     * analysis "glob glob Silver is 34 Credits"
     */
    @Test
    public void analysisRuleGoodsTest() {
        String sentence = "glob glob Silver is 34 Credits";
        AnalysisInput.analysisRuleGoods(sentence.split(" is "));
        Double result = Goods2CreditsUtils.getResult("Silver");
        Assert.assertEquals(result, new Double(17));
//        System.out.println(result);
    }

    /**
     * analysis "glob is I"
     */
    @Test
    public void analysisMarsTest() {
        String sentence = "tegj is L";
        String sentence1 = "glob is p";
        Assert.assertTrue(AnalysisInput.analysisRuleMars(sentence.split(" is ")));
        Assert.assertFalse(AnalysisInput.analysisRuleMars(sentence1.split(" is ")));
//        System.out.println(Mars2RomanUtils.getResult("tegj"));
//        System.out.println(Mars2RomanUtils.getResult("glob"));
        Assert.assertEquals(Mars2RomanUtils.getResult("tegj").charValue(), 'L');
        Assert.assertEquals(Mars2RomanUtils.getResult("glob").charValue(), 'I');


    }

    /**
     * analysis "how much is pish tegj glob glob ?"
     */
    @Test
    public void analysisQuestionMarsTest() {
        String sentence = "how much is pish tegj glob glob ?";
        sentence = sentence.replaceAll(" *[^a-zA-Z]*$", "");
        String[] sentenceArray = sentence.split(" is ");
        Assert.assertFalse(AnalysisInput.analysisQuestionMars(sentenceArray));
    }

    /**
     * analysis "how many Credits is glob prok Silver ?"
     */
    @Test
    public void analysisQuestionGoodsTest() {
        String sentence = " how  many Credits is  glob prok Silver?  ";
        sentence = sentence.replaceAll(" *[^a-zA-Z]*$", "");
        String[] sentenceArray = sentence.split(" is ");
        Assert.assertTrue(AnalysisInput.analysisQuestionGoods(sentenceArray));

    }

}
