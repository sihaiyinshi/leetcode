package Easy;


/**
 * You are climbing a staircase. It takes n steps to reach the top.
 *
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 *
 *
 *
 * Example 1:
 *
 * Input: n = 2
 * Output: 2
 * Explanation: There are two ways to climb to the top.
 * 1. 1 step + 1 step
 * 2. 2 steps
 * Example 2:
 *
 * Input: n = 3
 * Output: 3
 * Explanation: There are three ways to climb to the top.
 * 1. 1 step + 1 step + 1 step
 * 2. 1 step + 2 steps
 * 3. 2 steps + 1 step
 *
 *
 * Constraints:
 *
 * 1 <= n <= 45
 * */

public class ClimbingStairs70 {


    public static void main(String[] args) {


        //System.out.println(climbStairs(1));
        //System.out.println(climbStairs(2));
        System.out.println(climbStairs(3));
        System.out.println(climbStairs(4));
        System.out.println(climbStairs(5));
        System.out.println(climbStairs(6));

    }

    /*
    public static int climbStairs(int n) {

        if (n <= 2) return n;

        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];


    }*/



    public static int climbStairs(int n) {

        if (n <= 2) return n;

        int []dp=new int[3];
        dp[0]=1;
        dp[1]=2;

        int loc=2;

        for(int i=3;i<=n;i++){


            dp[loc]=dp[(loc+2)%3]+dp[(loc+1)%3];
            loc++;
            loc=loc%3;

        }

        return dp[(loc+2)%3];


    }

    /*Notes: It's everything about Numero di Fibonacci
    * */

}
