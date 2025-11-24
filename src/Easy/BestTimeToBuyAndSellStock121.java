package Easy;
/**
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 *
 * You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
 *
 * Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
 *
 *
 *
 * Example 1:
 *
 * Input: prices = [7,1,5,3,6,4]
 * Output: 5
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 * Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
 * Example 2:
 *
 * Input: prices = [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transactions are done and the max profit = 0.
 *
 *
 * Constraints:
 *
 * 1 <= prices.length <= 105
 * 0 <= prices[i] <= 104
 *
 * */
public class BestTimeToBuyAndSellStock121 {




    public static void main(String[] args) {


        System.out.println(maxProfit(new int[]{7,1,5,3,6,4}));
        System.out.println(maxProfit(new int[]{7,6,4,3,1}));

    }







    public static int maxProfit(int[] prices) {

        int min=prices[0];
        int maxProfit=0;




        for(int i=1;i<prices.length;i++){

            if(prices[i]<min){
                min=prices[i];
            }
            else if(prices[i] - min > maxProfit){
                maxProfit=prices[i] - min;
            }

        }

        return maxProfit;

    }
    /* Note: The kadane algorithm is implemented within the process
    *
    * Introduction to Kadane algorithm:
    *
    * What it is for: find the maximum subarray
    *
    * How it works:
    * 1. start with two variables, currentMax & globalMax
    * 2. when meets a new element, make a decision:
    *       if newElement >  currentMax + newElement, start a new subarray, store globalMax if larger than it
    *       else continue the subarray
    *
    *
    * In this example, we implement it as below:
    * 1. start with two variables, currentGap(unseen, shown as prices[i] - min) & globalGap
    * 2. when meets a new element, make a decision:
    *       update the globalMin if min is smaller
    *       if currentGap > globalGap, update the globalGap
    *
    *
    * */

}
