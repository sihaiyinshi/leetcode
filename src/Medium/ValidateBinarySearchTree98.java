package Medium;


/**
 * Given the root of a binary tree, determine if it is a valid binary search tree (BST).
 *
 * A valid BST is defined as follows:
 *
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 *
 *
 * Example 1:
 *
 *
 * Input: root = [2,1,3]
 * Output: true
 * Example 2:
 *
 *
 * Input: root = [5,1,4,null,null,3,6]
 * Output: false
 * Explanation: The root node's value is 5 but its right child's value is 4.
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [1, 104].
 * -231 <= Node.val <= 231 - 1
 * */

public class ValidateBinarySearchTree98 {

    public static class TreeNode {
        int val;
        ValidateBinarySearchTree98.TreeNode left;
        ValidateBinarySearchTree98.TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, ValidateBinarySearchTree98.TreeNode left, ValidateBinarySearchTree98.TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }



    public static void main(String[] args) {


        //TreeNode n1=new TreeNode(2,new TreeNode(1),new TreeNode(3));
        //TreeNode n1=new TreeNode(32,new TreeNode(26,new TreeNode(19,null,new TreeNode(27)),null),null);
        TreeNode n1=new TreeNode(5,new TreeNode(1,null,null),new TreeNode(4,new TreeNode(3),new TreeNode(6)));


        TreeNode n2=new TreeNode(0,new TreeNode(-1),null);
        TreeNode n3=new TreeNode(1,new TreeNode(-1),null);

        System.out.println(isValidBST(n1));
        System.out.println(isValidBST(n2));
        System.out.println(isValidBST(n3));




    }



    public static boolean isValidBST(TreeNode root) {


        /*
        if(root.left == null || root.right == null){
            return root.left==null? root.right.val>root.val : root.left.val<root.val;
        }


        Queue<TreeNode> left = new LinkedList<>();
        Queue<TreeNode> right = new LinkedList<>();

        left.offer(root.left);
        right.offer(root.right);

        int max=root.val;
        int min=root.val;

        while(left != null){





        }

        while(right != null){

        }*/



        return isValidBST(root,Integer.MAX_VALUE,Integer.MIN_VALUE);

        //return true;


    }





    public static boolean isValidBST(TreeNode root, Integer max, Integer min) {




        if(root==null){
            return true;
        }

        if(root.val>=max || root.val<=min){
            return false;
        }

        return isValidBST(root.left,root.val,min) && isValidBST(root.right,max,root.val);





        /*
        if(root.left != null) {

            if(root.left.val<=min || root.left.val >= root.val){
                return false;
            }

            return isValidBST(root.left,root.val,min);


                1. root.left > min
                2. root.left < root.val

                if 1 & 2: into left tree and make the max the current val


        }

        if(root.right != null) {

            if(root.right.val>=max || root.right.val <= root.val){
                return false;
            }

            return isValidBST(root.right,max,root.val);

        }

        return true;*/

    }

    /*Note:
    * for the DFS, always only check whether the node is null, and use an index to update if possible
    * */




}
