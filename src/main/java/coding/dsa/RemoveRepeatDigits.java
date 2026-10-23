package coding.dsa;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class RemoveRepeatDigits {
    public static void main(String[] args) {

        int[] input = new int[]{90,91,92,93,94,95,96,97,98,99,100,101,102};
        System.out.println(Arrays.toString(removeNumbers(input)));
    }
    private static int[] removeNumbers(int[] input){


       int z=0;
        int[] result= new int[input.length];
        for(int i : input){
            int intLen = String.valueOf(i).length();
            long count = String.valueOf(i).chars().distinct().count();
            if(count == intLen){
                result[z++]=i;
            }
        }

        return result;

    }
}
