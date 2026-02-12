package blind75.graph;

import java.util.ArrayList;
import java.util.List;

public class PacificAtlanticWaterFlow {

    public List<List<Integer>> pacificAtlanticWaterFlowCoordinates(int[][] heights){

        List<List<Integer>> result = new ArrayList<>();
        int rowLength = heights.length;
        int colLength = heights[0].length;
        boolean[][] pacificWaterVisited = new boolean[rowLength][colLength];
        boolean[][] atlanticWaterVisited = new boolean[rowLength][colLength];

        //When row is constant and column is variable that mean top and Bottom row
        for(int i=0;i<colLength;i++){
            recursion(heights, 0, i, pacificWaterVisited , Integer.MIN_VALUE); //Top row Pacific
            recursion(heights, rowLength-1 , i, atlanticWaterVisited , Integer.MIN_VALUE);  //Bottom row Atlantic
        }
        //When column is constant and row is variable that mean left and right column
        for(int i=0;i<rowLength;i++){
            recursion(heights, i, 0, pacificWaterVisited , Integer.MIN_VALUE); //Left column Pacific
            recursion(heights, i, colLength-1, atlanticWaterVisited , Integer.MIN_VALUE); //Right column Atlantic
        }

        for(int i=0;i<rowLength;i++){
            for(int j=0;j<colLength;j++){
                if(pacificWaterVisited[i][j] && atlanticWaterVisited[i][j]){
                    result.add(List.of(i,j));
                }
            }
        }
      return result;
    }
    public void recursion(int[][] heights, int row, int column , boolean[][] oceanVisited ,int prevHeight){

        int[][] direction = {{1,0},{0,1},{-1,0},{0,-1}};

        if (row < 0 || row >= heights.length || column < 0 || column >= heights[0].length) {
            return;
        }
        if (heights[row][column] < prevHeight){
            return;
        }
        if(oceanVisited[row][column]){
            return;
        }
        oceanVisited[row][column] = true;

        for(int i=0;i<direction.length;i++){
            int newRow = row + direction[i][0];
            int newCol = column + direction[i][1];
            recursion(heights, newRow, newCol, oceanVisited , heights[row][column]);
        }
    }

    public static void main(String[] args) {

        int[][] heights = {{1, 2, 2, 3, 5}, {3, 2, 3, 4, 4}, {2, 4, 5, 3, 1}, {6, 7, 1, 4, 5}, {5, 1, 1, 2, 4}};

        PacificAtlanticWaterFlow obj = new PacificAtlanticWaterFlow();
        List<List<Integer>> result = obj.pacificAtlanticWaterFlowCoordinates(heights);

        result.forEach(e->{
            System.out.print("[");
            e.forEach(eInner->{
                System.out.print(eInner+",");
            });
            System.out.println("]");
        });
    }
}
