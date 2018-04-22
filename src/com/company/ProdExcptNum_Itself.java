package com.company;

import java.util.Arrays;

public class ProdExcptNum_Itself {

    public static int[] getProductWithoutSelf( int[] array){

        int[] result = new int[array.length];
        int[] resultRight = new int[array.length];
        //left sweep for multiplying all left elements
        int product=1;
        result[0]=1;
        for(int i=1; i < result.length;i++){
            product *=array[i-1];
            result[i] = product;
        }

        //right sweep for multiplying all left elements
        product=1;
        resultRight[result.length-1]=1;
        for(int i=result.length-2 ; i >=0 ;i--){
            product *=array[i+1];
            resultRight[i] = product;
        }

        //final values
        for(int i=0 ; i < result.length;i++) {
         result[i] = result[i]* resultRight[i];
        }

        return result;
        }

    public static void main(String[] args) {

        int[] array = {1,2,3,4, -2};
        System.out.println(Arrays.toString(getProductWithoutSelf(array)));
    }
}
