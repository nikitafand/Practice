package coding.dsa;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ReverseVowelsString {
    public static void main(String[] args) {

        String str = "IceCreAm";
        String s = reverseVowels(str);
        System.out.println(s);
        char[] chars= new char[]{'a','a','b','b','c','c','c'};
        char[] chars1= new char[]{'a'};
        compressString(chars);
    }

    private static void compressString(char[] chars) {


        StringBuffer sb=new StringBuffer();
        if(chars!=null&&chars.length==1){
            sb.append(chars[0]);
           return;
        }
        for(int i=1;i<chars.length-1;i++){
            int count=1;
            char temp=chars[i-1];
            while(temp == chars[i]){
                count++;
                temp=chars[i];

            }
            sb.append(temp);
            if(count>1) sb.append(count);

        }
        System.out.println(sb.toString());

        sb.length();


    }

    private static String reverseVowels(String s) {
        Set<Character> vowels= Set.of('a', 'e', 'i','o', 'u', 'A', 'E', 'I', 'O', 'U');
        char[] arr= s.toCharArray();

        int left = 0, len= arr.length, right= len-1;

        while(left< right){
            while(left < right && !vowels.contains(arr[left]) ){
                left++;
            }
            while(right > 0 && !vowels.contains(arr[right]) ){
                right--;
            }

            if(left<right){
                char temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }
        }


    return new String(arr);

    }
}
