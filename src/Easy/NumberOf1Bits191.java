/**
 *
 * Given a positive integer n, write a function that returns the number of set bits in its binary representation (also known as the Hamming weight).
 *
 *
 *
 * Example 1:
 *
 * Input: n = 11
 *
 * Output: 3
 *
 * Explanation:
 *
 * The input binary string 1011 has a total of three set bits.
 *
 * Example 2:
 *
 * Input: n = 128
 *
 * Output: 1
 *
 * Explanation:
 *
 * The input binary string 10000000 has a total of one set bit.
 *
 * Example 3:
 *
 * Input: n = 2147483645
 *
 * Output: 30
 *
 * Explanation:
 *
 * The input binary string 1111111111111111111111111111101 has a total of thirty set bits.
 *
 *
 *
 * Constraints:
 *
 * 1 <= n <= 231 - 1
 * */

package Easy;

public class NumberOf1Bits191 {

    public static void main(String[] args) {
            System.out.println(hammingWeight(2147483645));
    }


    public static int hammingWeight(int n) {


        int res = 1073741824;
        int count = 0;


        while(res>=1){
            if(n>=res){
                count++;
                n-=res;
            }
            res/=2;
        }


        return count;

        /*
        int count = 0;
        int[] array=new int[31];
        array[0]=1;
        for(int i=1;i<array.length;i++){
            array[i]=array[i-1]*2;
        }


        for(int i=array.length-1;i>=0;i--){
            if(n>=array[i]){
                count++;
                n-=array[i];
            }
        }

        return count;*/


    }

    /*Note:
    * Dahyou is muteki.
    *
    * */


}
