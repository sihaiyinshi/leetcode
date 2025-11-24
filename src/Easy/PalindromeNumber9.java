package Easy;


/**
 *
 *
 *Given an integer x, return true if x is a palindrome, and false otherwise.
 *
 *
 *
 * Example 1:
 *
 * Input: x = 121
 * Output: true
 * Explanation: 121 reads as 121 from left to right and from right to left.
 * Example 2:
 *
 * Input: x = -121
 * Output: false
 * Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
 * Example 3:
 *
 * Input: x = 10
 * Output: false
 * Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 *
 *
 * Constraints:
 *
 * -231 <= x <= 231 - 1
 *
 *
 * Follow up: Could you solve it without converting the integer to a string?
 *
 * */

public class PalindromeNumber9 {





    public static void main(String[] args) {

        System.out.println(isPalindrome2(731371));

    }





    public static boolean isPalindrome(int x) {


        String str = String.valueOf(x);
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length / 2; i++) {
            if (chars[i] != chars[chars.length - 1 - i]) {
                return false;
            }

        }
        return true;


    }






    public static boolean isPalindrome2(int x) {


        if (x < 0) {
            return false;
        }
        else if (x == 0) {
            return true;
        }


        int digit= (int) Math.pow(10, (int)Math.log10(x));
        int base = 1;

        while(base < digit){

            int front=x/digit;
            int behind = (x - (x / (base * 10)) * (base * 10)) / base;

            if(front != behind){
                return false;
            }

            x-=front*digit;
            digit/=10;
            x-= behind * base;
            base*=10;

        }

        return true;


    }











/*Note:
* I finish it in way1 at first within only 30 seconds with auto-complete...
*
* But the second is a bit puzzling and spent real a time to find the exact value of behind...
*
*
*
* */



}
