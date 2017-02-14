package com.zemo.util;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: Goods2CreditsUtilsTest
 * @author: SuperZemo
 * @email: zemochen@gmail.com
 * @Date 5/1/16 02:39
 * @Description test of Goods2CreditsUtils
 */
public class Goods2CreditsUtilsTest {

    @Before
    public void initRule(){
        Goods2CreditsUtils.putRule("Silver", 17d);
    }

    @Test
    public void sliverWorth(){
        Double worth = Goods2CreditsUtils.getResult("Silver");
        System.out.println(worth);
    }

    @Test
    public void nothingWorth(){
        Double worth = Goods2CreditsUtils.getResult("");
        System.out.println(worth);
    }
}
