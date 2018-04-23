package com.company;

import java.util.HashSet;

public class RmvStrFrmOtherStr {

    public static String removeStr(String s1, String s2){
        HashSet<Character> strarr = new HashSet<>();
        for(int i=0 ; i <s1.length() ;i++){
            // increment count of character
            if(!strarr.contains(s1.charAt(i)))
                strarr.add(s1.charAt(i));
        }

        StringBuilder result  = new StringBuilder();
        for(int i=0; i < s2.length() ;i++){
            if(!strarr.contains(s2.charAt(i))){
                result.append(s2.charAt(i));
            }
        }

        return result.toString();

    }

    public static void main(String[] args) {
        System.out.println(removeStr( "abcd", "Have a great day"));
    }
}
