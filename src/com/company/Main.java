package com.company;

import java.sql.Array;
import java.util.Arrays;
import com.company.MergeSort;

public class Main {

    public static void main(String[] args) {
	// write your code here

	int[] arr=  {0,34,6,-2,-23242, 89238, 53,645};
    MergeSort merj = new MergeSort();
    merj.sort(arr);
        mergeSort( arr);

    }

    static void mergeSort(int[] values){

        int[] temparr = new int[values.length];
        doMergeSort( values, temparr, 0 , values.length-1);
        System.out.println("SorTED" + Arrays.toString(values) );

    }
    static void doMergeSort( int[] values, int[] temparr, int low , int high){
            if(low <high){
                int mid = low+(high-low)/2;
                doMergeSort( values, temparr, low , mid);
                doMergeSort( values, temparr, mid+1 , high);
                merge(values, temparr, low, mid , high );
            }else{
                return;
            }
    }
    static void merge( int[] values, int[] temparr, int low , int mid, int high){
        //copy values to temp arr
        for(int i = low; i <= high ; i++){
            temparr[i] = values[i];
        }

        int i = low;
        int j  = mid+1 ; //starting for 2nd half
        int k = low;

        // if 1st start array pointer less than its end && 2nd right half array pointer less than highest arr value
        while(i <=mid && j<= high ){
            if( temparr[i]<= temparr[j] ){
                values[k] = temparr[i];
                i++;
            }else{
                values[k] = temparr[j];
                j++;
            }
            k++; // pointer that helps to fill up the orignal array
        }

        //copy remaining values
        while(i <= mid){
            values[k] = temparr[i];
            k++; i++;
        }

    }
}
