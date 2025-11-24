package Medium;
/**
 *
 *Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.
 *
 * There is only one repeated number in nums, return this repeated number.
 *
 * You must solve the problem without modifying the array nums and using only constant extra space.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,3,4,2,2]
 * Output: 2
 * Example 2:
 *
 * Input: nums = [3,1,3,4,2]
 * Output: 3
 * Example 3:
 *
 * Input: nums = [3,3,3,3,3]
 * Output: 3
 *
 *
 * Constraints:
 *
 * 1 <= n <= 105
 * nums.length == n + 1
 * 1 <= nums[i] <= n
 * All the integers in nums appear only once except for precisely one integer which appears two or more times.
 *
 *
 * Follow up:
 *
 * How can we prove that at least one duplicate number must exist in nums?
 * Can you solve the problem in linear runtime complexity?
 * */

public class FindTheDuplicateNumber287 {





    public static void main(String[] args) {




    System.out.println(findDuplicate2(new int[]{3,1,3,4,2}));


    }


    public static int findDuplicate2(int[] nums) {

        int index=-1;
        for(int i = 0; i < nums.length; i++){

            index= nums[i] >100000?nums[i] - 100000 : nums[i];

            if(nums[index] > 100000){
                break;
            }

            nums[index] = nums[index] + 100000;

        }


        for(int i = 0; i < nums.length; i++){

            if(nums[i]>100000){
                nums[i]=nums[i]-100000;
            }

        }


        return index;

    }


    public static int findDuplicate(int[] nums) {

        int index=-1;
        for(int i = 0; i < nums.length; i++){

            index= Math.abs(nums[i]);

            if(nums[index] < 0){
                break;
            }

            nums[index] = -nums[index];

        }


        for(int i = 0; i < nums.length; i++){

            if(nums[i]<0){
                nums[i]=-nums[i];
            }

        }


        return index;

    }

/*
* Intuition
I understand it's not so easy to remind of the method with Floyd's Tortoise and Hare algorithm application, so why not try some other methods?

Let's see the limitation first:

1. space complexity O(1)
2. no array modification allowed
3. 1 <= n <= 100000

Seems we can not reach it without fast and slow algorithm. But wait, shall we just modify the number to find the duplicate one via marking it out of range, and modify it back in the end to make it seems not modified?

Approach
find the duplicate by array modification, notice that since 1 <= nums[i] <= n , we can ensure the nums[i] would always locate within the array and NPE would not occur. And we just mark every unduplicate nunmber out of range.
reduct the number out of range into the original one
Complexity
Time complexity:O(n)
Space complexity:O(1)
Code
class Solution {
    public int findDuplicate(int[] nums) {
        int index=-1;
        for(int i = 0; i < nums.length; i++){
            index= Math.abs(nums[i]);
            if(nums[index] < 0){
                break;
            }
            nums[index] = -nums[index];
        }

        for(int i = 0; i < nums.length; i++){
            if(nums[i]<0){
                nums[i]=-nums[i];
            }
        }
        return index;
    }
}
class Solution {
    public int findDuplicate(int[] nums) {
        int index=-1;
        for(int i = 0; i < nums.length; i++){
            index= nums[i] >100000?nums[i] - 100000 : nums[i];
            if(nums[index] > 100000){
                break;
            }
            nums[index] = nums[index] + 100000;

        }

        for(int i = 0; i < nums.length; i++){
            if(nums[i]>100000){
                nums[i]=nums[i]-100000;
            }
        }
        return index;
    }
}

*
* */

}
