package Medium;

/**
 * Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.
 *
 * If target is not found in the array, return [-1, -1].
 *
 * You must write an algorithm with O(log n) runtime complexity.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 * Example 2:
 *
 * Input: nums = [5,7,7,8,8,10], target = 6
 * Output: [-1,-1]
 * Example 3:
 *
 * Input: nums = [], target = 0
 * Output: [-1,-1]
 *
 *
 * Constraints:
 *
 * 0 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 * nums is a non-decreasing array.
 * -109 <= target <= 109
 * */

public class FindFirstandLastPositionofElementinSortedArray34 {


    public static void main(String[] args) {


        System.out.println(searchRange(new int[]{5,7,7,8,8,10}, 8)[0]);
        System.out.println(searchRange(new int[]{5,7,7,8,8,10}, 8)[1]);

        /*
        System.out.println(searchRange(new int[]{1,2,3,4,5,7,7,8,8,10,11}, 8)[0]);
        System.out.println(searchRange(new int[]{1,2,3,4,5,7,7,8,8,10,11}, 8)[1]);


        System.out.println(searchRange(new int[]{1,2,3,4,5,7,7,8,8,8,8,8,8,8,10,11}, 7)[0]);
        System.out.println(searchRange(new int[]{1,2,3,4,5,7,7,8,8,8,8,8,8,8,10,11}, 7)[1]);*/


    }


    static int[] searchRange(int[] nums, int target) {

        if(nums.length==0) return new int[]{-1,-1};

        return new int[]{searchRange(nums,target,true),searchRange(nums,target,false)};

    }



    static int searchRange(int[] nums, int target,boolean findStart) {
        int start=0;
        int end=nums.length-1;
        //int mid=(start+end)/2;
        int ans=-1;



        while(start<=end){
            int mid=start+(end-start)/2;

            if(target<nums[mid]){
                end=mid-1;
            }
            else if(target>nums[mid]){
                start=mid+1;
            }
            else{
                ans=mid;
                if(findStart){
                    end=mid-1;
                }
                else{
                    start=mid+1;
                }
            }
        }


        return ans;

    }
    /*Note:
     * Hint:
     * The problem with the rule of complexity of O(logn) includes the use of binary division
     * */

}
