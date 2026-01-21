package blind75.tree.binarytree;

import blind75.tree.TreeNode;

public class BinaryTreeMaximumPathSum {

    int maxLength = Integer.MIN_VALUE;

    public int binaryTreeMaximumPathSum(TreeNode root){

        calculatePathSum(root);
        return maxLength;
    }

    public int calculatePathSum(TreeNode root){

        if(root==null){
            return 0;
        }
        int left = Math.max(0,calculatePathSum(root.leftNode));
        int right = Math.max(0,calculatePathSum(root.rightNode));

        maxLength = Math.max(maxLength,(left+ root.data+right));

        return Math.max(left,right)+root.data;
    }

    public static void main(String[] args){
       Object[] rootArray = {-10,9,20,null,null,15,7};

        TreeNode root = new TreeNode((int)rootArray[0]);
        root.leftNode = new TreeNode((int)rootArray[1]);
        root.rightNode = new TreeNode((int)rootArray[2]);
        root.rightNode.leftNode = new TreeNode((int)rootArray[5]);
        root.rightNode.rightNode = new TreeNode((int)rootArray[6]);

        BinaryTreeMaximumPathSum obj = new BinaryTreeMaximumPathSum();
        int result = obj.binaryTreeMaximumPathSum(root);
        System.out.println("Binary Tree Maximum path sum : "+result);
    }
}
