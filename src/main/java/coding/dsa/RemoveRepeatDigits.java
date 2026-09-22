package coding.dsa;

import java.util.HashMap;
import java.util.Map;

public class RemoveRepeatDigits {
    public static void main(String[] args) {

        int[] input = new int[]{90,91,92,93,94,95,96,97,98,99,100,101,102};
        removeNumbers(input);
       
    }


    private static int[] removeNumbers(int[] input){

        int[] result= new int[input.length];


        for(int i : input){

            Map<Integer, Integer> intCountMap= new HashMap<>();
            int[] temp= {2};
            int count= 0;

            for(int j : temp){


                int tCount= intCountMap.getOrDefault(j, 0)+1;


                count= Math.max(count, tCount);
                if(count == 2 ){

                    break;
                }
                intCountMap.put(j , tCount);

            }

        }
        return result;

    }
}
