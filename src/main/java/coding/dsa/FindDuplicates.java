package coding.dsa;

import java.util.*;

public class FindDuplicates {
    public static void main(String[] args) {

        int[] nums = {1, 2, 4, 3, 2, 4, 6, 6};
        // find duplicates in array
        int[] duplicates=   findDuplicates(nums);
        System.out.println(Arrays.toString(duplicates));


        int[] hello = new int[1];
        hello[0] = 1;
        //hello[1] = 2;
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

