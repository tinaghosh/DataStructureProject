package blind75.matrix;

public class WordSearch {

    public boolean checkWordPresent(char[][] board, String word){

        int rowLength = board.length;
        int colLength = board[0].length;

        for(int i=0;i<rowLength;i++){
            for(int j=0;j<colLength;j++){
                if(board[i][j] == word.charAt(0)){
                    if(recursion(board,word,i,j,rowLength,colLength,0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean recursion(char[][] board,String word,int i,int j,int rowLength,int colLength,int index){

        int[][] direction ={{-1,0},{1,0},{0,-1},{0,1}};//left,right,up,down

        if(index == word.length()){
            return true;
        }
        if(i<0 || i>=rowLength || j<0 || j>=colLength){
            return false;
        }
        if(board[i][j]!=word.charAt(index)){
            return false;
        }
        char storeChar = board[i][j];
        board[i][j] = '$';

        for(int d=0;d<direction.length;d++){
            int newRow = i+direction[d][0];
            int newCol = j+direction[d][1];
            if(recursion(board,word,newRow,newCol,rowLength,colLength,index+1)){
                return true;
            }
        }
        board[i][j] = storeChar;
        return false;
    }
    public static void main(String[] args){
        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "ABCB" ;

        WordSearch obj = new WordSearch();
        boolean result = obj.checkWordPresent(board,word);
        if(result){
            System.out.println("Word is present in the board");
        }else{
            System.out.println("Word is not present in the board");
        }
    }
}
