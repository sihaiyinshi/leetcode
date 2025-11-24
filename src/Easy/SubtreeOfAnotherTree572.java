package Easy;


/**
 *
 * Given the roots of two binary trees root and subRoot, return true if there is a subtree of root with the same structure and node values of subRoot and false otherwise.
 *
 * A subtree of a binary tree tree is a tree that consists of a node in tree and all of this node's descendants. The tree tree could also be considered as a subtree of itself.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [3,4,5,1,2], subRoot = [4,1,2]
 * Output: true
 * Example 2:
 *
 *
 * Input: root = [3,4,5,1,2,null,null,null,null,0], subRoot = [4,1,2]
 * Output: false
 *
 *
 * Constraints:
 *
 * The number of nodes in the root tree is in the range [1, 2000].
 * The number of nodes in the subRoot tree is in the range [1, 1000].
 * -104 <= root.val <= 104
 * -104 <= subRoot.val <= 104
 *
 *
 * */
public class SubtreeOfAnotherTree572 {
    
    
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


        TreeNode t1=new TreeNode(3);
        t1.left=new TreeNode(4,new TreeNode(1),new TreeNode(2));
        t1.right=new TreeNode(5);


        TreeNode t2=new TreeNode(4);
        t2.left=new TreeNode(1);
        t2.right=new TreeNode(2);

        TreeNode t3=new TreeNode(1,new TreeNode(1), null);
        TreeNode t4=new TreeNode(1);



        System.out.println(isSubtree(t1, t2));
        System.out.println(isSubtree(t3,t4));



    }

    public static boolean isSubtree(TreeNode root, TreeNode subRoot) {


        if(root == null || subRoot == null){
            return root == null && subRoot == null;
        }
        else if(root.val == subRoot.val) {
                return isSame(root, subRoot) || isSubtree(root.left,subRoot) || isSubtree(root.right, subRoot);
        }

        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);

    }



    public static boolean isSame(TreeNode root, TreeNode subRoot) {

        if(root == null || subRoot == null){
            return root == null && subRoot == null;
        }
        else if(root.val!=subRoot.val){
            return false;
        }



        return isSame(root.left, subRoot.left) && isSame(root.right, subRoot.right);


    }


/*Note:
* Yes I am fully understanding what recursive is now(kakushinn)
*
*
* */



}
