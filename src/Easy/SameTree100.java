package Easy;

/**
 *
 * Given the roots of two binary trees p and q, write a function to check if they are the same or not.
 *
 * Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: p = [1,2,3], q = [1,2,3]
 * Output: true
 * Example 2:
 *
 *
 * Input: p = [1,2], q = [1,null,2]
 * Output: false
 * Example 3:
 *
 *
 * Input: p = [1,2,1], q = [1,1,2]
 * Output: false
 *
 *
 * Constraints:
 *
 * The number of nodes in both trees is in the range [0, 100].
 * -104 <= Node.val <= 104
 * */

public class SameTree100 {


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



        //TreeNode a=new TreeNode(1,new TreeNode(2,null,null),new TreeNode(2, null,null));
        //TreeNode b=new TreeNode(1,new TreeNode(3,null,null),new TreeNode(2, null,null));
        TreeNode a=new TreeNode(1,null,new TreeNode(2, null,null));
        TreeNode b=new TreeNode(1,new TreeNode(2, null,null),null);
        System.out.println(isSameTree(a,b));


    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {

        if(p!=null && q!=null) {
            if (p.val != q.val) {
                return false;
            }
        }
        else{
            return q==null && p==null;
        }

        /*
        if(p.left == null){
            if(q.left == null){
                return true;
            }
            return false;
        }*/



        return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);

    }



    /*
    public static Integer currentValue(TreeNode p){

        if(p==null){
            return null;
        }
        currentValue(p.left);
        currentValue(p.right);
        return p.val;
    }*/








}


/*
* Note: DFS requires more exercise
*
* */
