package com.zemo.util;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @ClassName: Mars2RomanUtilsTest
 * @author: SuperZemo
 * @email: zemochen@gmail.com
 * @Date 5/1/16 00:28
 * @Description The test of Mars2RomanUtils
 */
public class Mars2RomanUtilsTest extends BaseRule{

    @Before
    public void putRuleTest() {
        Mars2RomanUtils.putRule("zemo",'V');
    }
    @Test
    public void getValueTest() {
        Assert.assertEquals(Mars2RomanUtils.getResult("zemo").charValue(),'V');
    }

    @Before
    public void checkInBaseTest() {
        Assert.assertTrue(Mars2RomanUtils.checkInBase("zemo"));
    }
}
