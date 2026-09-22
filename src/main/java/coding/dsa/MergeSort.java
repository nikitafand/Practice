package coding.dsa;

import java.util.Arrays;

public class MergeSort {


    public static void main(String[] args) {

        //int[] arr = {1,2,5,4,1,2,6,5,4};
        int[] arr = {1,2,5,4,7,6,8,9};
        int low = 0;
        int high= arr.length-1;
        mergeSortNew(arr, low, high);
       // System.out.println(Arrays.toString(arr));

    }

     static void mergeSortNew(int[] arr, int low, int high) {
        if  (low >= high) { return ;}
        int mid = low+(high-low)/2;
         mergeSortNew(arr, low, mid);
         mergeSortNew(arr, mid+1, high);
         merge(arr, low, mid, high);


    }
    static void merge(int[] arr, int low, int mid, int high) {
        int m= mid-low +1;
        int n= high-mid;

        int[] larr= new int[m];
        int[] rarr= new int[n];

        for (int i = 0 ; i < m ;i++) {
            larr[i]= arr[low+i];
            System.out.println("larr"+ Arrays.toString(larr));
        }

        for (int j = 0 ; j < n ;j++) {
            rarr[j]= arr[mid+1+j];
            System.out.println("rarr"+ Arrays.toString(rarr));
        }
        int i = 0, j = 0, k= low;
        while( i < m && j < n ){
            if(larr[i]<rarr[j]){
                arr[k]= larr[i];
                i++;
            }else{
                arr[k]= rarr[j];
                j++;
            }
            k++;
        }
        while (i< m ){
            arr[k]= larr[i];
            i++;
            k++;
        }
        while (j< n ){
            arr[k]= rarr[j];
            j++;
            k++;
        }
    }
}
