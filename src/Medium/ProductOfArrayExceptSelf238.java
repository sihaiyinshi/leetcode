package Medium;
/**
 * Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
 *
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 *
 * You must write an algorithm that runs in O(n) time and without using the division operation.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,4]
 * Output: [24,12,8,6]
 * Example 2:
 *
 * Input: nums = [-1,1,0,-3,3]
 * Output: [0,0,9,0,0]
 *
 *
 * Constraints:
 *
 * 2 <= nums.length <= 105
 * -30 <= nums[i] <= 30
 * The input is generated such that answer[i] is guaranteed to fit in a 32-bit integer.
 *
 *
 * Follow up: Can you solve the problem in O(1) extra space complexity? (The output array does not count as extra space for space complexity analysis.)
 *
 *
 * */
public class ProductOfArrayExceptSelf238 {

    public static void main(String[] args) {


        System.out.println(productExceptSelf(new int[]{-1,1,0,-3,3}));

    }


    public static int[] productExceptSelf(int[] nums) {






            int[] result = new int[nums.length];
            int pro=1;
            for(int i=0; i<nums.length; i++){
                result[i]=pro;
                pro*=nums[i];
            }

            pro=1;

            for(int i=nums.length-1; i>=0; i--){
                result[i]*=pro;
                pro*=nums[i];
            }

            return result;

            /*
            * Point: Although you can only get the PRODUCT OF EVERY NUMBER FRONT OF IT, it becomes the real number when you do it reversely the second time.
            *
            * And the time complexity will only be O(2N)
            *
            * */



            /*
            int[] result = new int[nums.length];
            HashSet<Integer> set0 = new HashSet<>();

            int pro=1;
            for (int i=0; i<nums.length; i++) {
                if(nums[i]!=0) {
                    pro *= nums[i];
                }
                else{
                    set0.add(i);
                }
            }

            if(set0.size()==0) {
                for(int j=0; j<nums.length; j++){
                    result[j]=pro/nums[j];
                }
                return result;
            }
            else if(set0.size()==1) {
                for(int j=0; j<nums.length; j++){
                    if(!set0.contains(j)) {
                        result[j] = 0;
                    }
                    else{
                        result[j] = pro;
                    }
                }
                return result;

            }
            else{
                for(int j=0; j<nums.length; j++){
                        result[j] = 0;
                }
                return result;
            }*/








    }


}
