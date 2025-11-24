package Easy;

import java.util.Arrays;

/**
 Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.

 Note that you must do this in-place without making a copy of the array.



 Example 1:

 Input: nums = [0,1,0,3,12]
 Output: [1,3,12,0,0]
 Example 2:

 Input: nums = [0]
 Output: [0]


 Constraints:

 1 <= nums.length <= 104
 -231 <= nums[i] <= 231 - 1
 */
public class MoveZeroes283 {
    public static void main(String[] args) {
        int[] nums = {4,2,4,0,0,3,0,5,1,0};
        moveZeroes(nums);
        for(int i=0; i<nums.length; i++){
            System.out.print(nums[i]+" ");
        }


    }

    static void moveZeroes(int[] nums) {
        int[] num=new int[nums.length];
        Arrays.fill(num,0);
        int count=0;
        for(int i=0; i<nums.length; i++){
            if(nums[i]==0){
                continue;
            }
            num[count]=nums[i];
            count++;
        }

        for(int i=0; i<nums.length; i++){
            nums[i]=num[i];
        }









        /*
        if(nums.length<2){
            return;
        }


        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                int j=i;
                for(;j<nums.length;j++){
                    if(nums[j]!=0){
                       break;
                    }
                }
                j=j-i;







                for(int k=i;k<nums.length-j;k++){
                    nums[k]=nums[k+j];
                }

                for(int l=nums.length-j;l<nums.length;l++){
                    nums[l]=0;
                }

                //nums[nums.length-1]=0;

            }
        }

         */

        /*Note:
        * Nothing to specify
        * */

    }





}
