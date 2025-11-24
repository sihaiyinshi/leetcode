package Medium; /**
 * Given an integer array nums of unique elements, return all possible subsets (the power set).
 *
 * The solution set must not contain duplicate subsets. Return the solution in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3]
 * Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * Example 2:
 *
 * Input: nums = [0]
 * Output: [[],[0]]
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 10
 * -10 <= nums[i] <= 10
 * All the numbers of nums are unique.
 *
 * */

import java.util.ArrayList;
import java.util.List;

public class Subsets78 {


    public static void main(String[] args) {

        System.out.println(subsets(new int[]{1,2,3}));


    }


    public static List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> subset=new ArrayList<>();


        recursiveSubsets(res,subset,nums,0);

        return res;
    }

    public static void recursiveSubsets(List<List<Integer>> res, List<Integer> subset,int[] num,int index) {

        if(index==num.length){
            res.add(new ArrayList<>(subset));
            return;
        }

        subset.add(num[index]);
        recursiveSubsets(res, subset, num, index+1);

        subset.remove(subset.size()-1);
        recursiveSubsets(res, subset, num, index+1);



    }

    /*Note:
     * Unknown:
     * 1. DFS is compulsory
     * 2. TREE
     *
     * My opinion:
     * 1. BFS
     *
     * His opinion:
     * 1. draw a tree to cover all the permutation
     * 2. implement the DFS of the tree
     *
     * Hint:
     * 1. draw the tree
     * 2. implement the DFS
     * */



}
