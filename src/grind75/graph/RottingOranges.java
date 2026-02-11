package grind75.graph;

import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {

    public int minTimeToBecomeRotten(int[][] grid){

       int minutes = 0;
       int freshOrangesCount = 0;
       int[][] direction = {{-1,0},{1,0},{0,1},{0,-1}};
       Queue<Pair> queue = new LinkedList<>();

       for(int i=0;i<grid.length;i++){
           for(int j=0;j<grid[0].length;j++){
               if(grid[i][j]==1){
                   freshOrangesCount++;
               }else if (grid[i][j]==2) {
                 queue.add(new Pair(i,j));
               }
           }
       }

        if(freshOrangesCount==0){
            return 0;
        }

       while(!queue.isEmpty()){
           int size = queue.size();
           for(int i=0;i<size;i++){
               Pair rootenPair = queue.poll();
               for(int[] d: direction){
                   int newRow = rootenPair.row + d[0];
                   int newCol = rootenPair.column + d[1];
                   if(newRow>=0 && newRow< grid.length && newCol>=0 && newCol<grid[0].length){
                       if(grid[newRow][newCol]==1){
                           grid[newRow][newCol] = 2;
                           queue.add(new Pair(newRow,newCol));
                           freshOrangesCount--;
                       }
                   }
               }
           }
           minutes++;
        }

        if(freshOrangesCount==0){
            return minutes-1;
        }else{
            return -1;
        }
    }

    public static void main(String[] args){

     int[][] grid = {{2,1,1},{1,1,0},{0,1,1}};
     RottingOranges obj = new RottingOranges();
     int result = obj.minTimeToBecomeRotten(grid);
     System.out.println("Minimum number of minutes that must elapse until " +
             "no cell has a fresh orange is -> "+result);
    }

    private static class Pair{
        int row;
        int column;

        public Pair(int row,int column){
            this.row = row;
            this.column = column;
        }
    }
}
