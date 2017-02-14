package com.zemo.commons;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

/**
 * @ClassName: StringTest
 * @author: SuperZemo
 * @email: zemochen@gmail.com
 * @Date 4/27/16 20:31
 * @Description ${TODO}
 */
public class StringTest {
    private Map<String, String> stringMap = new LinkedHashMap<String, String>();

    @Before
    public void initString(){
        stringMap.put("1", "");
        stringMap.put("2", " ");
        stringMap.put("3", "  ");
        stringMap.put("4", " a ");
        stringMap.put("5", null);
    }

    @Test
    public void isBlankTest(){
        Assert.assertTrue(StringUtils.isBlank(stringMap.get("1")));
        Assert.assertTrue(StringUtils.isBlank(stringMap.get("2")));
        Assert.assertTrue(StringUtils.isBlank(stringMap.get("3")));
        Assert.assertFalse(StringUtils.isBlank(stringMap.get("4")));
        Assert.assertTrue(StringUtils.isBlank(stringMap.get("5")));
    }

    @Test
    public void testIsNotBlank(){
        Assert.assertFalse(StringUtils.isNotBlank(stringMap.get("1")));
        Assert.assertFalse(StringUtils.isNotBlank(stringMap.get("2")));
        Assert.assertFalse(StringUtils.isNotBlank(stringMap.get("3")));
        Assert.assertTrue(StringUtils.isNotBlank(stringMap.get("4")));
        Assert.assertFalse(StringUtils.isNotBlank(stringMap.get("5")));
    }

    @Test
    public void testSplit(){
        String splitIs = "a is    V";
        System.out.println(splitIs.split(" is ").length);
        System.out.println("Saa".matches("^[A-Z].*?"));
    }
    @After
    public void clean(){
        stringMap = null;
    }
}
