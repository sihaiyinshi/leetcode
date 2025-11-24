package Easy;

/**
 * You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n, representing the number of elements in nums1 and nums2 respectively.
 *
 * Merge nums1 and nums2 into a single array sorted in non-decreasing order.
 *
 * The final sorted array should not be returned by the function, but instead be stored inside the array nums1. To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged, and the last n elements are set to 0 and should be ignored. nums2 has a length of n.
 *
 *
 *
 * Example 1:
 *
 * Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * Output: [1,2,2,3,5,6]
 * Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
 * The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.
 * Example 2:
 *
 * Input: nums1 = [1], m = 1, nums2 = [], n = 0
 * Output: [1]
 * Explanation: The arrays we are merging are [1] and [].
 * The result of the merge is [1].
 * Example 3:
 *
 * Input: nums1 = [0], m = 0, nums2 = [1], n = 1
 * Output: [1]
 * Explanation: The arrays we are merging are [] and [1].
 * The result of the merge is [1].
 * Note that because m = 0, there are no elements in nums1. The 0 is only there to ensure the merge result can fit in nums1.
 *
 *
 * Constraints:
 *
 * nums1.length == m + n
 * nums2.length == n
 * 0 <= m, n <= 200
 * 1 <= m + n <= 200
 * -109 <= nums1[i], nums2[j] <= 109
 * */

public class MergeSortedArray88 {


    public static void main(String[] args) {



        int[] nums1={1,2,3,0,0,0};
        int[] nums2={2,5,6};
        merge(nums1,3,nums2,3);
        ArrayPrint(nums1);

        nums1=new int[]{1};
        nums2=new int[]{};
        merge(nums1,1,nums2,0);
        ArrayPrint(nums1);

        nums1=new int[]{2,0};
        nums2=new int[]{1};
        merge(nums1,1,nums2,1);
        ArrayPrint(nums1);
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1=m-1;
        int p2=n-1;
        int mergeP1=m+n-1;

        while(p2>=0){
            if(p1>=0 && nums1[p1]>nums2[p2]){
                nums1[mergeP1--]=nums1[p1--];
            }
            else{
                nums1[mergeP1--]=nums2[p2--];
            }
        }
    }



    /*


    public static void merge(int[] nums1, int m, int[] nums2, int n) {

        if(n==0){
            return;
        }

        int p1=0;
        int p2=0;
        int[] ans=new int[m+n];
        for(int i=0;i<ans.length;i++){

            if(p1==m){
                ans[i]=nums2[p2++];
                continue;
            }
            else if(p2==n){
                ans[i]=nums1[p1++];
                continue;
            }

            if(nums1[p1]<nums2[p2]){
                ans[i]=nums1[p1++];
            }
            else{
                ans[i]=nums2[p2++];
            }

        }

        System.arraycopy(ans, 0, nums1, 0, ans.length);

    }*/


    private static void ArrayPrint(int[] array){
        for(int i=0;i<array.length;i++){
            System.out.print(array[i]+" ");
        }
    }

    /*Note:
     * My opinion:
     * 1. make 2 pointer
     * 2. build a new array
     * 3. read two arrays separately and move pointer forward
     * 4. copy the new array to the old one
     *
     * His opinion:
     * 1. make 3 pointer
     * 2. read two arrays separately and move pointer backward
     *
     * Hint:
     * 1. use of the third pointer can avoid build a new array and copy
     * 2. merge thr border condition into the loop condition instead of make it separately
     *    (but it may be better if separate it in daily programming)
     * */


}
