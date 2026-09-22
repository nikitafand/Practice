package coding.dsa;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class ProductSelf {
    public static void main(String[] args) {
Map<String,String> map= new ConcurrentHashMap<>();
        int[] nums= {1,2,3,4,5};
        int[] array = Arrays.stream(nums).boxed().sorted(Comparator.reverseOrder()).mapToInt(Integer::intValue).toArray();
        int[] res=   productExceptSelf(nums);
        System.out.println(Arrays.toString(array));

        String s= "leet**cod*e*";
       // StringBuilder builder = removeStarsAndChar(s);
       // System.out.println(builder);
    }
    static StringBuilder removeStarsAndChar(String str) {
        char[] chars= str.toCharArray();
        List<Character> result= new LinkedList<>();
        StringBuilder s= new StringBuilder();
        for(char c: chars){

            if(c == '*'){
                if(!s.isEmpty()){
                    s.deleteCharAt(s.length()-1);
                }

            }
            else{
                s.append(c);

            }
        }
        return s;

    }
    static int[] productExceptSelf(int[] arr){
        int n= arr.length;
        int[] prefix = new int[n];
        int[] suffix = new int[n];
        int[] result = new int[n];
        prefix[0]= 1;
        for(int i =1; i < arr.length; i++){
            prefix[i]= prefix[i-1]*arr[i-1];


        }
        System.out.println(Arrays.toString(prefix));
        suffix[n-1]= 1;
        for(int j = n-2; j >=0; j--){
            suffix[j]= suffix[j+1] * arr[j+1];
            System.out.println(suffix[j] + " "+ j);

        }
        System.out.println(Arrays.toString(suffix));
        for(int i =0; i < n; i++){
            result[i]= prefix[i]*suffix[i];
        }
      return result;
    }
}
