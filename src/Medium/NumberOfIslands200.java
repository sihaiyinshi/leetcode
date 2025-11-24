package Medium;
/**
 * Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.
 *
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
 *
 *
 *
 * Example 1:
 *
 * Input: grid = [
 *   ["1","1","1","1","0"],
 *   ["1","1","0","1","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","0","0","0"]
 * ]
 * Output: 1
 * Example 2:
 *
 * Input: grid = [
 *   ["1","1","0","0","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","1","0","0"],
 *   ["0","0","0","1","1"]
 * ]
 * Output: 3
 *
 *
 * Constraints:
 *
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 300
 * grid[i][j] is '0' or '1'.
 *
 *
 * */

public class NumberOfIslands200 {


    public static void main(String[] args) {

        System.out.println(numIslands(new char[][]{{'1','1','1'},{'0','1','0'},{'1','1','1'}}));




    }


    public static int numIslands(char[][] grid) {



        /*
        int count=0;


        Map<Integer, List<Integer>> map=new HashMap<>();

        int[][] direction={{0,1},{1,0},{0,-1},{-1,0}};




        for(int i = 0; i < grid.length; i++){
            loop: for(int j = 0; j < grid[0].length; j++){


                if(grid[i][j]=='1') {

                    for(int[] d : direction){
                        if(map.containsKey(i + d[0]) && map.get(i + d[0]).contains(j + d[1])){
                            map.computeIfAbsent(i, k -> new ArrayList<>()).add(j);
                            continue loop;
                        }
                    }

                    map.computeIfAbsent(i, k -> new ArrayList<>()).add(j);
                    count++;

                }
            }

        }


        return count;*/

        int count=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1'){
                    count++;
                    dfs(grid,i,j);
                }
            }
        }

        return count;

    }


    static void dfs(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0')
            return;

        grid[i][j] = '0'; // Mark visited
        dfs(grid, i - 1, j);
        dfs(grid, i + 1, j);
        dfs(grid, i, j - 1);
        dfs(grid, i, j + 1);
    }



    /*Note:
    * The problem of isolated islands can only be solved by the recursive, or transferred into stack and Q
    *
    *
    * */






}
