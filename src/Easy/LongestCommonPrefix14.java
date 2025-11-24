package Easy;
/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 *
 * If there is no common prefix, return an empty string "".
 *
 *
 *
 * Example 1:
 *
 * Input: strs = ["flower","flow","flight"]
 * Output: "fl"
 * Example 2:
 *
 * Input: strs = ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 *
 *
 * Constraints:
 *
 * 1 <= strs.length <= 200
 * 0 <= strs[i].length <= 200
 * strs[i] consists of only lowercase English letters if it is non-empty.
 * */


public class LongestCommonPrefix14 {

    public static void main(String[] args) {


        //System.out.println(longestCommonPrefix(new String[]{"flower","flow","flight"}));
        System.out.println(longestCommonPrefix(new String[]{"dog","break","car"}));
        System.out.println(longestCommonPrefix(new String[]{"","",""}));
        System.out.println(longestCommonPrefix(new String[]{"","b"}));
        System.out.println(longestCommonPrefix(new String[]{"aaa","aa","aaa"}));


    }

    public static String longestCommonPrefix(String[] strs) {

        if(strs[0].isEmpty()) {
            return "";
        }

        String res=strs[0];


        for(int i=1;i<strs.length;i++) {
            StringBuilder sb=new StringBuilder();
            for(int j=0;j<strs[i].length();j++) {

                if(j>strs[i].length()-1 || j>res.length()-1 || res.charAt(j)!=strs[i].charAt(j)){
                    break;
                }
                sb.append(strs[i].charAt(j));

            }

            if(sb.length()==0) {
                return "";
            }

            res=sb.toString();

        }

        return res;
    }
/*Note: it is not so simple as it looks like
*
*
*
* */


}
