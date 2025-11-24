package Medium;

import java.util.Arrays;
/**
 * Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane and an integer k, return the k closest points to the origin (0, 0).
 *
 * The distance between two points on the X-Y plane is the Euclidean distance (i.e., √(x1 - x2)2 + (y1 - y2)2).
 *
 * You may return the answer in any order. The answer is guaranteed to be unique (except for the order that it is in).
 *
 *
 *
 * Example 1:
 *
 *
 * Input: points = [[1,3],[-2,2]], k = 1
 * Output: [[-2,2]]
 * Explanation:
 * The distance between (1, 3) and the origin is sqrt(10).
 * The distance between (-2, 2) and the origin is sqrt(8).
 * Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
 * We only want the closest k = 1 points from the origin, so the answer is just [[-2,2]].
 * Example 2:
 *
 * Input: points = [[3,3],[5,-1],[-2,4]], k = 2
 * Output: [[3,3],[-2,4]]
 * Explanation: The answer [[-2,4],[3,3]] would also be accepted.
 *
 *
 * Constraints:
 *
 * 1 <= k <= points.length <= 104
 * -104 <= xi, yi <= 104
 *
 * */

public class KClosestPointsToOrigin973 {


    public static void main(String[] args) {

    }


    public int[][] kClosest(int[][] points, int k) {

        quickSort(points, 0, points.length-1);

        return Arrays.copyOfRange(points,0,k);


    }





    public static void quickSort(int[][] array, int left, int right){
        if(left>=right){
            return;
        }

        int part=partition(array, left, right);
        quickSort(array, left, part-1);
        quickSort(array, part+1, right);


    }


    public static int partition(int[][] array, int left, int right){
        double pivot = distance(array[right]);
        int i = left;


        for(int j=left;j<right;j++){
            if(distance(array[j])<pivot){
                if(i==j){
                    i++;
                }
                else{

                    int[] temp = array[i];
                    array[i++]=array[j];
                    array[j]=temp;

                }
            }
        }


        int[] temp= array[i];
        array[i]=array[right];
        array[right]=temp;
        return i;

    }


    public static double distance(int[] points) {
        return Math.sqrt(points[0]*points[0] + points[1]*points[1]);
    }

    /* Note:
    * QuickSort averagely reaches the time complexity of O(n) or even O(n log n), while the heap reaches it in O(n log c)
    *
    *
    *
    * */



}
