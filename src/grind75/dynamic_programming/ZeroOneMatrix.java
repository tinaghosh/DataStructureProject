package grind75.dynamic_programming;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class ZeroOneMatrix {

    public int[][] ShortestPathFromZero(int[][] mat) {

        int rowLength = mat.length;
        int colLength = mat[0].length;
        int[][] result = new int[rowLength][colLength];
        Queue<Matrix> queue = new LinkedList<>();

        Arrays.stream(result).forEach(e -> {
            Arrays.fill(e, -1);
        });

        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < colLength; j++) {
                if (mat[i][j] == 0) {
                    result[i][j] = mat[i][j];
                    queue.add(new Matrix(i, j));
                }
            }
        }

        while (!queue.isEmpty()) {
            int size = queue.size();

            Matrix pair = queue.poll();

            //Down direction
            if (pair.row + 1 >= 0 && pair.row + 1 < rowLength) {
                if (result[pair.row + 1][pair.column] == -1) {
                    result[pair.row + 1][pair.column] = result[pair.row][pair.column] + 1;
                    queue.add(new Matrix(pair.row + 1, pair.column));
                }
            }
            //Left Direction
            if (pair.column + 1 >= 0 && pair.column + 1 < colLength) {
                if (result[pair.row][pair.column + 1] == -1) {
                    result[pair.row][pair.column + 1] = result[pair.row][pair.column] + 1;
                    queue.add(new Matrix(pair.row, pair.column + 1));
                }
            }
            //Right Direction
            if (pair.column - 1 >= 0 && pair.column - 1 < colLength) {
                if (result[pair.row][pair.column - 1] == -1) {
                    result[pair.row][pair.column - 1] = result[pair.row][pair.column] + 1;
                    queue.add(new Matrix(pair.row, pair.column - 1));
                }
            }
            //Up Direction
            if (pair.row - 1 >= 0 && pair.row - 1 < rowLength) {
                if (result[pair.row - 1][pair.column] == -1) {
                    result[pair.row - 1][pair.column] = result[pair.row][pair.column] + 1;
                    queue.add(new Matrix(pair.row - 1, pair.column));
                }
            }

        }
        return result;
    }

    public static void main(String[] args) {
        int[][] mat = {{0,1,0,1,1},{1,1,0,0,1},{0,0,0,1,0},{1,0,1,1,1},{1,0,0,0,1}};
        ZeroOneMatrix obj = new ZeroOneMatrix();
        int[][] result = obj.ShortestPathFromZero(mat);
        Arrays.stream(result).forEach(e -> {
            System.out.print("[");
            Arrays.stream(e).forEach(eineer -> System.out.print(eineer + ","));
            System.out.println("]");
        });
    }

    private static class Matrix {
        int row;
        int column;

        Matrix(int row, int column) {
            this.row = row;
            this.column = column;
        }
    }
}
