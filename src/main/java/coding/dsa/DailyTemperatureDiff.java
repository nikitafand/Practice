package coding.dsa;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class DailyTemperatureDiff {
    public static void main(String[] args) {

        int[] temp= new int[]{33, 34, 35, 31, 29, 32, 36, 33};
        int[] warmerDays = findWarmerDays(temp);
        System.out.println(Arrays.toString(warmerDays));
    }

    private static int[] findWarmerDays(int[] temp) {
        Deque<Integer> stack = new ArrayDeque<>();
        int len= temp.length;
        int[] res= new int[len];
//        for (int i=len-1;i>= 0;i--){
//
//            if(stack.isEmpty()){
//                stack.push(i);
//                continue;
//            }
//            while (!stack.isEmpty() && temp[stack.peek()]<temp[i]){
//                stack.pop();
//            }
//            if(stack.isEmpty()){
//                res[i]=0;
//            }else {
//                res[i]=stack.peek()-i;
//            }
//            stack.push(i);
//        }

        for(int i=0;i<len;i++){
            while(!stack.isEmpty() && temp[i]> temp[stack.peek()]){
                Integer pop = stack.pop();
                res[pop]= i - pop;
            }
            stack.push(i);
        }
        return res;
    }
}
