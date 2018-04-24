package com.company;

public class ReverseSentence {


    public static void revSen(String sentence){

        String[] sentarr = sentence.split(" ");
        StringBuilder result = new StringBuilder();
        for(int i=0; i <sentarr.length;i++){
            result.append(revWord( sentarr[i]) +" ");
        }

        System.out.print( result.toString());
    }

    public static String revWord(String word){
        StringBuilder str = new StringBuilder();
        for(int i=word.length()-1; i>=0;i--){
            str.append(word.charAt(i));
        }
        return str.toString();
    }

    public static void main(String[] args){

        String sentence = "Have   a good day ! pete";
        revSen(sentence);

    }
}
