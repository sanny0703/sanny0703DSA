package BacktrackingAndRecursion.SudokuSolver;

import java.util.HashSet;
import java.util.Set;

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
 */
public class ValidSudoku {
    public static boolean isValid(String[][] board){
        Set<String> seen = new HashSet<>();
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if( board[i][j]!="."){
                    if(!seen.add(board[i][j]+"in column"+j) || !seen.add(board[i][j]+"in row"+i) ||
                            !seen.add(board[i][j]+"in box"+i/3+"-"+j/3))
                        return  false;
                }
            }
        }
        return  true;
    }

    public static void main(String[] args) {
        System.out.println(isValid(new String[][]{
                {"5","3",".",".","7",".",".",".","."}
,{"6",".",".","1","9","5",".",".","."}
,{".","9","8",".",".",".",".","6","."}
,{"8",".",".",".","6",".",".",".","3"}
,{"4",".",".","8",".","3",".",".","1"}
,{"7",".",".",".","2",".",".",".","6"}
,{".","6",".",".",".",".","2","8","."}
,{".",".",".","4","1","9",".",".","5"}
,{".",".",".",".","8",".",".","7","9"}
        }));
        System.out.println(isValid(new String[][]{
                {"8","3",".",".","7",".",".",".","."}
,{"6",".",".","1","9","5",".",".","."}
,{".","9","8",".",".",".",".","6","."}
,{"8",".",".",".","6",".",".",".","3"}
,{"4",".",".","8",".","3",".",".","1"}
,{"7",".",".",".","2",".",".",".","6"}
,{".","6",".",".",".",".","2","8","."}
,{".",".",".","4","1","9",".",".","5"}
,{".",".",".",".","8",".",".","7","9"}
        }));
    }

}
