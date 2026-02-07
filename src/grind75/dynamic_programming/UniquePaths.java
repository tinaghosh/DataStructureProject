package grind75.dynamic_programming;

import java.util.Arrays;

public class UniquePaths {

    //************************  Using Recursion + Memo (Top-Down Approach) ************************//

    int[][] mem;

    public int noOfUniquePath(int row, int column) {

        mem = new int[row][column];
        Arrays.stream(mem).forEach(e -> Arrays.fill(e, -1));

        return recursion(0, 0, row, column);
    }

    public int recursion(int currentRow, int currentColumn, int maxRow, int maxColumn) {

        if (currentRow < 0 || currentRow >= maxRow || currentColumn < 0 || currentColumn >= maxColumn) {
            return 0;
        }
        if (currentRow == maxRow - 1 && currentColumn == maxColumn - 1) {
            return 1;
        }
        if (mem[currentRow][currentColumn] != -1) {
            return mem[currentRow][currentColumn];
        }

        int right = recursion(currentRow, currentColumn + 1, maxRow, maxColumn);
        int down = recursion(currentRow + 1, currentColumn, maxRow, maxColumn);

        mem[currentRow][currentColumn] = right + down;

        return mem[currentRow][currentColumn];
    }

    //************************  Using Recursion + Memo (Top-Down Approach) ************************//

    //*********************************  Using Bottom-Up Approach *********************************//
    public int noOfUniquePathresultBottomUp(int row, int column) {

        int[][] result = new int[row][column];

        result[0][0] = 0;

        for (int i = 0; i < row; i++) {
            result[i][0] = 1;
        }
        for (int i = 0; i < column; i++) {
            result[0][i] = 1;
        }

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < column; j++) {
                result[i][j] = result[i - 1][j] + result[i][j - 1];
            }
        }
        return result[row - 1][column - 1];
    }
    //*********************************  Using Bottom-Up Approach *********************************//

    public static void main(String[] args) {

        int m = 3;
        int n = 7;

        UniquePaths obj = new UniquePaths();
        int result = obj.noOfUniquePath(m, n);
        System.out.println("Number of possible unique paths that the robot can " +
                "take to reach the bottom-right corner -> " + result);

        int resultBottomUp = obj.noOfUniquePathresultBottomUp(m, n);
        System.out.println("Number of possible unique paths that the robot can " +
                "take to reach the bottom-right corner -> " + resultBottomUp);

    }
}
