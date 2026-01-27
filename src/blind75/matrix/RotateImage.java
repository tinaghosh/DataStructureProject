package blind75.matrix;

import java.util.Arrays;

public class RotateImage {

    public int[][] rotateMatrix90Degree(int[][] matrix){

        int rowLength = matrix.length;
        int colLength = matrix[0].length;

        for(int i=0;i<rowLength;i++){
            for(int j=i+1;j<rowLength;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        System.out.println("Transpose Matrix :");
        Arrays.stream(matrix).forEach(row->{
            Arrays.stream(row).forEach(e-> System.out.print(e+" "));
            System.out.println();
        });

        for(int i=0;i<rowLength;i++){
            int left = 0;int right = colLength-1;
            while(left<right){
                int temp = matrix[i][left];
                matrix[i][left]=matrix[i][right];
                matrix[i][right]=temp;
                left++;
                right--;
            }
        }
        return matrix;
    }
    public static void main(String[] args){
      int[][] matrix = {{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};

      System.out.println("Input Matrix :");
      Arrays.stream(matrix).forEach(row->{
          Arrays.stream(row).forEach(e-> System.out.print(e+" "));
          System.out.println();
      });

      RotateImage obj = new RotateImage();
      int[][] result = obj.rotateMatrix90Degree(matrix);

      System.out.println("Output Matrix :");
        Arrays.stream(result).forEach(row->{
            Arrays.stream(row).forEach(e-> System.out.print(e+" "));
            System.out.println();
      });
    }
}
