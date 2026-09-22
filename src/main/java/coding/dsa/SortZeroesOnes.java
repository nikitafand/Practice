package coding.dsa;

import java.util.Arrays;

public class SortZeroesOnes {

    public static void main(String[] args) {

        int[] nums= {0,0,1,0,1,0,1,0,1,0};
        sortUsingTwoPointer(nums);
    }

    private static void sortUsingTwoPointer(int[] nums) {
        int len = nums.length;
        int i=0, j = len-1;
        while(i<j){

            while(i<j&&nums[i]==0){
                i++;
            }
            while(i<j&&nums[j]==1){
                j--;
            }
            if(i<j){
                int temp = nums[i];
                nums[i]=nums[j];
                nums[j]=temp;
            }

        }
        System.out.println(Arrays.toString(nums));

    }
}
