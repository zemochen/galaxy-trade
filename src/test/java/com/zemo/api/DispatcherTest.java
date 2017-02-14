package com.zemo.api;

import org.junit.Before;
import org.junit.Test;

import java.io.*;

/**
 * @ClassName: DispatcherTest
 * @author: SuperZemo
 * @email: zemochen@gmail.com
 * @Date 2016-05-01 08:03:08
 * @Description test of the controller of analysis input
 */
public class DispatcherTest {

    @Before
    public void initRule() {
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("/input.txt")));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                Dispatcher.analysisInput(line);
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testAll() {
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("/question.txt")));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println("Q:"+line);
                System.out.printf("A:");
                Dispatcher.analysisInput(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
