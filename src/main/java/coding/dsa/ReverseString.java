package coding.dsa;

import java.util.Arrays;
import java.util.List;

public class ReverseString {

    public static void main(String[] args) {
        String s = "abcdefg";
        reversString(s);
        reverseStringUsingaRecursion(s);
    }
    private static void reverseStringUsingaRecursion(String s) {

        String res = reversed(s);
        System.out.println(res);
    }

    private static String reversed(String s) {

        if (s.isEmpty()) {
            return s;
        }

        return reversed(s.substring(1)) + s.charAt(0);
    }

    static void reversString(String s) {
        char[] arr = s.toCharArray();
        int end = arr.length - 1, start = 0;

        while (end > 0 && start < end) {
            char temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            end--;
            start++;
        }
        Arrays.toString(arr);
        List.of(arr).stream().forEach(System.out::println);
    }

}
