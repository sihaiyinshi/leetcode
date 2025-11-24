package Easy;

/**
 * Given the root of a binary tree, invert the tree, and return its root.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [4,2,7,1,3,6,9]
 * Output: [4,7,2,9,6,3,1]
 * Example 2:
 *
 *
 * Input: root = [2,1,3]
 * Output: [2,3,1]
 * Example 3:
 *
 * Input: root = []
 * Output: []
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [0, 100].
 * -100 <= Node.val <= 100
 *
 * */

public class InvertBinaryTree226 {

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

          public String toString() {
              return val + "";
          }
      }


    public static void main(String[] args) {


        TreeNode t1=new TreeNode(1);
        TreeNode t2=new TreeNode(2);
        TreeNode t3=new TreeNode(3);
        TreeNode t4=new TreeNode(4);
        TreeNode t5=new TreeNode(5);


        t1.left=t2;
        t1.right=t3;
        t2.left=t4;
        t2.right=t5;


        System.out.println(invertTree(t1));
        System.out.println();
    }


    public static TreeNode invertTree(TreeNode root) {


        if (root == null) return null;

        TreeNode left = root.left;
        root.left=root.right;
        root.right=left;
        invertTree(root.left);
        invertTree(root.right);
        return root;


    }

    /*Note:
    * only 4 mins spent
    *
    * */


}
