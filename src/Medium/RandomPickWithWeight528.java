package Medium;

import java.util.Arrays;
import java.util.Random;

public class RandomPickWithWeight528 {


    public static class Solution{


        //int sum;
        int[] w;
        public Solution(int[] w) {
            this.w=w;
        }

        public int pickIndex() {
            int r= new Random().nextInt(Arrays.stream(w).sum())+1;
            int sum=0;
            for(int i=0;i<w.length;i++){
                sum+=w[i];
                if(r<=sum){
                    return i;
                }
            }
            return w.length-1;
        }


    }


    public static void main(String[] args) {


        Solution solution = new Solution(new int[]{3,1});
        System.out.println(solution.pickIndex());
        System.out.println(solution.pickIndex());
        System.out.println(solution.pickIndex());
        System.out.println(solution.pickIndex());
        System.out.println(solution.pickIndex());
    }






}
