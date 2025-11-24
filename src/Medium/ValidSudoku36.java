package Medium;

import java.util.HashSet;

/**
 * Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:
 *
 * Each row must contain the digits 1-9 without repetition.
 * Each column must contain the digits 1-9 without repetition.
 * Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
 * Note:
 *
 * A Sudoku board (partially filled) could be valid but is not necessarily solvable.
 * Only the filled cells need to be validated according to the mentioned rules.
 *
 *
 * Example 1:
 *
 *
 * Input: board =
 * [["5","3",".",".","7",".",".",".","."]
 * ,["6",".",".","1","9","5",".",".","."]
 * ,[".","9","8",".",".",".",".","6","."]
 * ,["8",".",".",".","6",".",".",".","3"]
 * ,["4",".",".","8",".","3",".",".","1"]
 * ,["7",".",".",".","2",".",".",".","6"]
 * ,[".","6",".",".",".",".","2","8","."]
 * ,[".",".",".","4","1","9",".",".","5"]
 * ,[".",".",".",".","8",".",".","7","9"]]
 * Output: true
 * Example 2:
 *
 * Input: board =
 * [["8","3",".",".","7",".",".",".","."]
 * ,["6",".",".","1","9","5",".",".","."]
 * ,[".","9","8",".",".",".",".","6","."]
 * ,["8",".",".",".","6",".",".",".","3"]
 * ,["4",".",".","8",".","3",".",".","1"]
 * ,["7",".",".",".","2",".",".",".","6"]
 * ,[".","6",".",".",".",".","2","8","."]
 * ,[".",".",".","4","1","9",".",".","5"]
 * ,[".",".",".",".","8",".",".","7","9"]]
 * Output: false
 * Explanation: Same as Example 1, except with the 5 in the top left corner being modified to 8. Since there are two 8's in the top left 3x3 sub-box, it is invalid.
 *
 *
 * Constraints:
 *
 * board.length == 9
 * board[i].length == 9
 * board[i][j] is a digit 1-9 or '.'.*/

public class ValidSudoku36 {



    public static void main(String[] args) {




            System.out.println(isValidSudoku(new char[][]{{'.','.','4','.','.','.','6','3','.'},{'.','.','.','.','.','.','.','.','.'},{'5','.','.','.','.','.','.','9','.'},{'.','.','.','5','6','.','.','.','.'},{'4','.','3','.','.','.','.','.','1'},{'.','.','.','7','.','.','.','.','.'},{'.','.','.','5','.','.','.','.','.'},{'.','.','.','.','.','.','.','.','.'},{'.','.','.','.','.','.','.','.','.'}}));

    }


    public static boolean isValidSudoku(char[][] board) {

        for(char[] row : board){
            if(!isValidRow(row)){
                return false;
            }
        }

        for(int i=0; i<board.length; i++){
            if(!isValidColumn(board,i)){
                return false;
            }
        }

        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                if(!isValidBox(board, i, j)){
                    return false;
                }
            }
        }


        return true;



    }



    private static boolean isValidRow(char[] array) {
        HashSet<Character> set = new HashSet<>();
        for(char c : array){
            if(set.contains(c)) {
                return false;
            }

            if(c!='.') {
                set.add(c);
            }

        }
        return true;
    }

    private static boolean isValidColumn(char[][] array, int column) {
        HashSet<Character> set = new HashSet<>();
        for(int i = 0; i<array.length; i++){
            if(set.contains(array[i][column])) {
                return false;
            }

            if(array[i][column]!='.') {
                set.add(array[i][column]);
            }

        }
        return true;
    }

    private static boolean isValidBox(char[][] board, int row, int column) {
        HashSet<Character> set = new HashSet<>();
        for(int i = row * 3; i< row * 3 +3; i++){
            for(int j = column * 3; j< column * 3 +3; j++){
                if(set.contains(board[i][j])) {
                    return false;
                }

                if(board[i][j]!='.') {
                    set.add(board[i][j]);
                }
            }
        }
        return true;

    }


    /*Note:
    * No more better ways than calculate it directly
    *
    * */


}
