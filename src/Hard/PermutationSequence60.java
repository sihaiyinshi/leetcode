package Hard;

import java.util.ArrayList;
/**
 * The set [1, 2, 3, ..., n] contains a total of n! unique permutations.
 *
 * By listing and labeling all of the permutations in order, we get the following sequence for n = 3:
 *
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * Given n and k, return the kth permutation sequence.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 3, k = 3
 * Output: "213"
 * Example 2:
 *
 * Input: n = 4, k = 9
 * Output: "2314"
 * Example 3:
 *
 * Input: n = 3, k = 1
 * Output: "123"
 *
 *
 * Constraints:
 *
 * 1 <= n <= 9
 * 1 <= k <= n!
 * */

public class PermutationSequence60 {


    public static void main(String[] args) {


        for(int i=1;i<=24;i++){
            System.out.println(getPermutation(4,i));
        }

    }



    public static String getPermutation(int n, int k) {



        ArrayList<Integer> list = new ArrayList<>();
        for(int i=1;i<=n;i++){
            list.add(i);
        }

        int div=1;
        for(int i=1;i<n;i++){
            div*=i;
        }

        StringBuilder sb = new StringBuilder();


        int num=n-1;
        while(num>0){

            int index = (k-1)/div;
            sb.append(list.get(index));
            list.remove(index);

            if(k%div!=0) {
                k %= div;
            }
            else{
                k = div;
            }
            div/=num;
            num--;

        }
        sb.append(list.get(0));




        return sb.toString();




    }

    /*Note: It is the first time to debate a:
    * 1. permutation question
    * 2. hard question
    * */


}
