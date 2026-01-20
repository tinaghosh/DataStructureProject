package grind75.tree.binary_search_tree;

import grind75.tree.TreeNode;
import java.util.Stack;

public class KthSmallestElemenInABST {

    public int kthSmallestElemenInABST(TreeNode root,int k){

        int count=0;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;

        while(current!=null || !stack.isEmpty()){
            while(current!=null){
                stack.push(current);
                current = current.leftNode;
            }
            current = stack.pop();
            count = count+1;

            if(count==k){
                return current.data;
            }
            current = current.rightNode;
        }

        return -1;
    }
    public static void main(String args[]){

        Object[] rootArray = {5,3,6,2,4,null,null,1};
        int k = 3;

        TreeNode root = new TreeNode((int)rootArray[0]);
        root.leftNode = new TreeNode((int)rootArray[1]);
        root.rightNode = new TreeNode((int)rootArray[2]);
        root.leftNode.leftNode = new TreeNode((int)rootArray[3]);
        root.leftNode.rightNode = new TreeNode((int)rootArray[4]);
        root.leftNode.leftNode.leftNode = new TreeNode((int)rootArray[7]);

        KthSmallestElemenInABST obj = new KthSmallestElemenInABST();
        int result = obj.kthSmallestElemenInABST(root,k);
        System.out.println("\n Kth Smallest Element in the Tree is : "+result);
    }
}
