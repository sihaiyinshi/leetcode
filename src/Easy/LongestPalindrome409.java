package Easy;
import java.util.HashSet;
/**
 * Given a string s which consists of lowercase or uppercase letters, return the length of the longest palindrome that can be built with those letters.
 *
 * Letters are case sensitive, for example, "Aa" is not considered a palindrome.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "abccccdd"
 * Output: 7
 * Explanation: One longest palindrome that can be built is "dccaccd", whose length is 7.
 * Example 2:
 *
 * Input: s = "a"
 * Output: 1
 * Explanation: The longest palindrome that can be built is "a", whose length is 1.
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 2000
 * s consists of lowercase and/or uppercase English letters only.
 *
 *
 *
 * */



public class LongestPalindrome409 {




    public static void main(String[] args) {


        System.out.println(longestPalindrome("a"));

    }









    public static int longestPalindrome(String s) {

        int res = 0;
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {


            if(set.contains(s.charAt(i))){
                set.remove(s.charAt(i));
                res+=2;
                continue;
            }

            set.add(s.charAt(i));

        }

        return set.isEmpty()?res:res+1;


    }


    /*Note:
    * No more to state
    *
    *
    *
    *
    *
    * */









}
