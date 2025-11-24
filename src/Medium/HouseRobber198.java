package Medium;
/**
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
 *
 * Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,1]
 * Output: 4
 * Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
 * Total amount you can rob = 1 + 3 = 4.
 * Example 2:
 *
 * Input: nums = [2,7,9,3,1]
 * Output: 12
 * Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
 * Total amount you can rob = 2 + 9 + 1 = 12.
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 400
 * */

import java.util.Arrays;

public class HouseRobber198 {


    public static void main(String[] args) {


        System.out.println(rob(new int[]{1, 2, 3, 1}));
        System.out.println(rob(new int[]{2,7,9,3,1}));
        System.out.println(rob(new int[]{2,1,1,2}));
        System.out.println(rob(new int[]{6,3,10,8,2,10,3,5,10,5,3}));
    }


    public static int rob(int[] nums) {

        if(nums.length<=1){
            return nums[0];
        }
        else if(nums.length==2){
            return Math.max(nums[0],nums[1]);
        }


        int[]dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = nums[1];

        for(int i=2;i<nums.length;i++){
            dp[i]=nums[i]+Math.max(maximumInArray(Arrays.copyOfRange(dp,0,i-2)),dp[i-2]);
        }

        return Math.max(dp[nums.length-2],dp[nums.length-1]);

    }

    public static int maximumInArray(int[] nums) {
        if(nums.length==0){
            return -1;
        }
        int max = nums[0];
        for(int i=0;i<nums.length;i++){
            if(nums[i]>max){
                max = nums[i];
            }
        }
        return max;
    }

/*Notes:
* I think the code can be even more simplified but I am not wanna for that
*
* */



}
