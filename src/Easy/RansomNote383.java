package Easy;

import java.util.HashMap;

/**
 *
 * Given two strings ransomNote and magazine, return true if ransomNote can be constructed by using the letters from magazine and false otherwise.
 *
 * Each letter in magazine can only be used once in ransomNote.
 *
 *
 *
 * Example 1:
 *
 * Input: ransomNote = "a", magazine = "b"
 * Output: false
 * Example 2:
 *
 * Input: ransomNote = "aa", magazine = "ab"
 * Output: false
 * Example 3:
 *
 * Input: ransomNote = "aa", magazine = "aab"
 * Output: true
 *
 *
 * Constraints:
 *
 * 1 <= ransomNote.length, magazine.length <= 105
 * ransomNote and magazine consist of lowercase English letters.
 * */

public class RansomNote383 {


    public static void main(String[] args) {

        System.out.println(canConstruct("a",""));

    }


    public static boolean canConstruct(String ransomNote, String magazine) {


        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : magazine.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (char c : ransomNote.toCharArray()) {
            if (!map.containsKey(c)) {
                return false;

            }
            else{
                int count = map.get(c);
                if(count==0){
                    return false;
                }
                map.put(c, count-1);
            }
        }

        return true;

    }

    /*Note:
    * Nothing to state
    * */

}
