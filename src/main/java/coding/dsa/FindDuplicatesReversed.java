package coding.dsa;

import java.util.*;

public class FindDuplicatesReversed {
    public static void main(String[] args) {
        String s = "abcdefg";
        reversString(s);
        //  reverseStringUsingaRecursion(s);
        int[] nums = {1, 2, 4, 3, 2, 4, 6, 6};
        // find duplicates in array
        // int[] duplicates=   findDuplicates(nums);
        //  System.out.println(Arrays.toString(duplicates));


        int[] hello = new int[1];
        hello[0] = 1;
        //hello[1] = 2;
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

    // int[] nums= {1,2,4,3,2,4,6,6};
    static int[] findDuplicates(int[] nums) {
        String s = "";
        Set<Integer> unique = new HashSet<>();
        int[] duplicates = new int[nums.length];
        int index = 0;
        for (int i : nums) {

            if (!unique.add(i)) {
                duplicates[index++] = i;
                System.out.println(i);
            } else {
                s += Integer.toString(i);
            }


        }

        System.out.println(s);
        return duplicates;

    }
}

