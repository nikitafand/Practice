package coding.dsa;

import java.util.ArrayList;
import java.util.List;

public class FindPalindromePairs {

    public static void main(String[] args) {
        String[] words = {"abcd", "dcba", "lls", "s", "sssll"};
        List<List<Integer>> pairs = findPalindromePairs(words);
        pairs.stream().flatMap(List::stream).forEach(System.out::println);
        for (List<Integer> pair : pairs) {
            System.out.println(words[pair.get(0)] + " :: " + words[pair.get(1)]);
        }
    }

    private static List<List<Integer>> findPalindromePairs(String[] words) {

        List<List<Integer>> res = new ArrayList<>();
        if (words == null || words.length == 0 || words.length == 1) {

            return res;
        }

        for (int i = 0; i < words.length - 1; i++) {
            for (int j = i + 1; j < words.length; j++) {
                String word1 = words[i] + words[j];
                if (checkPalindromeResurssion(word1)) {
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    list.add(j);
                    res.add(list);
                }

            }

        }

        return res;
    }

    private static boolean checkPalindrome(String word1) {
        int left = 0, right = word1.length() - 1;
        while (left < right) {
            if (word1.charAt(left++) != word1.charAt(right--)) {
                return false;
            }
        }
        return true;
    }

    private static boolean checkPalindromeResurssion(String word1) {
        String res = recursion(word1);

        return word1.equals(res);

    }

    private static String recursion(String word1) {
        if (word1.isEmpty()) {
            return word1;
        }
        System.out.println("word1"+ word1);
        return recursion(word1.substring(1)) + word1.charAt(0);
    }
}
