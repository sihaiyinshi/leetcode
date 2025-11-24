package Easy;

import java.util.HashMap;

/**
 * Given an array nums of size n, return the majority element.
 *
 * The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [3,2,3]
 * Output: 3
 * Example 2:
 *
 * Input: nums = [2,2,1,1,1,2,2]
 * Output: 2
 *
 *
 * Constraints:
 *
 * n == nums.length
 * 1 <= n <= 5 * 104
 * -109 <= nums[i] <= 109
 *
 *
 * Follow-up: Could you solve the problem in linear time and in O(1) space?
 *
 * */

public class MajorityElement169 {




    public static void main(String[] args) {

    }



    public int majorityElement(int[] nums) {

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {

            if(map.get(nums[i]) != null && map.get(nums[i]) + 1 > nums.length/2) {
                return nums[i];
            }

            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);

        }

        return nums[0];

    }


    public int majorityElement2(int[] nums) {


        int count=0;
        int candidate=0;


        for(int num:nums){

            if(count==0){
                candidate=num;
            }

            if(num==candidate){
                count++;
            }
            else{
                count--;
            }

        }
        return candidate;
    }


    /*Note: Moore Voting Algorithm is only available in this specified question
    *
    *
    * */




}
