package Medium;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated sequence of one or more dictionary words.
 *
 * Note that the same word in the dictionary may be reused multiple times in the segmentation.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "leetcode", wordDict = ["leet","code"]
 * Output: true
 * Explanation: Return true because "leetcode" can be segmented as "leet code".
 * Example 2:
 *
 * Input: s = "applepenapple", wordDict = ["apple","pen"]
 * Output: true
 * Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
 * Note that you are allowed to reuse a dictionary word.
 * Example 3:
 *
 * Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
 * Output: false
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 300
 * 1 <= wordDict.length <= 1000
 * 1 <= wordDict[i].length <= 20
 * s and wordDict[i] consist of only lowercase English letters.
 * All the strings of wordDict are unique.
 *
 * */




public class WordBreak139 {




    public static void main(String[] args) {



        List<String> list = new ArrayList<>();

        list=new ArrayList<>();
        list.add("b");
        list.add("bbb");
        list.add("bbbb");
        list.add("a");
        System.out.println(wordBreak("bb",list));


        /*
        list.add("apple");
        list.add("pen");
        System.out.println(wordBreak("applepenapple",list));

        list.add("cats");
        list.add("dog");
        list.add("sand");
        list.add("cat");
        list.add("cat");
        System.out.println(wordBreak("catsandog",list));




        list=new ArrayList<>();
        list.add("leet");
        list.add("code");
        System.out.println(wordBreak("leetcode",list));


        list=new ArrayList<>();
        list.add("aaa");
        list.add("aaaa");
        System.out.println(wordBreak("aaaaaaa",list));*/



    }

    public static boolean wordBreak(String s, List<String> wordDict) {




        boolean[] dp = new boolean[s.length()+1];
        for(String word: wordDict){

            if(word.length()>s.length()){
                continue;
            }

            if(s.substring(0,word.length()).equals(word)){
                dp[word.length()] = true;
            }

        }



        for(int i=0; i<s.length(); i++){



            if(dp[i]){

                for(String word: wordDict){

                    if(i+word.length() > s.length()){
                        continue;
                    }

                    if(s.substring(i,i+word.length()).equals(word)){
                        dp[i+word.length()] = true;
                    }


                }

            }




        }

        return dp[dp.length-1];

        /*Note:
        * Dynamic programming sucks
        * */





    }














}
