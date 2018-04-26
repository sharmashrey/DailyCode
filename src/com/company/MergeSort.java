package com.company;

import java.util.Arrays;

public class MergeSort {

    private int[] helper;


    public void sort(int[] values) {
        this.helper = new int[values.length];
        mergesort(values, 0, values.length - 1);
        System.out.println(Arrays.toString(values));
    }

    private void mergesort(int[] values, int low, int high) {
        // check if low is smaller than high, if not then the array is sorted
        if (low < high) {
            // Get the index of the element which is in the middle
            int middle = low + (high - low) / 2;
            // Sort the left side of the array
            mergesort(values, low, middle);
            // Sort the right side of the array
            mergesort(values, middle + 1, high);
            // Combine them both
            merge(values, low, middle, high);
        }
    }

    private void merge(int[] values, int low, int middle, int high) {

        // Copy both parts into the helper array
        for (int i = low; i <= high; i++) {
            helper[i] = values[i];
        }

        int i = low; //lowStart
        int j = middle + 1;  // highStart
        int k = low; //   INDEX -> to fill Orignal array

        // Copy the smallest values from either the left or the right side back to the original array
        while (i <= middle && j <= high) {
            if (helper[i] <= helper[j]) {
                values[k] = helper[i];
                i++;
            } else {
                values[k] = helper[j];
                j++;
            }
            k++;
        }
        // Copy the rest of the left side of the array into the target array
        while (i <= middle) {
            values[k] = helper[i];
            k++;
            i++;
        }
        // Since we are sorting in-place any leftover elements from the right side
        // are already at the right position.

    }
}