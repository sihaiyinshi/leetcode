package Easy; /**
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * You can return the answer in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
 * Example 2:
 *
 * Input: nums = [3,2,4], target = 6
 * Output: [1,2]
 * Example 3:
 *
 * Input: nums = [3,3], target = 6
 * Output: [0,1]
 *
 *
 * Constraints:
 *
 * 2 <= nums.length <= 104
 * -109 <= nums[i] <= 109
 * -109 <= target <= 109
 * Only one valid answer exists.
 * */

import java.util.HashMap;

public class TwoSum1 {


    public static void main(String[] args) {

        System.out.println(new TwoSum1().twoSum(new int[]{2, 7, 11, 15}, 9)[0]);
        System.out.println(new TwoSum1().twoSum(new int[]{2, 7, 11, 15}, 9)[1]);
        System.out.println(new TwoSum1().twoSum(new int[]{3,2,4}, 6)[0]);
        System.out.println(new TwoSum1().twoSum(new int[]{3,3}, 6)[0]);

    }


    public int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }

        return null;
    }



    /*
    //first result with complexity of O(N^2)
    public int[] twoSum(int[] nums, int target) {

        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]+nums[j]==target){
                    return new int[]{i,j};
                }
            }
        }

    return null;

    }*/


    /*Note:
     * Unknown:
     * 1. hashMap
     *
     * My opinion:
     * 1. directly compare and solve it
     *
     * His opinion:
     * 1. create a new has map
     * 2. store the location and value within a new hashmap pair
     * 3. find it in hashMap every time
     *
     * Hint:
     * 1. HashMap is able to store a whole array with its key included, and find a specific value within time of O(N)
     * */

}
