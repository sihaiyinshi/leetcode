package Medium; /**
 * Given a string s, find the length of the longest substring without duplicate characters.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * Example 2:
 *
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * Example 3:
 *
 * Input: s = "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 *
 *
 * Constraints:
 *
 * 0 <= s.length <= 5 * 104
 * s consists of English letters, digits, symbols and spaces.
 * **/


import java.util.HashMap;
import java.util.HashSet;

public class LongestSubstringWithoutRepeatingCharacters3 {

    public static void main(String[] args) {
        //System.out.println(lengthOfLongestSubstring("pwwkew"));
        //System.out.println(lengthOfLongestSubstring(" "));
        //System.out.println(lengthOfLongestSubstring("dvdf"));
        //System.out.println(lengthOfLongestSubstring(" "));
        //System.out.println(lengthOfLongestSubstring(""));


        System.out.println(lengthOfLongestSubstring2("pwwkew"));
        System.out.println(lengthOfLongestSubstring2(" "));
        System.out.println(lengthOfLongestSubstring2("dvdf"));
        System.out.println(lengthOfLongestSubstring2("abcabcbb"));
        System.out.println(lengthOfLongestSubstring2("bbbbbbb"));
    }

    public static int lengthOfLongestSubstring(String s) {

        HashMap<Character, Integer> map = new HashMap<>();
        int max=0;
        int lastAppear=0;

        for(int i=0;i<s.length();i++){
            if(map.containsKey(
                    s.charAt(i)) && map.get(s.charAt(i))>=lastAppear){
                lastAppear = map.get(s.charAt(i))+1;
            }
            map.put(s.charAt(i), i);
            max = Math.max(max, i-lastAppear+1);
        }

        return max;

    }


    public static int lengthOfLongestSubstring2(String s) {


        HashSet<Character> set = new HashSet<>();

        int max=0;
        for(int i=0;i<s.length();i++){
            if(set.contains(s.charAt(i))){
                max=Math.max(max, set.size());
                set.clear();
            }
            set.add(s.charAt(i));
        }
        return max;


    }




/*
    public static int lengthOfLongestSubstring(String s) {

        if (s == null || s.isEmpty()) return 0;


        int max=1;

        for(int i=0;i<s.length();i++){
            HashSet<Character> set = new HashSet<Character>();
            for(int j=i;j<s.length();j++){
                if(set.contains(s.charAt(j))){
                    max=Math.max(max,set.size());
                    break;
                }
                    set.add(s.charAt(j));
            }
            max=Math.max(max,set.size());
        }

        return max;



    }*/


}


