package com.company;

import java.util.ArrayList;

public class NxtGreatestNum {

    public static void main(String[] args){
        getNext("218765");
    }

    public static void getNext(String num){
        int nxtnumb = Integer.MAX_VALUE;
        int orignalnumber = Integer.parseInt(num);
        ArrayList<Integer> numlist = new ArrayList<>();
        chkperm( "", num, nxtnumb, numlist);

        for(int i : numlist){
            if(i>orignalnumber && i < nxtnumb ){
                nxtnumb = i;
            }
        }

        if(nxtnumb == Integer.MAX_VALUE){
            System.out.print("Not found");
        }else{
            System.out.print(nxtnumb);
        }

    }

    public static void chkperm(String prefix , String orignal,int nxtnumb, ArrayList<Integer> numlist ){

        if(orignal.length() ==0 ){
            int currnum = Integer.parseInt( prefix);
            numlist.add(currnum);

            return;
        }else{

            for(int i =0; i < orignal.length();i++){
                chkperm( prefix+ orignal.charAt(i), orignal.substring(0, i)+ orignal.substring(i+1,orignal.length()) ,nxtnumb , numlist);
            }

        }
    }


}
