package Easy; /**
 *
 * Given two strings s and t, return true if t is an anagram of s, and false otherwise.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "anagram", t = "nagaram"
 *
 * Output: true
 *
 * Example 2:
 *
 * Input: s = "rat", t = "car"
 *
 * Output: false
 *
 *
 *
 * Constraints:
 *
 * 1 <= s.length, t.length <= 5 * 104
 * s and t consist of lowercase English letters.
 *
 *
 * Follow up: What if the inputs contain Unicode characters? How would you adapt your solution to such a case?
 *
 * */


import java.util.ArrayList;

public class ValidAnagram242 {


    public static void main(String[] args) {
        System.out.println(isAnagram("rat","car"));
        System.out.println(isAnagram("anagram","nagaram"));
    }

    public static boolean isAnagram(String s, String t) {



        ArrayList<Character> list=new ArrayList<>();
        for(char a:s.toCharArray()){
            list.add(a);
        }
        for(char a:t.toCharArray()){
            if(!list.contains(a)){
                return false;
            }
            list.remove((Character) a);
        }
        return list.isEmpty();


    }

    /*Note:
    *
    * Maybe the complexity is O(N) and memory is N, but it can solve the problem in a more general way
    *
    * */


}
