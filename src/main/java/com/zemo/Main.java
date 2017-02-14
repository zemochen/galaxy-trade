package com.zemo;

import com.zemo.api.Dispatcher;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName: Main
 * @author: SuperZemo
 * @email: zemochen@gmail.com
 * @Date 4/28/16 11:03
 * @Description ${TODO}
 */
public class Main {

    public static void main(String[] arg) throws IOException {
        System.out.println("Input the rules before you ask,please.");
        System.out.println("Rules must be like {what} is {what}");
        System.out.println("For example:");
        System.out.println("            glob is I");
        System.out.println("            prok is V");
        System.out.println("            glob glob Silver is 34 Credits");
        System.out.println("After input rules,you can ask question. If you want ask question,you must start with \"how many\" or \"how much\"");
        System.out.println("Be attention:(You must set the rule which you ask)");
        System.out.println("For example:");
        System.out.println("            how much is glob prok?");
        System.out.println("            how many Credits is glob prok Silver?");
        System.out.println("please input sentence and press \"Enter\" to execute,input \":q\" to quit：");
        BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufw = new BufferedWriter(new OutputStreamWriter(System.out));
        String line = null;
        while ((line = bufr.readLine()) != null) {
            if (":q".equals(line)) break;
            Dispatcher.analysisInput(line);
            bufw.newLine();
            bufw.flush();
        }
        bufw.close();
    }
}
