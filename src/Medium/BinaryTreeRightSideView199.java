package Medium;

import java.util.ArrayList;
import java.util.List;
/**
 * Given the root of a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.
 *
 *
 *
 * Example 1:
 *
 * Input: root = [1,2,3,null,5,null,4]
 *
 * Output: [1,3,4]
 *
 * Explanation:
 *
 *
 *
 * Example 2:
 *
 * Input: root = [1,2,3,4,null,null,null,5]
 *
 * Output: [1,3,4,5]
 *
 * Explanation:
 *
 *
 *
 * Example 3:
 *
 * Input: root = [1,null,3]
 *
 * Output: [1,3]
 *
 * Example 4:
 *
 * Input: root = []
 *
 * Output: []
 *
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [0, 100].
 * -100 <= Node.val <= 100
 *
 * */

public class BinaryTreeRightSideView199 {


    public class TreeNode {
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

    }









    public List<Integer> rightSideView(TreeNode root) {


        if (root == null) return new ArrayList<>();
        ArrayList<Integer> res = new ArrayList<>();
        List<TreeNode> curr = new ArrayList<>();
        curr.add(root);

        rightSideView(res,curr);
        return res;





    }

    public void rightSideView(ArrayList<Integer> res, List<TreeNode> curr) {

        if (curr.isEmpty()) {
            return;
        }

        List<TreeNode> next = new ArrayList<>();

        for (TreeNode node : curr) {

            if(node.left != null) {
                next.add(node.left);
            }

            if(node.right != null) {
                next.add(node.right);
            }

        }

        res.add(curr.get(curr.size()-1).val);
        rightSideView(res,next);

    }





/*Note:
* Using recursive to implement the BFS for the first time, note list is required for recursive here.
*
* */


}
