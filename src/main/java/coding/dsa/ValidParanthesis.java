package coding.dsa;

import java.util.*;

public class ValidParanthesis {

    public static void main(String[] args) {
 List<Integer> list = new LinkedList<>();
        String s= "{[()]}";
        boolean isValid= checkValid(s);
        System.out.println(isValid);
    }
    static boolean checkValid(String s){

        char[] c= s.toCharArray();
        Stack<Character> stack = new Stack<>();
        Set<Character> openSet = Set.of('{', '(', '[');
        Set<Character> closedSet = Set.of('}', ')', ']');
boolean valid= true;

        if(c.length==0){
            return valid;
        } if(c.length%2==1){
            return valid;
        }
        for(Character ch:c) {
            if (ch == '{' || ch == '('  || ch == '[') {
                stack.push(ch);
            }else{
                if(ch.equals(')')&& stack.peek()=='('){
                    stack.pop();
                }else if(ch.equals(']')&& stack.peek()=='['){
                    stack.pop();
                }
                else if(ch.equals('}')&& stack.peek()=='{'){
                    stack.pop();
                }
            }


        }
        return stack.isEmpty();
    }
}
