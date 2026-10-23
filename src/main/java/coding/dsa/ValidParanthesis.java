package coding.dsa;

import java.util.*;

public class ValidParanthesis {

    public static void main(String[] args) {
 List<Integer> list = new LinkedList<>();
       // String s= "{[()]}";
        String s= "([}}])";

        System.out.println(checkValid(s));
    }
    static boolean checkValid(String s){

        if(s!=null|| !s.isEmpty()) {
            if (s.length() % 2 == 1) {
                return false;
            } else {
                char[] charArray = s.toCharArray();
                Stack<Character> stack = new Stack<>();
                Set<Character> openSet = Set.of('{', '(', '[');
                Set<Character> closedSet = Set.of('}', ')', ']');
                for (char c : charArray) {
                    if (openSet.contains(c)) {
                        stack.push(c);
                    } else if (closedSet.contains(c)) {
                        if (stack.isEmpty()) {
                            return false;
                        }
                        Character pop = stack.pop();
                        if (')' == c && pop != '(') {
                            return false;
                        }
                        if (']' == c && pop != '[') {
                            return false;
                        }
                        if ('}' == c && pop != '{') {
                            return false;
                        }
                    }

                }
                return stack.isEmpty();
            }

        }else {
             return false;
        }
    }
}
