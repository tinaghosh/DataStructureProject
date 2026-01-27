package blind75.matrix;

import java.util.Arrays;

public class SetMatrixZeroes {

    public int[][] setMatrixZeroes(int[][] matrix){

        int rowLength = matrix.length;
        int colLength = matrix[0].length;

        boolean rowFlag = false ,
                colFlag = false;

        //check the 1st row if any element is Zero set the rowFlag to true
        for(int i=0;i<colLength;i++){
            if(matrix[0][i] == 0){
               rowFlag = true;
               break;
            }
        }
        //check the 1st column if any element is Zero set the colFlag to true
        for(int i=0;i<rowLength;i++){
            if(matrix[i][0] == 0){
                colFlag = true;
                break;
            }
        }
        //Check all the elements row-wise by ignoring the first row and first column.
        // If a 0 is found, we set the first row and coloum element to 0.

        for(int i=1;i<rowLength;i++){
            for(int j=1;j<colLength;j++){
                if(matrix[i][j]==0){
                    matrix[i][0]=0;
                    matrix[0][j]=0;
                }
            }
        }

        System.out.println("After setting first row and first coloum element to 0");
        Arrays.stream(matrix).forEach(row-> {
            Arrays.stream(row).forEach(e-> System.out.print(e+" "));
            System.out.println();
        });

        //Check every row’s first element, starting from the second row,
        // and if it is 0, set all values in that row to 0.

        for(int i=1;i<rowLength;i++){
            if(matrix[i][0]==0){
                Arrays.fill(matrix[i],0);
            }
        }

        System.out.println("Rowwise-> starting from the second row, if row’s first element 0 ---> " +
                "set all values in that row to 0");
        Arrays.stream(matrix).forEach(row-> {
            Arrays.stream(row).forEach(e-> System.out.print(e+" "));
            System.out.println();
        });

        //Check every column’s first element, starting from the second column,
        // and if it’s 0, set all values in that col to 0.

        for(int i=1;i<colLength;i++){
             if(matrix[0][i]==0){
                 for(int j=1;j<rowLength;j++){
                     matrix[j][i] = 0;
                 }
             }
        }

        System.out.println("columnwise-> starting from the second column, if col’s first element 0 ---> " +
                "set all values in that col to 0");

        Arrays.stream(matrix).forEach(row-> {
            Arrays.stream(row).forEach(e-> System.out.print(e+" "));
            System.out.println();
        });

        //If rowFlag is TRUE, set 0 in the first row.
        if(rowFlag){
           Arrays.fill(matrix[0],0);
        }

        System.out.println("rowFlag True -> after setting  0 in the first row");
        Arrays.stream(matrix).forEach(row-> {
            Arrays.stream(row).forEach(e-> System.out.print(e+" "));
            System.out.println();
        });

        //If colFlag is TRUE, set 0 in the first column.
        if(colFlag){
            for(int i=0;i<rowLength;i++){
                matrix[i][0] = 0;
            }
        }

        System.out.println("colFlag True -> after setting  0 in the first column");
        Arrays.stream(matrix).forEach(row-> {
            Arrays.stream(row).forEach(e-> System.out.print(e+" "));
            System.out.println();
        });
        return matrix;
    }

    public static void main(String[] args){
        int[][] matrix =  {{0,1,2,0},{3,4,5,2},{1,3,1,5}};//{{1,1,1},{1,0,1},{1,1,1}};//{{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        System.out.println("Input Array-> ");
        Arrays.stream(matrix).forEach(row-> {
            Arrays.stream(row).forEach(e-> System.out.print(e+" "));
            System.out.println();
        });

        SetMatrixZeroes obj = new SetMatrixZeroes();

        int[][] result = obj.setMatrixZeroes(matrix);
        System.out.println("Output Array-> ");
        Arrays.stream(result).forEach(row-> {
            Arrays.stream(row).forEach(e-> System.out.print(e+" "));
            System.out.println();
        });
    }
}
