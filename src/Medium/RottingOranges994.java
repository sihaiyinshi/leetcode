package Medium; /**
 * You are given an m x n grid where each cell can have one of three values:
 *
 * 0 representing an empty cell,
 * 1 representing a fresh orange, or
 * 2 representing a rotten orange.
 * Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.
 *
 * Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: grid = [[2,1,1],[1,1,0],[0,1,1]]
 * Output: 4
 * Example 2:
 *
 * Input: grid = [[2,1,1],[0,1,1],[1,0,1]]
 * Output: -1
 * Explanation: The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.
 * Example 3:
 *
 * Input: grid = [[0,2]]
 * Output: 0
 * Explanation: Since there are already no fresh oranges at minute 0, the answer is just 0.
 *
 *
 * Constraints:
 *
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 10
 * grid[i][j] is 0, 1, or 2.
 *
 * */


import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges994 {



    public static void main(String[] args) {
        System.out.println(orangesRotting(new int[][]{{2,1,1},{1,1,0},{0,1,1}}));
        System.out.println(orangesRotting(new int[][]{{0,2}}));
        System.out.println(orangesRotting(new int[][]{{2,1,1},{0,1,1},{1,0,1}}));

    }


    public static int orangesRotting(int[][] grid) {



        int fresh=0;
        int time=0;
        int m=grid.length;
        int n=grid[0].length;
        Queue<int[]> q=new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if(grid[i][j]==1){
                    fresh++;
                }
                else if(grid[i][j]==2){
                    q.offer(new int[]{i,j});
                }

            }
        }


        while(!q.isEmpty()){

            int rotten=0;
            int size=q.size();

            for(int i=0;i<size;i++){
                int[] arr=q.poll();


                int[][] change=new int[][]{{0,1},{1,0},{0,-1},{-1,0}};


                for(int[] j:change) {
                    int row = j[0] + arr[0];
                    int column = j[1] + arr[1];

                    if (row >= 0 && row < m && column >= 0 && column < n && grid[row][column] == 1) {
                        q.offer(new int[]{row, column});
                        grid[row][column] = 2;
                        fresh--;
                        rotten++;

                    }
                }

            }

            if(rotten>0){
                time++;
            }

        }


    return fresh==0 ? time: -1;

    }











    /*
    public static int orangesRotting(int[][] grid) {

        int maxPath=0;
        HashMap<Integer, Integer> visited=new HashMap();

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){

                if(grid[i][j] == 2){

                    int leftPath=0;
                    int rightPath=0;
                    int upPath=0;
                    int downPath=0;

                    if (i > 0) {
                        leftPath = findMaximmumPath(i - 1, j, grid, "left", visited) + 1;
                    }

                    if (i < grid.length - 1) {
                        rightPath = findMaximmumPath(i + 1, j, grid, "right", visited) + 1;
                    }

                    if (j > 0) {
                        upPath = findMaximmumPath(i, j - 1, grid, "up", visited) + 1;
                    }

                    if (j < grid[0].length - 1) {
                        downPath = findMaximmumPath(i, j + 1, grid, "down", visited) + 1;
                    }


                    maxPath=Math.max(Math.max(Math.max(leftPath,rightPath),upPath),downPath);
                }

            }
        }


        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++) {

                if(grid[i][j] == 1) {

                    HashSet<Integer> set=new HashSet<>();

                    int a=-1;
                    int b=-1;
                    int c=-1;
                    int d=-1;


                    if (i > 0 ) {
                        a=grid[i-1][j];
                    }

                    if (i < grid.length - 1) {
                        b=grid[i + 1][j];
                    }

                    if (j > 0) {
                        c=grid[i][j-1];
                    }

                    if (j < grid[0].length - 1 ) {
                        d=grid[i][j+1];
                    }

                    set.add(a);
                    set.add(b);
                    set.add(c);
                    set.add(d);

                    if(!set.contains(1) && !set.contains(2)){
                        return -1;
                    }




                }


            }
        }






        return maxPath;

    }

    public static int findMaximmumPath(int i, int j, int[][] grid, String from, HashMap<Integer, Integer> visited){



        if(grid[i][j]==0 || grid[i][j]==2) {
            return -1;
        }
        else if(visited.containsKey(i) && visited.containsValue(j)){
            return -1;
        }

        visited.put(i,j);

        int leftPath=0;
        int rightPath=0;
        int upPath=0;
        int downPath=0;

            if (i > 0 && !from.equals("right")) {
                leftPath = findMaximmumPath(i - 1, j, grid, "left", visited) + 1;
            }

            if (i < grid.length - 1 && !from.equals("left")) {
                rightPath = findMaximmumPath(i + 1, j, grid, "right", visited) + 1;
            }

            if (j > 0 && !from.equals("down")) {
                upPath = findMaximmumPath(i, j - 1, grid, "up", visited) + 1;
            }

            if (j < grid[0].length - 1 && !from.equals("up")) {
                downPath = findMaximmumPath(i, j + 1, grid, "down", visited) + 1;
            }

        return Math.max(Math.max(Math.max(leftPath,rightPath),upPath),downPath);


    }*/

    /*Note:
     * Unknown:
     * 1. Algorithm of BFS & BFS
     *
     * My opinion:
     * 1. recursive
     *
     * His opinion:
     * 1. loop
     *
     * Hint:
     * 1. BFS is so **
     * */



}
