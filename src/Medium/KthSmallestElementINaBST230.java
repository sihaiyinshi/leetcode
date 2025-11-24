package Medium;

import java.util.ArrayList;


/**
 * Given the root of a binary search tree, and an integer k, return the kth smallest value (1-indexed) of all the values of the nodes in the tree.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [3,1,4,null,2], k = 1
 * Output: 1
 * Example 2:
 *
 *
 * Input: root = [5,3,6,2,4,null,null,1], k = 3
 * Output: 3
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is n.
 * 1 <= k <= n <= 104
 * 0 <= Node.val <= 104
 *
 *
 * Follow up: If the BST is modified often (i.e., we can do insert and delete operations) and you need to find the kth smallest frequently, how would you optimize?
 *
 * */
public class KthSmallestElementINaBST230 {


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


    public static void main(String[] args) {


        /*
        TreeNode root = new TreeNode(3, new TreeNode(1,null,new TreeNode(2)), new TreeNode(4));
        System.out.println(kthSmallest(root, 1));
        System.out.println(kthSmallest(root, 2));
        System.out.println(kthSmallest(root, 3));*/

        TreeNode n1 = new TreeNode(1, null, new TreeNode(2));
        System.out.println(kthSmallest(n1, 2));

    }

    public static int kthSmallest(TreeNode root, int k) {

        for(int i=0;i<k-1;i++){

            if(root.left==null){
                root = root.right;
                continue;
            }

            TreeNode curr = root;
            TreeNode parent = null;
            while(curr.left!=null){
                parent=curr;
                curr=curr.left;
            }

            if(curr.right==null){
                parent.left=null;
            }
            else{
                parent.left=curr.right;
            }
        }

        TreeNode min = root;
        while(min.left != null){
            min = min.left;
        }
        return min.val;

    }





    public static int kthSmallest2(TreeNode root, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        kthSmallest(root, list);
        list.sort(Integer::compareTo);
        return list.get(k-1);


    }

    public static void kthSmallest(TreeNode root, ArrayList<Integer> nums) {
        if (root == null){
            return;
        }
        nums.add(root.val);
        kthSmallest(root.left, nums);
        kthSmallest(root.right, nums);

    }


    /*Note:
     * Unknown:
     * BST
     *
     *
     * Hint:
     * This is how BST works
     * */

}
