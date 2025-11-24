package Easy;

/**
 * Given the root of a binary tree, return the length of the diameter of the tree.
 *
 * The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.
 *
 * The length of a path between two nodes is represented by the number of edges between them.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [1,2,3,4,5]
 * Output: 3
 * Explanation: 3 is the length of the path [4,2,1,3] or [5,2,1,3].
 * Example 2:
 *
 * Input: root = [1,2]
 * Output: 1
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [1, 104].
 * -100 <= Node.val <= 100
 *
 * */

public class DiameterOfBinaryTree543 {



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

        TreeNode t1=new TreeNode(1,new TreeNode(2,new TreeNode(4),new TreeNode(5)),new TreeNode(3));
        TreeNode t2=new TreeNode(1,new TreeNode(2),new TreeNode(3));
        TreeNode t3=new TreeNode(1,new TreeNode(2),null);
        TreeNode t4=new TreeNode(1,new TreeNode(2),new TreeNode(3,new TreeNode(4,new TreeNode(5,new TreeNode(6),null),null),new TreeNode(7,null,new TreeNode(8,null,new TreeNode(9)))));

        System.out.println(diameterOfBinaryTree(t1));
        System.out.println(diameterOfBinaryTree(t2));
        System.out.println(diameterOfBinaryTree(t3));
        System.out.println(diameterOfBinaryTree(t4));


    }




    public static int res=0;

    public static int diameterOfBinaryTree(TreeNode root) {
        Depth(root);
        return res;

    }

    public static int Depth(TreeNode root) {


        if(root == null) {
            return 0;
        }

        int leftMax=Depth(root.left);
        int rightMax=Depth(root.right);

        res=Math.max(res,leftMax+rightMax);

        return 1+Math.max(leftMax, rightMax);
    }

    /*Note:
     * Unknown:
     * global static
     *
     * My opinion:
     * There needs to be a global number to update the maximum, and make comparison
     *
     * His opinion:
     * implement it
     *
     * Hint:
     * Several ways for recursive
     * 1. give parameter for stopping condition
     *
     * i.e. public static void generateParenthesis(List list, int left, int right,String s, int n) {

        if(s.length()==n*2){
            list.add(s);
            return;
        }

        if(left<n){
            generateParenthesis(list,left+1,right,s+"(",n);
        }

        if(right<left){
            generateParenthesis(list,left,right+1,s+")",n);

        }

    }
     *
     * 2. maintain a global maximum
     * i.e. this question, especially when you wanna return exactly 2 nums
     *
     *
     *
     * */

}
