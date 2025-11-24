package ToBeSolved;

/**
 *
 * You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
 *
 * Find two lines that together with the x-axis form a container, such that the container contains the most water.
 *
 * Return the maximum amount of water a container can store.
 *
 * Notice that you may not slant the container.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: height = [1,8,6,2,5,4,8,3,7]
 * Output: 49
 * Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.
 * Example 2:
 *
 * Input: height = [1,1]
 * Output: 1
 *
 *
 * Constraints:
 *
 * n == height.length
 * 2 <= n <= 105
 * 0 <= height[i] <= 104
 * */

public class ContainerWithMostWater11 {


    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1,1}));

    }


    public static int maxArea(int[] height) {

        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;


        while (left <= right) {
            maxArea = Math.max(maxArea, Math.min(height[left],height[right]) * (right-left));
            if(height[left]<height[right]){
                left++;
            }
            else{
                right--;
            }



        }
        return maxArea;





        /*

        int maxArea = 0;


        for (int i = 0; i < height.length - 1; i++) {
            for (int j = i + 1; j < height.length; j++) {
                maxArea = Math.max(maxArea, Math.min(height[i], height[j]) * (j - i));
            }
        }

        return maxArea;
        */


        /*
        * Note:
            🧭 How to Apply This to Similar Problems
            This technique of two pointers with greedy reduction works when:

            ✅ Conditions:
            You're choosing two elements from a sequence (like two lines here).

            The value to maximize/minimize is a function of both:

                Something monotonic in the distance (e.g., decreases as distance shrinks),

                And something local, like min() or max() of the values.

            🎯 Examples:
                🔷 Container With Most Water
                Maximize (j - i) * min(height[i], height[j])

                Monotonic in distance → decrease

                Local minimum determines height → try to improve it greedily

                🔷 Trapping Rain Water
                Need to know tallest bar to the left and right of every point.

                Can also be solved with two pointers, but here you precompute max left/right or use pointers to update running maxes.

                🔷 Max Sum of Subarrays of Size k
                Sliding window (a form of greedy pointer movement)

                Total depends on elements in window; slide window efficiently without recomputing sum.

                🔷 Longest Substring Without Repeating Characters
                Use two pointers to maintain a valid window (a set of unique characters).

                If the window becomes invalid, shrink from the left greedily.

            🧩 Key Takeaway:
                Two-pointer greedy strategies work when:

                You can shrink the search space intelligently,

                Based on the structure of the function you're optimizing (like distance × min height),

                And you never eliminate a pair that could be optimal without comparing it.
        * */


    }

}
