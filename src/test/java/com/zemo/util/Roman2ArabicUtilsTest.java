package com.zemo.util;

import org.junit.Assert;
import org.junit.Test;

/**
 * @ClassName: Roman2ArabicUtilsTest
 * @author: SuperZemo
 * @email: zemochen@gmail.com
 * @Date 4/27/16 19:20
 * @Description The test of Roman2ArabicUtils
 */
public class Roman2ArabicUtilsTest extends BaseRule {


    @Test
    public void com2DecimalTest() {
        Assert.assertEquals((long)Roman2ArabicUtils.getResult("V"), 5L);
        Assert.assertEquals((long)Roman2ArabicUtils.getResult("MCMXLIV"), 1944L);
        Assert.assertEquals(Roman2ArabicUtils.getResult("XXXX"), null);
        Assert.assertEquals(Roman2ArabicUtils.getResult("XXXL"), null);
    }

    @Test
    public void checkRomanNumbersInRulesTest() {
        Assert.assertEquals((long)Roman2ArabicUtils.checkRomanNumbersInRules('P',null,0),-1l);
        Assert.assertEquals((long)Roman2ArabicUtils.checkRomanNumbersInRules('X','X',3),-1l);
    }

    @Test
    public void checkInBaseTest() {
        Assert.assertTrue(Roman2ArabicUtils.checkInBase('V'));
        Assert.assertFalse(Roman2ArabicUtils.checkInBase('P'));
    }


    @Test
    public void canRepeatTest() {
        Assert.assertTrue(Roman2ArabicUtils.canRepeat('I'));
        Assert.assertTrue(Roman2ArabicUtils.canRepeat('X'));
        Assert.assertTrue(Roman2ArabicUtils.canRepeat('C'));
        Assert.assertTrue(Roman2ArabicUtils.canRepeat('M'));
        Assert.assertFalse(Roman2ArabicUtils.canRepeat('D'));
        Assert.assertFalse(Roman2ArabicUtils.canRepeat('L'));
        Assert.assertFalse(Roman2ArabicUtils.canRepeat('V'));
    }


    @Test
    public void calculateTest() {
        Assert.assertEquals(Roman2ArabicUtils.calculate('V','I',1),6);
    }
}
