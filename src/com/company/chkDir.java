package com.company;

public class chkDir {

    public static void main(String[] args){

        String str ="-111 0 2 4";

        String[] splitarr = str.split(" ");
        int x1=-1;
        int x2=-1;
        int x3=-1;
        int x4=-1;

        for(int i=0; i<splitarr.length;i++ ){
            x1= Integer.parseInt(splitarr[0]);
            x2=Integer.parseInt( splitarr[1]);
            x3= Integer.parseInt(splitarr[2]);
            x4= Integer.parseInt(splitarr[3]);
        }
        System.out.print(x1);

    }
}
