/**
 * Given an m x n binary matrix mat, return the distance of the nearest 0 for each cell.
 *
 * The distance between two cells sharing a common edge is 1.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: mat = [[0,0,0],[0,1,0],[0,0,0]]
 * Output: [[0,0,0],[0,1,0],[0,0,0]]
 * Example 2:
 *
 *
 * Input: mat = [[0,0,0],[0,1,0],[1,1,1]]
 * Output: [[0,0,0],[0,1,0],[1,2,1]]
 *
 *
 * Constraints:
 *
 * m == mat.length
 * n == mat[i].length
 * 1 <= m, n <= 104
 * 1 <= m * n <= 104
 * mat[i][j] is either 0 or 1.
 * There is at least one 0 in mat.
 * */

package Medium;

import java.util.HashMap;

public class Matrix01_542 {

    public static void main(String[] args) {


        int[][] test=new int[][]{{0,0,1,0,1,1,1,0,1,1},{1,1,1,1,0,1,1,1,1,1},{1,1,1,1,1,0,0,0,1,1},{1,0,1,0,1,1,1,0,1,1},{0,0,1,1,1,0,1,1,1,1},{1,0,1,1,1,1,1,1,1,1},{1,1,1,1,0,1,0,1,0,1},{0,1,0,0,0,1,0,0,1,1},{1,1,1,0,1,1,0,1,0,1},{1,0,1,1,1,0,1,1,1,0}};
        updateMatrix(test);

    }




    public static int find4sides(int[][] matrix, int i, int j, HashMap<Integer, Integer> visited) {

        if(matrix[i][j]==0) {
            return 0;
        }
        else if(visited.containsKey(i) && visited.get(i)==j) {
            return 0;
        }

        visited.put(i,j);
        int left=Integer.MAX_VALUE;
        int right=Integer.MAX_VALUE;
        int up=Integer.MAX_VALUE;
        int down=Integer.MAX_VALUE;

        if(i>0){
            left=find4sides(matrix,i-1,j,visited)+1;
        }

        if(j>0){
            right=find4sides(matrix,i,j-1,visited)+1;
        }

        if(i<matrix.length-1){
            up=find4sides(matrix,i+1,j,visited)+1;
        }

        if(j<matrix[0].length-1){
            down=find4sides(matrix,i,j+1,visited)+1;
        }


        return Math.min(Math.min(left,right),Math.min(up,down));

    }


    public static int[][] updateMatrix(int[][] mat) {

        for(int i = 0; i < mat.length; i++) {
            for(int j = 0; j < mat[0].length; j++) {
                if(mat[i][j]!=0) {
                    mat[i][j]=find4sides(mat,i,j,new HashMap<>());
                }
            }

        }

        return mat;











        /*
        int[][] Array =new int[mat.length][mat[0].length];
        for(int[] array : Array) Arrays.fill(array, Integer.MAX_VALUE);


        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                if(mat[i][j]==0){
                    Array[i][j]=0;

                    //up
                    for(int k=i;k>=0;k--){
                        if(mat[k][j]==0){
                            continue;
                        }
                        Array[k][j]=Math.min(Array[k][j],i-k);
                    }

                    //down
                    for(int k=i;k<mat.length;k++){
                        if(mat[k][j]==0){
                            continue;
                        }
                        Array[k][j]=Math.min(Array[k][j],k-i);
                    }

                    //left
                    for(int k=j;k>=0;k--){
                        if(mat[i][k]==0){
                            continue;
                        }
                        Array[i][k]=Math.min(Array[i][k],j-k);
                    }

                    //right
                    for(int k=j;k<mat[0].length;k++){
                        if(mat[i][k]==0){
                            continue;
                        }
                        Array[i][k]=Math.min(Array[i][k],k-j);
                    }


                }
            }
        }



        for(int i = 0; i< Array.length; i++){
            for(int j = 0; j< Array[0].length; j++){

                if(Array[i][j]!=0){

                    int cloest=Integer.MAX_VALUE;

                    //up
                    for(int k=i;k>=0;k--){
                        if(Array[k][j]!=Integer.MAX_VALUE){

                            if(Array[k][j]==0){
                                cloest=Math.min(cloest,i-k);
                            }
                            else{
                                cloest=Math.min(cloest,i-k+ Array[k][j]);
                            }

                        }
                    }

                    //down
                    for(int k = i; k< Array.length; k++){
                        if(Array[k][j]!=Integer.MAX_VALUE){

                            if(Array[k][j]==0){
                                cloest=Math.min(cloest,k-i);
                            }
                            else{
                                cloest=Math.min(cloest,k-i+ Array[k][j]);
                            }

                        }
                    }


                    //left
                    for(int k=j;k>=0;k--){


                        if(Array[i][k]!=Integer.MAX_VALUE){

                            if(Array[i][k]==0){
                                cloest=Math.min(cloest,j-k);
                            }
                            else{
                                cloest=Math.min(cloest,j-k+ Array[i][k]);
                            }

                        }
                    }

                    //right
                    for(int k = j; k< Array[0].length; k++){

                        if(Array[i][k]!=Integer.MAX_VALUE){
                            if(Array[i][k]==0){
                                cloest=Math.min(cloest,k-j);
                            }
                            else{
                                cloest=Math.min(cloest,k-j+ Array[i][k]);
                            }
                        }
                    }

                    Array[i][j]=cloest;


                }


            }
        }

        return Array;*/


        //findCloest(zeroByCross);


        /*
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){


                System.out.print(zeroByCross[i][j]+" ");
            }
            System.out.println();
        }*/
    }




    /*Note:
    * This can be implemented better with the BFS
    *
    * */



}
