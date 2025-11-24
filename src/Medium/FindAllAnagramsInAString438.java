package Medium;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
/**
 * Given two strings s and p, return an array of all the start indices of p's anagrams in s. You may return the answer in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "cbaebabacd", p = "abc"
 * Output: [0,6]
 * Explanation:
 * The substring with start index = 0 is "cba", which is an anagram of "abc".
 * The substring with start index = 6 is "bac", which is an anagram of "abc".
 * Example 2:
 *
 * Input: s = "abab", p = "ab"
 * Output: [0,1,2]
 * Explanation:
 * The substring with start index = 0 is "ab", which is an anagram of "ab".
 * The substring with start index = 1 is "ba", which is an anagram of "ab".
 * The substring with start index = 2 is "ab", which is an anagram of "ab".
 *
 *
 * Constraints:
 *
 * 1 <= s.length, p.length <= 3 * 104
 * s and p consist of lowercase English letters.
 * */


public class FindAllAnagramsInAString438 {


    public static void main(String[] args) {

        System.out.println(findAnagrams2("abab", "ab"));
        System.out.println(findAnagrams2("cbaebabacd", "abc"));


    }


    public static List<Integer> findAnagrams2(String s, String p) {

        ArrayList<Integer> ans = new ArrayList<>();
        int[] sFreq = new int[26];
        int[] pFreq = new int[26];
        for (int i = 0; i < p.length(); i++) {
            pFreq[p.charAt(i) - 'a']++;
        }

        for(int i=0;i<s.length();i++){


            sFreq[s.charAt(i) - 'a']++;

            if(i>p.length()-1){
                sFreq[s.charAt(i-p.length())-'a']--;
            }

            if(Arrays.equals(sFreq,pFreq)){
                ans.add(i-p.length()+1);
            }


        }

        return ans;

    }
    /*Note:
    * Sliding windows is just moving every windows forward, and check for every window
    *
    * */


    public static List<Integer> findAnagrams(String s, String p) {


        ArrayList<Integer> ans = new ArrayList<>();

        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : p.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }



        for (int i = 0; i < s.length()-p.length()+1; i++) {
            char c = s.charAt(i);

            if(map.containsKey(c)) {

                if(isAnagram(s.substring(i,i+p.length()),p)) {
                    ans.add(i);
                }

            }
        }

        return ans;


    }


    private static boolean isAnagram(String s, String p) {

        if (s.length() != p.length()) return false;

        int[] freq = new int[26];

        for (int i = 0; i < s.length(); i++)
            freq[s.charAt(i) - 'a']++;

        for (int i = 0; i < p.length(); i++)
            freq[p.charAt(i) - 'a']--;

        for (int count : freq) {
            if (count != 0)
                return false;
        }

        return true;

    }



}
