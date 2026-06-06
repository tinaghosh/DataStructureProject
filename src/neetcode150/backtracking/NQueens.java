package neetcode150.backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NQueens {

    public List<List<String>> solveNQueens(int n) {

        List<List<String>> result = new ArrayList<>();
        Set<Integer> columnSet = new HashSet<>();
        Set<Integer> diagonalSet = new HashSet<>();
        Set<Integer> antiDiagonalSet = new HashSet<>();
        List<String> board = new ArrayList<>();

        for(int i=0;i<n;i++){
            StringBuffer s = new StringBuffer();
            for(int j=0;j<n;j++){
                s.append(".");
            }
            board.add(s.toString());
        }

        boardRecursion(result,columnSet,diagonalSet,antiDiagonalSet,board,0);
        return result;
    }

    public void boardRecursion (List<List<String>> result, Set<Integer> columnSet,
                                Set<Integer> diagonalSet, Set<Integer> antiDiagonalSet, List<String> board , int row){

        if(row == board.size()){
            result.add(new ArrayList<>(board));
            return;
        }

        for(int col =0;col<board.size();col++){
            if(columnSet.contains(col) || diagonalSet.contains(row-col) || antiDiagonalSet.contains(row+col)){
                continue;
            }else{
                StringBuffer b = new StringBuffer(board.get(row));
                b.setCharAt(col,'Q');
                board.set(row,b.toString());

                columnSet.add(col);
                diagonalSet.add(row-col);
                antiDiagonalSet.add(row+col);

                boardRecursion(result,columnSet,diagonalSet,antiDiagonalSet,board,row+1);

                StringBuffer re = new StringBuffer(board.get(row));
                re.setCharAt(col,'.');
                board.set(row,re.toString());

                columnSet.remove(col);
                diagonalSet.remove(row-col);
                antiDiagonalSet.remove(row+col);
            }
        }
    }

    public static void main(String[] args) {
        int n = 4;
        NQueens obj = new NQueens();
        List<List<String>> result = obj.solveNQueens(n);
        result.forEach(e-> System.out.println(e));
    }
}
