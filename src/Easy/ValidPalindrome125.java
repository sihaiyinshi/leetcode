package Easy;

/**
 * A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.
 *
 * Given a string s, return true if it is a palindrome, or false otherwise.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "A man, a plan, a canal: Panama"
 * Output: true
 * Explanation: "amanaplanacanalpanama" is a palindrome.
 * Example 2:
 *
 * Input: s = "race a car"
 * Output: false
 * Explanation: "raceacar" is not a palindrome.
 * Example 3:
 *
 * Input: s = " "
 * Output: true
 * Explanation: s is an empty string "" after removing non-alphanumeric characters.
 * Since an empty string reads the same forward and backward, it is a palindrome.
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 2 * 105
 * s consists only of printable ASCII characters.
 * */

public class ValidPalindrome125 {


    public static void main(String[] args) {

        //System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
        //System.out.println(isPalindrome("race a car"));
        //System.out.println(isPalindrome(" "));
        //System.out.println(isPalindrome(""));
        System.out.println(isPalindrome("0P"));


    }


    public static boolean isPalindrome(String s) {

        if(s == null || s.length() == 0) return true;

        int p1=0;
        int p2=s.length()-1;

        while(p1<p2){
            if(!isLetter(s.charAt(p1))){
                p1++;
            }
            else if(!isLetter(s.charAt(p2))){
                p2--;
            }
            else if(compareIgnoreCapital(s.charAt(p1),s.charAt(p2))){
                p1++;
                p2--;
            }
            else{
                return false;
            }
        }

        return true;

    }


    public static boolean isLetter(char ch) {
        return ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z') || ch >= '0' && ch <= '9');
    }

    public static boolean compareIgnoreCapital(char a, char b) {
        String str1 = String.valueOf(a);
        String str2 = String.valueOf(b);
        return str1.equalsIgnoreCase(str2);
    }

    /*Note:
     * Complete it in only 11 mins including everything
     * */


}
