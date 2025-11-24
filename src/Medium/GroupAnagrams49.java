package Medium;
import java.util.*;
/**
 * Given an array of strings strs, group the anagrams together. You can return the answer in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: strs = ["eat","tea","tan","ate","nat","bat"]
 *
 * Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
 *
 * Explanation:
 *
 * There is no string in strs that can be rearranged to form "bat".
 * The strings "nat" and "tan" are anagrams as they can be rearranged to form each other.
 * The strings "ate", "eat", and "tea" are anagrams as they can be rearranged to form each other.
 * Example 2:
 *
 * Input: strs = [""]
 *
 * Output: [[""]]
 *
 * Example 3:
 *
 * Input: strs = ["a"]
 *
 * Output: [["a"]]
 *
 *
 *
 * Constraints:
 *
 * 1 <= strs.length <= 104
 * 0 <= strs[i].length <= 100
 * strs[i] consists of lowercase English letters.
 *
 * */
public class GroupAnagrams49 {


    public static void main(String[] args) {

        System.out.println(groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));


    }


    //It is another implementation of hashTable, but use the wrapper class in Java instead
    public static List<List<String>> groupAnagrams3(String[] strs) {

        Map<Key, List<String>> map = new HashMap<>();

        for (String s : strs) {
            int[] count = new int[26];
            for (char c : s.toCharArray()) {
                count[c - 'a']++;
            }

            Key key = new Key(count);
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(s);
        }

        return new ArrayList<>(map.values());

    }



    static class Key {
        private final int[] count;

        Key(int[] count) {
            this.count = Arrays.copyOf(count, count.length);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Key)) return false;
            Key other = (Key) o;
            return Arrays.equals(this.count, other.count);
        }

        @Override
        public int hashCode() {
            return Arrays.hashCode(count);
        }


    }





    //Worst case O(n * n log n) in total
    //O(n *k log k)  in average
    public List<List<String>> groupAnagrams2(String[] strs) {
        Map<String, List<String>> ans = new HashMap<>();

        for (String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            if (!ans.containsKey(key)) {
                ans.put(key, new ArrayList<>());
            }
            ans.get(key).add(s);
        }

        return new ArrayList<>(ans.values());
    }



    //Worst case O(n^2), thus O(n^2*k) in total
    //Average case O(n^2), but with the constant smaller
    //best case O(n), O(n*k) in total
    public static List<List<String>> groupAnagrams(String[] strs) {


        List<List<String>> ans = new ArrayList<>();

        loop: for(String str : strs){

            for(List<String> list:ans){

                if(areAnagrams(list.get(0),str)){
                    list.add(str);
                    continue loop;
                }

            }

            List<String> list=new ArrayList<>();
            list.add(str);
            ans.add(list);


        }

        return ans;





    }

    //O(k)
    public static boolean areAnagrams(String s, String t) {

        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (char c : t.toCharArray()) {

            if(!map.containsKey(c)) {
                return false;
            }
            else if(map.get(c) == 1) {
                map.remove(c);
            }
            else {
                map.put(c, map.get(c) - 1);
            }

        }
        return map.isEmpty();
    }




    /* Note: the inner sort function in java runs at O(n log n), use it when alternative reach mover O(n^2)
    *
    *
    *
    *
    * */



}
