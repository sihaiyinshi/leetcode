package Medium;

public class DecodeWays91 {


    public static void main(String[] args) {


        //System.out.println(numDecodings("226"));
        //System.out.println(numDecodings("2101"));
        //System.out.println(numDecodings("10"));
        //System.out.println(numDecodings("310"));
        //System.out.println(numDecodings("1234"));
        System.out.println(numDecodings("1201234"));
        System.out.println(numDecodings("121212"));
        //System.out.println(numDecodings("120"));
        //1/20/1/23/4
        //1/20/12/3/4
        //1/20/1/2/3/4


        /*
        11/23
        1/1/23
        1/12/3
        11/2/3
        1/1/2/3

        1123*/



        /*
        12/1/21
        1/21/21
        12/12/1
        1/2/1/21
        1/2/12/1
        1/21/2/1
        12/1/2/1
        1/2/1/2/1
        12121


        12/12
        1/2/12
        1/21/2
        12/1/2
        1/2/1/2
        5

        1212


        12/17
        1/2/17
        1/21/7
        12/1/7
        1/2/1/7
        5
        1217

        1/2/13
        1/21/3
        12/1/3
        12/13
        1/2/1/3
        5
        1213


        1/21
        12/1
        1/2/1
        3
        121

        1/23
        1
        123



        1/21
        12/1
        1/2/1

        212
        121*/


    }

    public static int numDecodings(String s) {


        if(s.charAt(0) == '0'){
            return 0;
        }


        int [] res = new int[s.length()+1];
        res[0] = 1;
        res[1] = 1;


        for(int i = 2; i < s.length() + 1 ; i++){


            if(s.charAt(i-1)>='1' && s.charAt(i-1)<='9'){
                res[i] += res[i-1];
            }


            if(s.charAt(i-2)=='1'){
                res[i] += res[i-2];
            }
            else if(s.charAt(i-2)=='2' && s.charAt(i-1)>='0' && s.charAt(i-1)<='6'){
                res[i] += res[i-2];
            }


        }

        return res[s.length()];

    }


}


/* Note: Everything about dynamic programming.
*
* Dynamic programming is quite tough for most and traps many often. This simple article would talk about the final solution to the dp.
*
*
* 1. What is DP?
* "Dynamic programming meant to break problems into subproblems and solve them."
* That is how wikipedia and official talks about it. However, this description gives the definition in a too high view, since we can easily find that, actually, the solution of every problem is break it into different subproblems and solve them.
* Hence, we would define the DP from what it ISN'T instead of what it IS. What DP ISN'T? In algorithm, DP is used to solve the problem that is not able to be solved with greedy algorithm. Then what is greedy algorithm?
* Here we may use an analogy. If the problem is find the best chance for a stock, then greedy algorithm only purchase once rises and sell once down, and DP finds from all the past tendency and find best point.
* After this analogy, we can make definition here: greedy only find the best at every step, and DP finds the best for every step.
*
* But we cannot look back each step so far for every step, since the complexity would become O(N^2) or even further.
* Hence, we can say
* */


































