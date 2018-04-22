package com.company;

import java.util.Arrays;

public class MoveZerosLeft {

    //
    public static int[] movezero(int[] arrayint ){
        int zeroCount =0;
        for(int i= arrayint.length-1 ; i>= 0 ; i--){
            if( arrayint[i] ==0){
                zeroCount++;
            }else{
                arrayint[ i + zeroCount ] = arrayint[i];
                }
        }

        for(int i=0 ; i< zeroCount;i++){
            arrayint[i] =0 ;
        }

        return arrayint;
    }

    public static void main(String[] args) {
        int[] array = {1,2,3,0,0,0,4,5,0};
        System.out.print(Arrays.toString( movezero(array)));

    }
}
