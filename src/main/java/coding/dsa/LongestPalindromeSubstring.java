package coding.dsa;

public class LongestPalindromeSubstring {

    public static void main(String[] args) {
        String s= "a";
        String s1 = longestPalindrome(s);
        System.out.println(s1);
    }

    private static String longestPalindrome(String s) {
        int len = s.length();
        int maxlen = 0, start=0;
        for (int i = 0; i <= len; i++) {
            int len1= checklongest(s, i , i);
            int len2= checklongest(s, i , i+1);
            int max= Math.max(len1, len2);
            if (max > maxlen) {
                maxlen = max;
                start= i -(max-1)/2;
            }
        }
        return s.substring(start, start + maxlen);

    }

    private static int checklongest(String s, int left, int ryt) {
        while(left>=0 && ryt<s.length() && s.charAt(left)==s.charAt(ryt)){
            left--;
            ryt++;
        }
         return ryt- left -1;
    }
}
