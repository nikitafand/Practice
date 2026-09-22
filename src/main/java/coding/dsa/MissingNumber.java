package coding.dsa;

import java.util.HashMap;
import java.util.Map;

public class MissingNumber {
    public static void main(String[] args) {
        int[] nums = {1};
        System.out.println(missingNumber(nums));
    }

    private static int missingNumber(int[] nums) {
        int[] count = new int[nums.length + 1];
        for(int i=0;i< nums.length;i++){
            if(nums[i]>0 && nums[i]< nums.length+1){
                count[nums[i]]++;
            }
        }
        int res=0;
        for(res=1;res<count.length;res++){
            if(count[res]==0){
                return res;
            }
        }
        return res;
    }
//    public static int missingNumber(int[] nums) {
//        Map<Integer,Integer> count = new HashMap<>();
//        for(int num:nums){
//            Integer countOrDefault = count.getOrDefault(num, 0);
//            count.put(num,countOrDefault+1);
//        }
//        int i=0;
//        for(i=1;i<nums.length;i++){
//            if(count.containsKey(i) && count.get(i)==0){
//                return i;
//            }
//        }
//        return i+1;
//    }
}
