package Medium;

import java.util.*;

public class WordSearch79 {

    public static void main(String[] args) {



        //char[][] board=new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        //System.out.println(exist(board, "ABCB"));
        //char[][] board2=new char[][]{{'A','A'}};
        //System.out.println(exist(board2, "AAA"));
        char[][] board3=new char[][]{{'A','B'},{'C','D'}};
        System.out.println(exist(board3, "CDBA"));


    }


    public static boolean exist(char[][] board, String word) {


        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {

                if(board[i][j] == word.charAt(0)) {

                    if(find(board,word,i,j, new HashSet<>(),0)) {
                        return true;
                    }

                }

            }
        }

        return false;
    }




    public static boolean find(char[][] board, String word, int row, int col, HashSet<Integer> visited, int loc) {

        /*
        if(visited.contains(row*10+col)){
            return false;
        }

        visited.add(row*10+col);

        if(loc == word.length() - 1 && board[row][col] == word.charAt(loc)) {
            return true;
        }

        if(board[row][col] != word.charAt(loc)) {
            return false;
        }


        boolean up= row > 0 && find(board, word, row - 1, col, visited,  loc+1);
        boolean down= row< board.length-1 && find(board, word, row+1, col, visited, loc+1);
        boolean left= col > 0 && find(board, word, row , col - 1 , visited, loc+1);
        boolean right = col<board[0].length-1 && find(board, word, row, col+1, visited, loc+1);

        return left || right || up || down;
*/



        int key = row * board[0].length + col; // safer hash than row*10+col

        if (visited.contains(key)) return false;
        if (board[row][col] != word.charAt(loc)) return false;
        if (loc == word.length() - 1) return true;

        visited.add(key);

        boolean found =
                (row > 0 && find(board, word, row - 1, col, visited, loc + 1)) ||
                        (row < board.length - 1 && find(board, word, row + 1, col, visited, loc + 1)) ||
                        (col > 0 && find(board, word, row, col - 1, visited, loc + 1)) ||
                        (col < board[0].length - 1 && find(board, word, row, col + 1, visited, loc + 1));

        visited.remove(key); // 🔁 backtrack

        return found;



        /**
         * Good (backtracking):

         * visited.add(pos);
         * dfs(visited);
         * visited.remove(pos); // ✅ undo change

         * Also Good (copy on write):

         * Set<Integer> newVisited = new HashSet<>(visited);
         * newVisited.add(pos);
         * dfs(newVisited); // ✅ each path isolated
         *
         * */

    }

    /*Note:
    * See the note by gpt, backtracking and copy
    *
    *
    * */


}
