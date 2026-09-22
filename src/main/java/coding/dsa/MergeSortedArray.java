package coding.dsa;

import java.util.Arrays;

public class MergeSortedArray {
    public static void main(String[] args) {
         int[] nums= {1,3,5,6,8,10};
         int[] nums1= {2,4,7,9};
        int[] result = mergeSortedArray(nums, nums1);
        System.out.println(
                Arrays.toString(result));
    }

    private static int[] mergeSortedArray(int[] nums, int[] nums1) {
    int m= nums.length;
    int n = nums1.length;

        int[] result= new int[m+n];
        int i =0, j =0 , index=0;
        while (i < m && j < n){

            if(nums[i]<nums1[j]){
                result[index++]=nums[i++];
            }else {
                result[index++]=nums1[j++];
            }

        }
        while (i < m){
            result[index++]=nums[i++];
        }
         while (j < n){
             result[index++]=nums1[j++];
         }

    return result;
    }
}
