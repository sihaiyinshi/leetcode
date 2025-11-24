package Easy;

import java.util.Arrays;

/**
 * Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,1]
 *
 * Output: true
 *
 * Explanation:
 *
 * The element 1 occurs at the indices 0 and 3.
 *
 * Example 2:
 *
 * Input: nums = [1,2,3,4]
 *
 * Output: false
 *
 * Explanation:
 *
 * All elements are distinct.
 *
 * Example 3:
 *
 * Input: nums = [1,1,1,3,3,4,3,2,4,2]
 *
 * Output: true
 *
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 * */


public class ContainsDuplicate217 {


    public static void main(String[] args) {

        System.out.println(containsDuplicate(new int[]{1, 2, 3, 1}));

    }



    public static boolean containsDuplicate(int[] nums) {
        if(nums.length <2){
            return false;
        }

        Arrays.sort(nums);

        for(int i=1;i<nums.length;i++){
            if(nums[i] == nums[i-1]){
                return true;
            }
        }
        return false;

    }


    /*
    public static boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if(set.contains(num)) {
                return true;
            }

            set.add(num);

        }
        return false;


    }*/

}


/*Note:
 * Hint:
 * I have nothing to state
 * */
