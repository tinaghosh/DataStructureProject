package grind75.array;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {

    public int[] productOfArrayExceptSelf(int[] arr){

        int[] output = new int[arr.length];
        int[] pre = new int[arr.length];
        int[] post = new int[arr.length];
        int preProduct = 1;

        for(int i=0;i<arr.length;i++){
            preProduct = preProduct * arr[i];
            pre[i] = preProduct;
        }
        preProduct =1;
        Arrays.stream(pre).forEach(e->System.out.print(e+" "));
        System.out.println();

        for(int i=arr.length-1;i>=0;i--){
            preProduct = preProduct * arr[i];
            post[i] = preProduct;
        }
        Arrays.stream(post).forEach(e->System.out.print(e+" "));
        System.out.println();

        output[0] = post[1];

        for(int i=1;i<arr.length-1;i++){
            output[i] = pre[i-1] * post[i+1];
        }
        output[arr.length-1] = pre[arr.length-2];
        return output;
    }

    public int[] productOfArrayExceptSelfWithNoExtraSpace(int[] arr) {
        int n = arr.length;
        int[] output = new int[n];

        output[0] = 1;
        for (int i = 1; i < n; i++) {
            output[i] = output[i - 1] * arr[i - 1];
        }

        Arrays.stream(output).forEach(e->System.out.print(e+" "));
        System.out.println();

        int postfix = 1;
        for (int i = n - 1; i >= 0; i--) {
            output[i] = output[i] * postfix;
            postfix = postfix * arr[i];
        }
        Arrays.stream(output).forEach(e->System.out.print(e+" "));
        System.out.println();

        return output;
    }

    public static void main(String[] args){
        int[] arr ={1,2,3,4};

        ProductOfArrayExceptSelf obj = new ProductOfArrayExceptSelf();
        int[] result = obj.productOfArrayExceptSelf(arr);
        Arrays.stream(result).forEach(e->System.out.print(e+" "));
        System.out.println();
        int[] result1 = obj.productOfArrayExceptSelfWithNoExtraSpace(arr);
        Arrays.stream(result1).forEach(e->System.out.print(e+" "));
    }
}
