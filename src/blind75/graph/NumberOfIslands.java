package blind75.graph;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {

    //*********************************  Using DFS Approach *********************************//

    public int numberOfUniqueIslands(char[][] grid){
        int count = 0;
        int rowLength = grid.length;
        int colLength = grid[0].length;

        for(int i=0;i<rowLength;i++){
            for(int j=0;j<colLength;j++){
                if(grid[i][j] == '1'){
                   dfs(grid,i,j,rowLength,colLength);
                   count++;
                }
            }
        }
        return count;
    }
    public void dfs(char[][] grid, int row, int column,int rowLength,int colLength){

        int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};

        if(grid[row][column]=='$'){
            return;
        }
        grid[row][column]='$';

        for(int[] d : directions){
            int newRow = row + d[0];
            int newCol = column + d[1];
            if(newRow>=0 && newRow<rowLength && newCol>=0 && newCol<colLength) {
                if (grid[newRow][newCol] == '1') {
                    dfs(grid, newRow, newCol, rowLength, colLength);
                }
            }
        }
    }
    //*********************************  Using DFS Approach *********************************//

    //*********************************  Using BFS Approach *********************************//

    public int numberOfUniqueIslandsUsingBFS(char[][] grid){
        int count = 0;
        int rowLength = grid.length;
        int colLength = grid[0].length;
        Queue<Pair> queue = new LinkedList<>();
        int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};

        for(int i=0;i<rowLength;i++){
            for(int j=0;j<colLength;j++){
                if(grid[i][j] == '1'){
                    queue.add(new Pair(i,j));

                    while(!queue.isEmpty()){
                        Pair island = queue.poll();
                        grid[island.row][island.column] = '$';

                        for(int[] d : directions){
                            int newRow = island.row + d[0];
                            int newCol = island.column + d[1];
                            if(newRow>=0 && newRow<rowLength && newCol>=0 && newCol<colLength) {
                                if (grid[newRow][newCol] == '1') {
                                    grid[newRow][newCol] = '$';
                                    queue.add(new Pair(newRow,newCol));
                                }
                            }
                        }
                    }
                    count++;
                }
            }
        }
        return count;
    }
    //*********************************  Using BFS Approach *********************************//

    public static void main(String[] args) {

        char[][] grid = {{'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}};

        NumberOfIslands obj = new NumberOfIslands();
        int result = obj.numberOfUniqueIslands(grid);
        System.out.println("Number of unique islands -> "+result);

        int resultBFS = obj.numberOfUniqueIslandsUsingBFS(grid);
        System.out.println("Number of unique islands -> "+resultBFS);
    }

    private static class Pair{
        int row;
        int column;

        public Pair(int row, int column){
            this.row = row;
            this.column = column;
        }
    }
}