import java.util.Arrays;
import java.util.Stack;

public class DailyTemperatures739 {


    public static void main(String[] args) {


        //System.out.println(Arrays.toString(dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73})));
        System.out.println(Arrays.toString(dailyTemperatures3(new int[]{73, 74, 75, 71, 69, 72, 76, 73})));
    }











    public static int[] dailyTemperatures(int[] temperatures) {

        int[] res = new int[temperatures.length];

        for (int i = 0; i < temperatures.length - 1; i++) {

            for (int j = i+1; j < temperatures.length; j++) {
                if (temperatures[j]>temperatures[i]) {
                    res[i] = j-i;
                    break;
                }
            }


        }
        res[res.length-1] = 0;
        return res;

    }


    public static int[] dailyTemperatures2(int[] temperatures) {



        int p1 = 0, p2 = 0;
        int[] res = new int[temperatures.length];

        while (p1 < temperatures.length && p2 < temperatures.length) {

            if(temperatures[p1]>=temperatures[p2]) {
                p2++;
                continue;
            }


            res[p1] = p2-p1;
            p1++;
            p2=p1;


        }
        return res;



    }


    public static int[] dailyTemperatures3(int[] temperatures) {




        Stack<Integer> stack = new Stack<>();
        int[] res = new int[temperatures.length];


        for (int i = 0; i < temperatures.length; i++) {

            while(!stack.isEmpty() && temperatures[stack.peek()]>temperatures[i]) {
                int index = stack.pop();
                res[index] = i-index;


            }


            stack.push(i);
        }

        return res;




    }



}
