package com.company;

public class QuickSort {


    /* This function takes last element as pivot,
       places the pivot element at its correct
       position in sorted array, and places all
       smaller (smaller than pivot) to left of
       pivot and all greater elements to right
       of pivot */
    int partition(int arr[], int low, int high)
    {
        // Below partition is using Hoare's algorithm
        int pivot_value = arr[low];
        int i = low;
        int j = high;

        while (i < j) {
            while (i <= high && arr[i] <= pivot_value) i++;
            while (arr[j] > pivot_value) j--;

            if (i < j) {
                // swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
            else {
                break;
            }
        }

        arr[low] = arr[j];
        arr[j] = pivot_value;

        // return the pivot index
        return j;
    }

    /* The main function that implements QuickSort()
      arr[] --> Array to be sorted,
      low  --> Starting index,
      high  --> Ending index */
    void quicksortArray(int arr[], int low, int high)
    {
        if (low < high)
        {
            /* pi is partitioning index, arr[pi] is
              now at right place */
            int pi = partition(arr, low, high);

            // Recursively sort elements before
            // partition and after partition
            quicksortArray(arr, low, pi-1);
            quicksortArray(arr, pi+1, high);
        }
    }


    /* A utility function to print array of size n */
    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i]+" ");
        System.out.println();
    }

    // Driver program
    public static void main(String args[])
    {
        int arr[] = {10, 7, 8, -9, 1, 5};
        int n = arr.length;

        QuickSort ob = new QuickSort();
        ob.quicksortArray(arr, 0, n-1);

        System.out.println("sorted array");
        printArray(arr);
    }

}
