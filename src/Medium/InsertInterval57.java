package Medium; /**
 * You are given an array of non-overlapping intervals intervals where intervals[i] = [starti, endi] represent the start and the end of the ith interval and intervals is sorted in ascending order by starti. You are also given an interval newInterval = [start, end] that represents the start and end of another interval.
 *
 * Insert newInterval into intervals such that intervals is still sorted in ascending order by starti and intervals still does not have any overlapping intervals (merge overlapping intervals if necessary).
 *
 * Return intervals after the insertion.
 *
 * Note that you don't need to modify intervals in-place. You can make a new array and return it.
 *
 *
 *
 * Example 1:
 *
 * Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
 * Output: [[1,5],[6,9]]
 * Example 2:
 *
 * Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * Output: [[1,2],[3,10],[12,16]]
 * Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
 *
 *
 * Constraints:
 *
 * 0 <= intervals.length <= 104
 * intervals[i].length == 2
 * 0 <= starti <= endi <= 105
 * intervals is sorted by starti in ascending order.
 * newInterval.length == 2
 * 0 <= start <= end <= 105
 * */
import java.util.ArrayList;

public class InsertInterval57 {

    public static void main(String[] args) {

        insert(new int[][]{{1,2},{3,5},{6,7},{8,10},{12,16}},new int[]{4,8});


    }


    public static int[][] insert(int[][] intervals, int[] newInterval) {


        ArrayList<int[]> res = new ArrayList<>();

        for(int[] interval : intervals) {
            if(newInterval[1] < interval[0]) {
                res.add(newInterval);
                newInterval=interval;
            }
            else if(newInterval[0]>interval[1]) {
                res.add(interval);
            }
            else {
                newInterval[0]=Math.min(newInterval[0],interval[0]);
                newInterval[1]=Math.max(interval[1], newInterval[1]);
            }
        }

        res.add(newInterval);
        return res.toArray(new int[res.size()][]);



        /*
        ArrayList<Integer> res = new ArrayList<>();


        if(intervals.length == 0){
            return new int[][]{newInterval};
        }

        boolean skip=false;
        int count=0;

        for(int[] interval : intervals){
            for(int i: interval){





                if(i>newInterval[1]){
                    skip=false;
                    res.add(newInterval[1]);
                }
                else if(i>newInterval[0]){
                    skip=true;
                    res.add(interval[0]);
                }

                if(!skip){
                    res.add(i);
                }

            }
        }

        for(Object i:res.toArray()){
            System.out.println(i);
        }*/



 /*
        Stack<Integer> stack = new Stack<>();
        stack.add(newInterval[1]);
        stack.add(newInterval[0]);


        for(int i = 0; i < intervals.length; i++){
            for(int j:intervals[i]){

                if(!stack.isEmpty()) {
                    int temp = stack.pop();
                    if (j > temp) {
                        res.add(temp);

                        if(!stack.isEmpty()) {
                            temp = stack.pop();
                            if (j > temp) {
                                res.add(temp);
                            }
                            else if(j==temp) {
                                res.add(j);
                            }else {
                                stack.add(temp);
                                res.add(j);
                            }
                        }
                        else{
                            res.add(j);
                        }

                    } else if(j==temp){
                        res.add(j);
                    }else {
                        stack.add(temp);
                        res.add(j);
                    }
                }
                else{
                    res.add(j);
                }



            }
        }
        */

        /*
        if(newInterval[1]<intervals[0][0]){
          res.add(newInterval);
          res.addAll(Arrays.asList(intervals));
          return res.toArray(new int[res.size()][]);
        }
        else if(newInterval[0]>intervals[intervals.length-1][1]){
            res.addAll(Arrays.asList(intervals));
            res.add(newInterval);
            return res.toArray(new int[res.size()][]);
        }

        for(int i=0; i<intervals.length; i++){
            if(newInterval[0]>=intervals[i][0] && newInterval[1]<=intervals[i][1]){
                res.addAll(Arrays.asList(intervals));
                return res.toArray(new int[res.size()][]);
            }



        }*/


    }




    /*Note:
     * Unknown:
     *
     * My opinion:
     * 1. solve it with queue
     *
     * His opinion:
     * 1. read it through and compare every interval with the new interval
     * 2. continually expand the nrwInterval until the newInterval is much smaller
     *
     * */


}
