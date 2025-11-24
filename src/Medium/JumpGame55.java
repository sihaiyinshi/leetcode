package Medium;

/**
 *
 * You are given an integer array nums. You are initially positioned at the array's first index, and each element in the array represents your maximum jump length at that position.
 *
 * Return true if you can reach the last index, or false otherwise.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [2,3,1,1,4]
 * Output: true
 * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
 * Example 2:
 *
 * Input: nums = [3,2,1,0,4]
 * Output: false
 * Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 104
 * 0 <= nums[i] <= 105
 * */

public class JumpGame55 {


    public static void main(String[] args) {

        System.out.println(canJump(new int[]{2, 3, 1, 1, 4}));
        System.out.println(canJump(new int[]{3,2,1,0,4}));

    }

    public static boolean canJump(int[] nums) {




        boolean[] dp = new boolean[nums.length];
        dp[0] = true;

        for(int i=0; i<nums.length; i++){

            if(dp[i]){
                for(int j=i+1; j<Math.min(nums.length,nums[i]+i+1); j++){
                    dp[j]=true;
                }
            }

        }

        return dp[nums.length-1];






    }

    /*Note:
     * Unknown:
     *
     * My opinion:
     * use DP calculate every step
     *
     * His opinion:
     * Backward from the end to confirm it's able to reach the begin
     *
     * Hint:
     * Any operation includes the number included operation would cause the complexity rises to O(n^2), try not to do operation to the array via the number
     * */


}
