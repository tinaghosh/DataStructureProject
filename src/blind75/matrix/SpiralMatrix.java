package blind75.matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SpiralMatrix {

    public List<Integer> printSpiralMatrix(int[][] matrix){

        List<Integer> output = new ArrayList<>();

        int left =0;
        int right = matrix[0].length;
        int top = 0;
        int bottom = matrix.length;

        while(left<right && top<bottom){
            for(int i=left;i<right;i++){
                output.add(matrix[top][i]);
            }
            top++;

            for(int i=top;i<bottom;i++){
                output.add(matrix[i][right-1]);
            }
            right--;

            if(!(left<right && top<bottom)){
                break;
            }

            for(int i=right-1;i>=left;i--){
                output.add(matrix[bottom-1][i]);
            }
            bottom--;

            for(int i=bottom-1;i>=top;i--){
                output.add(matrix[i][left]);
            }
            left++;
        }
        return output;
    }
    public static void main(String[] args){
        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};

        SpiralMatrix obj = new SpiralMatrix();
        List<Integer> result = obj.printSpiralMatrix(matrix);
        result.forEach(e-> System.out.print(e+","));
    }
}
