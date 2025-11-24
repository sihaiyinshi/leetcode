package Easy;
/**
 * Given an integer array nums where the elements are sorted in ascending order, convert it to a height-balanced binary search tree.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: nums = [-10,-3,0,5,9]
 * Output: [0,-3,9,-10,null,5]
 * Explanation: [0,-10,5,null,-3,null,9] is also accepted:
 *
 * Example 2:
 *
 *
 * Input: nums = [1,3]
 * Output: [3,1]
 * Explanation: [1,null,3] and [3,1] are both height-balanced BSTs.
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 104
 * -104 <= nums[i] <= 104
 * nums is sorted in a strictly increasing order.
 *
 *
 * */
import java.util.Arrays;

public class ConvertSortedArrayToBinarySearchTree108 {


     public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
        }
    }


    public static void main(String[] args) {
         TreeNode root = sortedArrayToBST(new int[]{1,2,3,4,5,6,7,8,9});


         System.out.println(root);
        System.out.println();

    }



    public static TreeNode sortedArrayToBST(int[] nums) {


         if(nums.length <=1 ) {
             return nums.length==0?null:new TreeNode(nums[0]);
         }

         TreeNode root = new TreeNode(nums[nums.length/2]);




         root.left = sortedArrayToBST(Arrays.copyOfRange(nums,0,nums.length/2));
         root.right=sortedArrayToBST(Arrays.copyOfRange(nums,(nums.length/2)+1,nums.length));

         return root;

    }

    /*Notes:
    * La pregunta general
    * */





}
