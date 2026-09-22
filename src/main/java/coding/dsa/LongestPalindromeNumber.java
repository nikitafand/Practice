package coding.dsa;

public class LongestPalindromeNumber {
    public static void main(String[] args) {
        int num= -121;

        System.out.println(findLongestNumber(num));
    }

    private static boolean findLongestNumber(int num) {
        String string = Integer.toString(num);
        for (int i = 0; i < string.length()/2; i++) {

            if(string.charAt(i) != string.charAt(string.length()-i-1)) {
                return false;
            }

        }
        return true;
    }


}
