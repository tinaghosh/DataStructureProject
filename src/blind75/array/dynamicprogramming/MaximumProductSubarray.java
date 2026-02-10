package blind75.array.dynamicprogramming;

public class MaximumProductSubarray {

    public int findMaximumProductOfSubarray(int[] num){

        int minProduct = num[0];
        int maxProduct = num[0];
        int overAllMaxProduct = num[0];

        for(int i=1;i<num.length;i++){
            int temp = minProduct;
            minProduct =  Math.min(Math.min(num[i],num[i]*minProduct),num[i]*maxProduct);
            maxProduct = Math.max(Math.max(num[i],num[i]*temp),num[i]*maxProduct);
            overAllMaxProduct = Math.max(maxProduct,overAllMaxProduct);
        }
        return overAllMaxProduct;
    }
    public static void main(String[] args){
        int[] num = {2,3,-2,4,-5};
        MaximumProductSubarray obj = new MaximumProductSubarray();
        int result = obj.findMaximumProductOfSubarray(num);
        System.out.println("Largest product of a sub-array is -> "+result);
    }
}
