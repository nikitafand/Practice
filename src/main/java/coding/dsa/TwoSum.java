package coding.dsa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TwoSum {


    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int target = 9;
        findpairs(nums, target);
    }

    private static void findpairs(int[] nums, int target) {
        List<int[]> list = new ArrayList<>();
        Map<Integer , Integer> pairs= new HashMap<>();
        for(int i = 0 ;i<nums.length;i++){
             int[] pair= new int[2];
             int diff= target-nums[i];
             if(pairs.containsKey(diff)){
                 pair[0]= pairs.get(diff);
                 pair[1]= i;
                 list.add(pair);
             }
                 pairs.put(nums[i], i);

        }


        for(int[] pair:list){
            System.out.println(pair[0] +"::" + pair[1]);
        }


    }
}
