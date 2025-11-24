package Medium; /**
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 3
 * Output: ["((()))","(()())","(())()","()(())","()()()"]
 * Example 2:
 *
 * Input: n = 1
 * Output: ["()"]
 *
 *
 * Constraints:
 *
 * 1 <= n <= 8
 * */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GenerateParentheses22 {


    public static void main(String[] args) {


        System.out.println(generateParenthesis(3));
    }

    public static List<String> generateParenthesis(int n) {


        List<String> res = new ArrayList<>();

        Queue<Object> queue = new LinkedList<>();
        Integer left=0;
        Integer right=0;
        String s="";
        queue.offer(left);
        queue.offer(right);
        queue.offer(s);

        while(!queue.isEmpty()){
            left= (Integer) queue.poll();
            right= (Integer) queue.poll();
            s= (String) queue.poll();


            if(s.length()==n*2){
                res.add(s.toString());
            }

            if(left<n){
                queue.offer(left+1);
                queue.offer(right);
                queue.offer(s+"(");
            }

            if(right<left){
                queue.offer(left);
                queue.offer(right+1);
                queue.offer(s+")");

            }
        }



       // generateParenthesis(res,0,0,"",n);
        return res;

    }

    public static void generateParenthesis(List list, int left, int right,String s, int n) {

        if(s.length()==n*2){
            list.add(s);
            return;
        }

        if(left<n){
            generateParenthesis(list,left+1,right,s+"(",n);
        }

        if(right<left){
            generateParenthesis(list,left,right+1,s+")",n);

        }

    }


    /*Note:
     * Unknown:
     * Recursive
     *
     * My opinion:
     * Maybe it can be solved with tree and recursive
     *
     * His opinion:
     * 1. recursive differs at the two different conditions
     * 2. return when reaches the ruled length
     *
     * Hint:
     * 1. the problem of such heap should be solved with recursive but nothing else
     * 2. improve the maturity of recursive and transform the recursive into the loop
     * */





}
