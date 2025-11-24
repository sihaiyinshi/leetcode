package ToBeSolved;

/**
 * Implement pow(x, n), which calculates x raised to the power n (i.e., xn).
 *
 *
 *
 * Example 1:
 *
 * Input: x = 2.00000, n = 10
 * Output: 1024.00000
 * Example 2:
 *
 * Input: x = 2.10000, n = 3
 * Output: 9.26100
 * Example 3:
 *
 * Input: x = 2.00000, n = -2
 * Output: 0.25000
 * Explanation: 2-2 = 1/22 = 1/4 = 0.25
 *
 *
 * Constraints:
 *
 * -100.0 < x < 100.0
 * -231 <= n <= 231-1
 * n is an integer.
 * Either x is not zero or n > 0.
 * -104 <= xn <= 104
 * */


public class Powxn50 {

    public static void main(String[] args) {

        //System.out.println(myPow(2.0,-2));
        System.out.println(myPow(2.0,-2147483648));

    }


    public static double myPow(double x, int n) {



        if(n < 0){
            n = -n;
            x = 1 / x;
        }

        double pow = 1;

        while(n != 0){
            if((n & 1) != 0){
                pow *= x;
            }

            x *= x;
            n >>>= 1;

        }

        return pow;


        //return n%2==0?myPow(x,n/2)*myPow(x,n/2):x*myPow(x,n/2)*myPow(x,n/2);





        /*

        if(x==1.0){
            return 1.0;
        }
        else if(x==-1){
            return n%2==0?1.0:-1.0;
        }
        else if(n==-2147483648){
            return 0.0;
        }


        if(n>0) {
            double result=1;
            for (int i=0;i<n;i++) {
                result*=x;

                if(result >=10000.0 || result <=-10000.0) {
                   return 0.0;
                }


            }
            return result;
        }
        else if (n==0) {
            return 1;
        }
        else {
            double result=1;
            for (int i=0;i<-n;i++) {
                result*=1/x;

                if(result >=10000.0 || result <=-10000.0) {
                    return 0.0;
                }


            }
            return result;
        }
*/

    }
    /*Note:
     * It is quite sob
     * */

}
