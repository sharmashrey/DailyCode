package com.company;

public class FindAnagrams {
//ALL POSSIBLE PERMUTATIONS

    public static void getAnagrams(String s ){

        recString( "", s  );

    }

    public static void recString( String prefix, String s){

        if( s.length() == 0){

         System.out.println(prefix);
        }else{

            for(int i =0; i < s.length();i++){
                recString( prefix + s.charAt(i),s.substring(0,i)+ s.substring(i+1, s.length()) );
            }
        }
    }

    public static void main(String[] args) {
        String s ="abcd";

        getAnagrams(s);
    }

}
