package Medium;

import java.util.*;
/**
 * Given a string s which represents an expression, evaluate this expression and return its value.
 *
 * The integer division should truncate toward zero.
 *
 * You may assume that the given expression is always valid. All intermediate results will be in the range of [-231, 231 - 1].
 *
 * Note: You are not allowed to use any built-in function which evaluates strings as mathematical expressions, such as eval().
 *
 *
 *
 * Example 1:
 *
 * Input: s = "3+2*2"
 * Output: 7
 * Example 2:
 *
 * Input: s = " 3/2 "
 * Output: 1
 * Example 3:
 *
 * Input: s = " 3+5 / 2 "
 * Output: 5
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 3 * 105
 * s consists of integers and operators ('+', '-', '*', '/') separated by some number of spaces.
 * s represents a valid expression.
 * All the integers in the expression are non-negative integers in the range [0, 231 - 1].
 * The answer is guaranteed to fit in a 32-bit integer.
 * */

public class BasicCalculatorII227 {



    public static void main(String[] args) {


        //System.out.println(calculate2("3+5+7*9/3-5-6"));
        System.out.println(calculate2("1-1+1"));


    }



    //Time complexity of O(n^2)
    public static int calculate(String s) {


        String[] tokens = s.split("\\+");
        int[] nums = new int[tokens.length];

        for (int i = 0; i < tokens.length; i++) {

            String[] minus= tokens[i].split("-");
            int[] minusNums = new int[minus.length];


            for(int j=0;j<minus.length;j++){




                Queue<Integer> num=new LinkedList<>();
                Queue<Character> ops=new LinkedList<>();

                String temp="";
                for(int k=0;k<minus[j].length();k++){

                    if(minus[j].charAt(k)==' '){
                        continue;
                    }


                    if(!Character.isDigit(minus[j].charAt(k))){
                        num.offer(Integer.parseInt(temp));
                        temp="";
                        ops.offer(minus[j].charAt(k));
                    }
                    else{
                        temp+=minus[j].charAt(k);
                    }
                }
                num.offer(Integer.parseInt(temp));

                int sum=num.poll();
                while(!ops.isEmpty()) {

                    if (ops.poll()=='*') {
                        sum *= num.poll();
                    } else {
                        sum /= num.poll();
                    }


                }
                minusNums[j] = sum;





            }


            int sum=0;
            for(int k=0;k<minusNums.length;k++){
                if(k==0){
                    sum+=minusNums[k];
                }
                else{
                    sum-=minusNums[k];
                }
            }

            nums[i]=sum;
        }

        int result=0;
        for(int k=0;k<nums.length;k++){
            result+=nums[k];
        }

        return result;

        }


        //time complexity of O(n)
        public static int calculate2(String s) {
            int temp=0;

            Integer mult=null;
            Integer div=null;
            boolean negative=false;
            List<Integer> list=new ArrayList<>();


            for (int i = 0; i < s.length(); i++) {

                char c = s.charAt(i);

                if(isDigit(c)){

                    if(temp!=0){
                        temp*=10;
                    }
                    temp+=charToInt(c);


                }
                else if (c == '+' || c == '-' || c == '*' || c == '/') {

                    if(mult!=null) {
                        temp=mult*temp;
                        mult=null;
                    }
                    else if(div!=null){
                        temp=div/temp;
                        div=null;
                    }


                    if(negative){
                        temp=-temp;
                    }


                    if(c=='+'){
                        list.add(temp);
                        negative=false;
                        temp=0;
                    }
                    else if(c=='-'){
                        list.add(temp);
                        negative=true;
                        temp=0;
                    }
                    else if(c=='*'){
                        mult=temp;
                        negative=false;
                        temp=0;
                    }
                    else {
                        div=temp;
                        negative=false;
                        temp=0;
                    }

                }
                else if(c!=' '){
                    return 0;
                }

            }



            if(mult!=null) {
                list.add(mult*temp);
            }
            else if(div!=null){
                list.add(div/temp);
            }
            else {
                list.add(negative ? -temp : temp);
            }

            int result=0;
            for(int i:list){
                result+=i;
            }

            return result;

        }


        public static boolean isDigit(char ch) {

            return ch >= '0' && ch <= '9';

        }

        public static int charToInt(char ch) {
            return ch - '0';
        }

        /*Note:
        * only the fault of optimization
        *
        * */


}
