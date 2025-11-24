package Medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class PacificAtlanticWaterFlow417 {



    public static void main(String[] args) {



        System.out.println(pacificAtlantic(new int[][]{{1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}}));


    }



    public static List<List<Integer>> pacificAtlantic(int[][] heights) {



        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < heights.length - 1; i++) {
            for (int j = 0; j < heights[i].length - 1; j++) {


                    if(hasPath2Atlantic(heights, i, j, heights[i][j],new HashSet<>()) && hasPath2Pacific(heights, i, j, heights[i][j], new HashSet<>())) {

                        boolean atlantic=hasPath2Atlantic(heights, i, j, heights[i][j],new HashSet<>());
                        boolean pacific=hasPath2Pacific(heights, i, j, heights[i][j], new HashSet<>());


                        List<Integer> list = new ArrayList<>();
                        list.add(i);
                        list.add(j);
                        res.add(list);
                    }

            }
        }


        return res;

    }




    public static Boolean hasPath2Pacific(int[][] heights, int i, int j, int height, HashSet<Integer> visited) {

        int key = i * heights[0].length + j;


        if(visited.contains(key)) {
            return false;
        }

        if(heights[i][j]>height){
            return false;
        }

        if(i==0 || j==0){
            return true;
        }

        visited.add(key);

        Boolean has =
                ( hasPath2Pacific(heights, i - 1, j , heights[i][j], visited)) ||
                        ( i < heights.length - 1 && hasPath2Pacific(heights, i + 1 , j , heights[i][j], visited) ||
                        ( hasPath2Pacific(heights, i , j - 1, heights[i][j], visited)) ||
                        ( j < heights[0].length - 1 && hasPath2Pacific(heights, i , j + 1, heights[i][j], visited)));

        visited.remove(key);

        return has;


    }


    public static Boolean hasPath2Atlantic(int[][] heights, int i, int j, int height, HashSet<Integer> visited) {

        int key = i * heights[0].length + j;

        if(visited.contains(key)) {
            return false;
        }

        if(heights[i][j]>height){
            return false;
        }

        if(i==heights.length-1 || j==heights[i].length-1){
            return true;
        }

        visited.add(key);

        Boolean has =
                ( i > 0 && hasPath2Pacific(heights, i - 1, j , heights[i][j], visited)) ||
                        ( hasPath2Pacific(heights, i + 1 , j , heights[i][j], visited) ||
                                ( j > 0 && hasPath2Pacific(heights, i  , j - 1, heights[i][j], visited)) ||
                                ( j < heights[0].length - 1 && hasPath2Pacific(heights, i , j + 1, heights[i][j], visited)));

        visited.remove(key);

        return has;

    }

}
