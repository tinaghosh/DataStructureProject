package neetcode150.array;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {

    public boolean checkValidSudoku(char[][] board){

        int num = 9;
        Set<Character>[] rowSet = new HashSet[num];
        Set<Character>[] colSet = new HashSet[num];
        Set<Character>[] boxSet = new HashSet[num];

        for(int i=0;i<num;i++){
            rowSet[i] = new HashSet<>();
            colSet[i] = new HashSet<>();
            boxSet[i] = new HashSet<>();
        }

        for(int i=0;i<board.length;i++){
            for(int j=0;j<board.length;j++){
                if(board[i][j]!='.'){

                    int boxIndex =  3 * (i/3)+(j/3);

                    if(rowSet[i].contains(board[i][j])||
                            colSet[j].contains(board[i][j])||
                            boxSet[boxIndex].contains(board[i][j])){
                        return false;
                    }
                    rowSet[i].add(board[i][j]);
                    colSet[j].add(board[i][j]);
                    boxSet[boxIndex].add(board[i][j]);
                }
            }
        }
        return true;
    }

    public static void main(String[] args){

        char[][] board =
                {{'5','3','.','.','7','.','.','.','.'}
                ,{'6','.','.','1','9','5','.','.','.'}
                ,{'.','9','8','.','.','.','.','6','.'}
                ,{'8','.','.','.','6','.','.','.','3'}
                ,{'4','.','.','8','.','3','.','.','1'}
                ,{'7','.','.','.','2','.','.','.','6'}
                ,{'.','6','.','.','.','.','2','8','.'}
                ,{'.','.','.','4','1','9','.','.','5'}
                ,{'.','.','.','.','8','.','.','7','9'}};

        ValidSudoku obj = new ValidSudoku();
        boolean result = obj.checkValidSudoku(board);
        if(result){
            System.out.print("Input board is a valid Sudoku");
        }else{
            System.out.print("Input board is not a valid Sudoku");
        }
    }
}
