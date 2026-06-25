package neetcode150.binarysearch;

public class SearchA2DMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;
        int left = 0;
        int right = (row*col)-1;

        while(left<=right){

            int mid = left+(right-left)/2;
            int value = matrix[mid/col][mid%col];

            if(value == target){
                return true;
            }else if(value > target){
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int target = 3;

        SearchA2DMatrix obj = new SearchA2DMatrix();
        boolean result = obj.searchMatrix(matrix,target);

        if(result){
            System.out.println("Target is present in the matrix");
        }else {
            System.out.println("Target is not present in the matrix");
        }
    }
}
