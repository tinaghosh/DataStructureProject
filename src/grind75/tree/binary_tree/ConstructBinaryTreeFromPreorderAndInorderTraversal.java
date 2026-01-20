package grind75.tree.binary_tree;

import grind75.tree.TreeNode;
import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {

    Map<Integer,Integer> inOrderTreeMap = new HashMap<>();
    int preIndex = 0; // Using to trace the element from PreOrderArray

    public TreeNode constructBinaryTreeFromPreorderAndInorderTraversal( int[] preOrderTree, int[] inOrderTree){

        for(int i=0;i<inOrderTree.length;i++){
            inOrderTreeMap.put(inOrderTree[i],i); //preorder and inorder consist of unique values.
        }

        TreeNode output = buildTree(preOrderTree,0,preOrderTree.length-1);

       return output;
    }

    public TreeNode buildTree(int[] preOrderTree , int start, int end){

        if(start>end){
            return null;
        }

        int rootElement = preOrderTree[preIndex];
        preIndex++;
        System.out.println(rootElement);
        TreeNode root = new TreeNode(rootElement);

        int boundaryIndex = inOrderTreeMap.get(rootElement);

        root.leftNode = buildTree(preOrderTree,start,boundaryIndex-1);
        root.rightNode = buildTree(preOrderTree,boundaryIndex+1,end);

        return root;
    }

    public static void main(String[] args){
        int[] preOrderTree = {3,9,1,4,20,15,7};
        int[] inOrderTree = {1,9,4,3,15,20,7};

        ConstructBinaryTreeFromPreorderAndInorderTraversal obj = new ConstructBinaryTreeFromPreorderAndInorderTraversal();
        TreeNode result = obj.constructBinaryTreeFromPreorderAndInorderTraversal(preOrderTree,inOrderTree);

        System.out.print(result.data+",");
        System.out.print(result.leftNode.data+",");
        System.out.print(result.rightNode.data+",");
        System.out.print(result.leftNode.leftNode.data+",");
        System.out.print(result.leftNode.rightNode.data+",");
        System.out.print(result.rightNode.leftNode.data+",");
        System.out.print(result.rightNode.rightNode.data);

    }
}
