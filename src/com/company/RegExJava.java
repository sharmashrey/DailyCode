package com.company;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExJava {

    public static void main(String[] args) {
        getStrMiddle( "$ yo mAtched ; $ second ; ");
    }

    //get everything between $ and ; in string
    //
    static void getStrMiddle(String str ){
        Pattern MY_PATTERN = Pattern.compile("\\$(.*?)\\;");
        Matcher m = MY_PATTERN.matcher(str);
        while (m.find()) {
            String s = m.group(1);
            // s now contains "BAR"
            System.out.println(s);
        }
    }
}
