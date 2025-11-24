package Easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
/**
 *
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * An input string is valid if:
 *
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Every close bracket has a corresponding open bracket of the same type.
 *
 *
 * Example 1:
 *
 * Input: s = "()"
 *
 * Output: true
 *
 * Example 2:
 *
 * Input: s = "()[]{}"
 *
 * Output: true
 *
 * Example 3:
 *
 * Input: s = "(]"
 *
 * Output: false
 *
 * Example 4:
 *
 * Input: s = "([])"
 *
 * Output: true
 *
 * Example 5:
 *
 * Input: s = "([)]"
 *
 * Output: false
 *
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 104
 * s consists of parentheses only '()[]{}'.
 *
 * */

public class ValidParentheses20 {

    public static void main(String[] args) {
        System.out.println(isValid("()"));
        System.out.println(isValid("()[]{}"));
        System.out.println(isValid("(]"));
        System.out.println(isValid("([])"));
        System.out.println(isValid("([)]"));
    }





    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');

        for (int i = 0; i < s.length(); i++) {
            if(map.containsKey(s.charAt(i))) {
                stack.add(s.charAt(i));
            }
            else if(stack.isEmpty() ||map.get(stack.get(stack.size() - 1))!=s.charAt(i)) {
                return false;
            }
            else{
                stack.pop();
            }
        }

        return stack.isEmpty();

    }


/*
    public static boolean isValid(String s) {

        String temp="";



        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i)=='(' || s.charAt(i)=='{' || s.charAt(i)=='[') {
                temp+=s.charAt(i);
            }
            else if(s.charAt(i)==')' ) {
                if(temp.length()>0 && temp.charAt(temp.length()-1)=='('){
                    temp=temp.substring(0,temp.length()-1);
                    continue;
                }
                return false;
            }
            else if(s.charAt(i)=='}' ) {
                if(temp.length()>0 && temp.charAt(temp.length()-1)=='{') {
                    temp=temp.substring(0,temp.length()-1);
                    continue;
                }
                return false;
            }
            else if(s.charAt(i)==']' ) {
                if(temp.length()>0 && temp.charAt(temp.length()-1)=='[') {
                    temp=temp.substring(0,temp.length()-1);
                    continue;
                }
                return false;
            }


        }


        if(temp.length()>0){
            return false;
        }

        return true;

    }*/


    /*Note:
     * Unknown:
     * 1. stack
     * 2. HashMap
     *
     * My opinion:
     * 1. implement a stack with string
     * 2. compare with hard-code
     *
     * His opinion:
     * 1. implement a stack with stack
     * 2. compare with map
     *
     * Hint:
     * 1. Map can also be used as compare, except from storing an array
     * 2. realize of the stack
     * */


}
