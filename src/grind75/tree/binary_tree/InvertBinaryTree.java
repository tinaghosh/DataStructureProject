package grind75.tree.binary_tree;

import grind75.tree.TreeNode;

public class InvertBinaryTree {

    public TreeNode invertBinaryTree(TreeNode root){

        if(root==null){
            return null;
        }else{
            TreeNode left = invertBinaryTree(root.leftNode);
            TreeNode right = invertBinaryTree(root.rightNode);

            root.leftNode = right;
            root.rightNode = left;
        }

        return root;
    }

    public static void main(String[] args) {
        int[] rootArray = {4, 2, 7, 1, 3, 6, 9};

        TreeNode root = new TreeNode(rootArray[0]);
        root.leftNode = new TreeNode(rootArray[1]);
        root.rightNode = new TreeNode(rootArray[2]);
        root.leftNode.leftNode = new TreeNode(rootArray[3]);
        root.leftNode.rightNode = new TreeNode(rootArray[4]);
        root.rightNode.leftNode = new TreeNode(rootArray[5]);
        root.rightNode.rightNode = new TreeNode(rootArray[6]);

        InvertBinaryTree obj = new InvertBinaryTree();
        TreeNode result = obj.invertBinaryTree(root);

        System.out.println(result.data);
        System.out.println(result.leftNode.data);
        System.out.println(result.rightNode.data);
        System.out.println(result.leftNode.leftNode.data);
        System.out.println(result.leftNode.rightNode.data);
        System.out.println(result.rightNode.leftNode.data);
        System.out.println(result.rightNode.rightNode.data);
    }
}
