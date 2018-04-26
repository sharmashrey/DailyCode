package com.company;

public class SearchRotatedSorted {

    public static void main(String[] args){
        int[] arr = {5,6,7,1,2,3}; //to make working for 7 7 7 7 duplicates
        search( arr, 1);
    }

    public static void search(int[] arr, int x ){

        int low =0;
        int high = arr.length-1;


        while(low <= high){
            int mid = low+high/2+1;

            if(arr[mid] ==x || arr[low]==x || arr[high]==mid){
                System.out.print("x"+x+" , mid" +mid);
                break;
            }
            else if( arr[low] > x && arr[mid] < x){
                low = mid+1;
            }else if( arr[low] < x && arr[mid] < x ){
                high = mid-1 ;

            }else if( arr[low] == arr[high]){

            if(x > arr[high]){
                low = high+1;
            }else{
                high = low-1;
            }

            }else {
            System.out.print("not found");
            break;}
        }


    }


}
