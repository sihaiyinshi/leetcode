package Medium;

import java.util.Arrays;

public class PerfectSquares279 {


    public static void main(String[] args) {



        System.out.println(numSquares2(12));

    }


    public static int numSquares2(int n) {



        int[] dp=new int[n+1];
        Arrays.fill(dp,n);
        dp[0]=0;
        int[] squareNum=new int[closestSquare(n)];
        for(int i=0;i<squareNum.length;i++){
            squareNum[i]=(i+1)*(i+1);
        }

        for(int square:squareNum){
            for(int i=square;i<dp.length;i++){

                dp[i]=Math.min(dp[i],dp[i-square]+1);

            }
        }


        return dp[dp.length-1];

    }

    public static int closestSquare(int n) {
        return (int)Math.sqrt(n);
    }

    public static int numSquares(int n) {


        int count=0;
        while(n>0){
            n-=closestSquareNum(n);
            count++;
        }
        return count;

    }

    public static int closestSquareNum(int n) {
        int m=(int)Math.sqrt(n);
        return m*m;

    }






}
