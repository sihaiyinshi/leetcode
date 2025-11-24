package Easy;
/**
 *
 * Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [1,2,2,3,4,4,3]
 * Output: true
 * Example 2:
 *
 *
 * Input: root = [1,2,2,null,3,null,3]
 * Output: false
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [1, 1000].
 * -100 <= Node.val <= 100
 *
 *
 * Follow up: Could you solve it both recursively and iteratively?
 *
 * */

public class SymmetricTree101 {


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

        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(3,new TreeNode(4),new TreeNode(5));
        root.right = new TreeNode(3,null,new TreeNode(4));



        System.out.println(isSymmetric(root));

        
    }



    public static boolean isSymmetric(TreeNode root) {



        if(root == null) {
            return true;
        }



        return isSymmetric(root.left, root.right);


    }



    private static boolean isSymmetric(TreeNode p, TreeNode q) {


        if(p == null && q == null) {
            return true;
        }
        else if(q == null || p == null) {
            return false;
        }



        if(p.val != q.val) {
            return false;
        }


        return isSymmetric(p.left, q.right) && isSymmetric(q.left, p.right);

    }

    /*Note:
    * I thought I was slow enough until i saw the time was only 18 mis...
    * */




}
