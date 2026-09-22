package coding.dsa;





import org.springframework.util.ObjectUtils;
import org.yaml.snakeyaml.util.ArrayUtils;

import java.util.Arrays;
import java.util.Objects;

public class LongestConsecutiveIntegers {

    public static void main(String[] args) {
        //int[] ints = new int[]{100, 1,200,2,3,4,5,6,7,8,9,3,4,5,6};
        //int[] ints = new int[]{1,0,1,2};
        int[] ints = new int[]{1,2,6,7,8,9};
        Arrays.sort(ints);
        System.out.println(findLongest(ints));
    }

    private static int findLongest(int[] ints) {
        if(ObjectUtils.isEmpty(ints)) return 0;
        if(ints.length<2) return 1;
        int i=0;
        int max = 1;
        //int curMax = 1;
        Arrays.sort(ints);
        while(i<ints.length-1){
            int curMax = 1;


            while (i<ints.length-1){
                if(ints[i+1]==ints[i]){

                }
                else if(ints[i+1]==ints[i]+1){
                curMax++;

                }else{
                    break;
                }
                i++;
            }
            max = Math.max(max,curMax);
            i++;
        }
        return max;

    }
}
