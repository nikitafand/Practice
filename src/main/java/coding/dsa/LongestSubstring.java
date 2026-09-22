package coding.dsa;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstring {

    public static void main(String[] args) {
        String str= "mq";//"abcabcdefghd";
        System.out.println(findLongestNonRepeating(str));
        String ch="eceba";
       // longestSubstringAtMostKDistinct(ch, 2);
    }

    private static int findLongestNonRepeating(String str) {
     char[] cs = str.toCharArray();
     int i =0, j=0 , n = str.length(), max=0;
     Set<Character> set = new HashSet<>();
     while (j < n){
         if(set.contains(cs[j])){
             set.remove(cs[i]);
             i++;
         }
         set.add(cs[j]);
         max= Math.max(max,j-i+1);
         j++;
     }
     String res = "";
    for(int m= i ; m < j ; m++){
            res+=cs[m];
    }
        System.out.println(res);
        return max;
    }

    public static int longestSubstringAtMostKDistinct(String s, int k) {

        int left = 0;

        int maxLen = 0;

        Map<Character, Integer> freq = new HashMap<>();
int right= 0;
        //for (int right = 0; right < s.length(); right++) {
while (right< s.length()){
            char ch = s.charAt(right);

            freq.put(ch, freq.getOrDefault(ch, 0) + 1);

            while (freq.size() > k) {

                char leftChar = s.charAt(left);

                freq.put(leftChar, freq.get(leftChar) - 1);

                if (freq.get(leftChar) == 0) {

                    freq.remove(leftChar);

                }

                left++;

            }

            maxLen = Math.max(maxLen, right - left + 1);
right++;
        }
        for(int i = left ; i < right; i++){
            System.out.println(s.charAt(i));
        }
        return maxLen;

    }
}
