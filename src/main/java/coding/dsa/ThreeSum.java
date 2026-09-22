package coding.dsa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    public static void main(String[] args) {
        int[] arr = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> threeSumLists = findThreeSumLists(arr, 0);
        System.out.println(Arrays.toString(threeSumLists.toArray()));
    }

    private static List<List<Integer>> findThreeSumLists(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        int len=nums.length;
        Arrays.sort(nums);
        if(nums==null || len<3 ) {
            return res;
        }
        for (int i = 0; i < len-3; i++) {
            if(nums[i]> 0) break;
            if(i>0&&nums[i]==nums[i-1]) continue;
            int left=i+1;
            int right=len-1;
            while(left< right) {
                int sum=nums[i]+nums[left]+nums[right];
                if(sum==target) {
                    res.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    while(left<right&&nums[left]==nums[left+1]) left++;
                    while(left<right&&nums[right]==nums[right-1]) right--;
                    left++;
                    right--;
                }else if(sum>target) {
                    right--;

                }  else  {
                    left++;
                }

            }


        }


        return res;
    }
}
