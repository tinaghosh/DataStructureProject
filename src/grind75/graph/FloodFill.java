package grind75.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class FloodFill {

    //*********************************  Using DFS Approach *********************************//

    public int[][] floodFill(int[][] image, int sourceRow, int sourceColumn, int color){

        int sourceColor = image[sourceRow][sourceColumn];

        if(sourceColor == color){
            return image;
        }
        recursion(image,sourceRow,sourceColumn,color,sourceColor);
        return image;
    }

    public void recursion(int[][] image, int sourceRow, int sourceColumn, int color,int sourceColor){

        int[][] direction = {{-1,0},{1,0},{0,1},{0,-1}};

        image[sourceRow][sourceColumn]= color;

        for(int[] d:direction){
           int newRow = sourceRow+d[0];
           int newColumn = sourceColumn+d[1];

           if(newRow>=0 && newRow<image.length && newColumn>=0 && newColumn<image[0].length){
               if(image[newRow][newColumn] == sourceColor) {
                   recursion(image, newRow, newColumn, color, sourceColor);
               }
           }
        }
    }
    //*********************************  Using DFS Approach *********************************//

    //*********************************  Using BFS Approach *********************************//

    public int[][] floodFillBFS(int[][] image, int sourceRow, int sourceColumn, int color){

        int rowLength = image.length;
        int colLength = image[0].length;
        int sourceColor = image[sourceRow][sourceColumn];

        if(sourceColor == color){
            return image;
        }
        image[sourceRow][sourceColumn] = color;
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(sourceRow,sourceColumn));
        int[][] direction = {{-1,0},{1,0},{0,1},{0,-1}};

        while(!queue.isEmpty()){

            Pair pair = queue.poll();

            for(int[] d: direction){
              int newRow = pair.row + d[0];
              int newColumn = pair.column + d[1];
              if(newRow>=0 && newRow<rowLength && newColumn>=0 && newColumn<colLength){
                  if(image[newRow][newColumn] == sourceColor){
                      image[newRow][newColumn] = color;
                      queue.add(new Pair(newRow,newColumn));
                  }
              }
            }
        }
        return image;
    }

    private static class Pair{
      int row;
      int column;

      public Pair(int row,int column){
          this.row= row;
          this.column = column;
      }
    }
    //*********************************  Using BFS Approach *********************************//

    public static void main(String[] args){
        int[][] image = {{1,1,1},{1,1,0},{1,0,1}};
        int sourceRow = 1;
        int sourceColumn = 1;
        int color = 2;

        FloodFill obj = new FloodFill();
        System.out.println("-------DFS Output-----");
        int[][] result = obj.floodFill(image,sourceRow,sourceColumn,color);
        Arrays.stream(result).forEach(e->{
            Arrays.stream(e).forEach(einner->System.out.print(einner+","));
            System.out.println();
        });
        System.out.println("-------BFS Output-----");
        int[][] resultBFS = obj.floodFillBFS(image,sourceRow,sourceColumn,color);
        Arrays.stream(resultBFS).forEach(e->{
            Arrays.stream(e).forEach(einner->System.out.print(einner+","));
            System.out.println();
        });
    }
}
