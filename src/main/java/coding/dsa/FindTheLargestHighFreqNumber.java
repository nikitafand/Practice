package coding.dsa;

import java.util.HashMap;
import java.util.Map;

public class FindTheLargestHighFreqNumber {

    public static void main(String[] args) {



        int[]  arr= {1,2,2,2,3,3,3,4,4,4};
        findTheLargestHighFreqNumber(arr);



    }

    private static void findTheLargestHighFreqNumber(int[] arr) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i :arr){
            map.put(i , map.getOrDefault(i, 0)+1);
        }
        int max = Integer.MIN_VALUE;
        int maxKey= 0;
        for(int key:arr){

            if(max< map.get(key)){
                max = map.get(key);
            } else if(max==map.get(key) && key > maxKey){
                maxKey = key;
            }
        }
        System.out.println(maxKey + " " + max);

    }

}
