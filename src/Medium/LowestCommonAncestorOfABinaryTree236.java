package Medium;

/**
 *
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
 *
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * Output: 3
 * Explanation: The LCA of nodes 5 and 1 is 3.
 * Example 2:
 *
 *
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * Output: 5
 * Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.
 * Example 3:
 *
 * Input: root = [1,2], p = 1, q = 2
 * Output: 1
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [2, 105].
 * -109 <= Node.val <= 109
 * All Node.val are unique.
 * p != q
 * p and q will exist in the tree.
 * */

public class LowestCommonAncestorOfABinaryTree236 {

    
  public static class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;
  TreeNode(int x) { val = x; }
    TreeNode(int val, TreeNode left, TreeNode right) {
    this.val = val;
    this.left = left;
    this.right = right;
    }
    TreeNode() {}

    @Override
    public String toString() {
      return ""+this.val;
    }
  }
    
    public static void main(String[] args) {

      TreeNode n1=new TreeNode(3,new TreeNode(5,new TreeNode(6),new TreeNode(2,new TreeNode(7),new TreeNode(4))),new TreeNode(1,new TreeNode(0), new TreeNode(8)));
      TreeNode n2=new TreeNode(1,new TreeNode(2),null);
      System.out.println(lowestCommonAncestor(n1, new TreeNode(2), new TreeNode(4)));
      System.out.println(lowestCommonAncestor(n2, new TreeNode(1), new TreeNode(2)));

    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null){
          return null;
        }
        else if(root.val ==p.val || root.val==q.val){
          return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left!=null && right!=null){
          return root;
        }
        else{
          return left==null?right:left;
        }

    }

    /*Note:
    * I can handle Binary tree now, but only somehow.
    *
    * */

}
