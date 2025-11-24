package Medium; /**
 * Given an m x n matrix, return all elements of the matrix in spiral order.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * Output: [1,2,3,6,9,8,7,4,5]
 * Example 2:
 *
 *
 * Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 *
 *
 * Constraints:
 *
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 10
 * -100 <= matrix[i][j] <= 100
 * */


import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix54 {

    public static void main(String[] args) {


        //System.out.println(spiralOrder(new int[][]{{1,2,3},{4,5,6},{7,8,9}}));
        //System.out.println(spiralOrder(new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}}));


        //System.out.println(spiralOrder(new int[][]{}));
        //System.out.println(spiralOrder(new int[][]{{0}}));

        System.out.println(spiralOrder(new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16},{17,18,19,20},{21,22,23,24}}));
    }


    public static List<Integer> spiralOrder(int[][] matrix) {

        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new ArrayList<>();
        }


        int minRow=0;
        int minCol=0;
        int maxRow=matrix.length-1;
        int maxCol=matrix[0].length-1;

        int currentRow=0;
        int currentCol=0;


        List<Integer> list=new ArrayList<>();

        while(minRow<=maxRow&&minCol<=maxCol){

            //LU
            if(currentRow==minRow && currentCol==minCol){


                while(currentCol<=maxCol){
                    list.add(matrix[currentRow][currentCol]);
                    currentCol++;
                }
                currentCol--;
                currentRow++;
                minRow++;


                //RU
            }else if(currentRow==minRow && currentCol==maxCol){

                while(currentRow<=maxRow){
                    list.add(matrix[currentRow][currentCol]);
                    currentRow++;
                }
                currentRow--;
                currentCol--;
                maxCol--;


                //RD
            }else if(currentRow==maxRow && currentCol==maxCol){


                while(currentCol>=minCol){
                    list.add(matrix[currentRow][currentCol]);
                    currentCol--;
                }
                currentCol++;
                currentRow--;
                maxRow--;


                //LD
            }else{


                while(currentRow>=minRow){
                    list.add(matrix[currentRow][currentCol]);
                    currentRow--;
                }
                currentRow++;
                currentCol++;
                minCol++;

            }

        }

        return list;

    }


    /*Note:
     *
     * */


}
