package Medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Given an array of strings words and an integer k, return the k most frequent strings.
 *
 * Return the answer sorted by the frequency from highest to lowest. Sort the words with the same frequency by their lexicographical order.
 *
 *
 *
 * Example 1:
 *
 * Input: words = ["i","love","leetcode","i","love","coding"], k = 2
 * Output: ["i","love"]
 * Explanation: "i" and "love" are the two most frequent words.
 * Note that "i" comes before "love" due to a lower alphabetical order.
 * Example 2:
 *
 * Input: words = ["the","day","is","sunny","the","the","the","sunny","is","is"], k = 4
 * Output: ["the","is","sunny","day"]
 * Explanation: "the", "is", "sunny" and "day" are the four most frequent words, with the number of occurrence being 4, 3, 2 and 1 respectively.
 *
 *
 * Constraints:
 *
 * 1 <= words.length <= 500
 * 1 <= words[i].length <= 10
 * words[i] consists of lowercase English letters.
 * k is in the range [1, The number of unique words[i]]
 *
 *
 * Follow-up: Could you solve it in O(n log(k)) time and O(n) extra space?
 *
 *
 *
 * */

public class TopKFrequentWords692 {





    public static void main(String[] args) {




        System.out.println(topKFrequent(new String[]{"i","love","leetcode","i","love","coding"},0));




    }


    public static List<String> topKFrequent(String[] words, int k) {



        HashMap<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }


        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<String> word = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : map.entrySet()) {


            if(list.isEmpty()) {
                list.add(entry.getValue());
                word.add(entry.getKey());
                continue;
            }


            int index=0;
            while(index<list.size() && list.get(index)>entry.getValue()){
                index++;
            }

            while(index<word.size() && list.get(index).equals(entry.getValue()) && word.get(index).compareTo(entry.getKey())<0){
                index++;
            }


            list.add(index, entry.getValue());
            word.add(index, entry.getKey());


        }


        return word.subList(0, k);




        }



        /*Note:
        * Complexity seems to be high but does not matter
        * */





}




