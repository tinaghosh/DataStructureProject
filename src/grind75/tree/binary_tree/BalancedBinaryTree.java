package grind75.tree.binary_tree;

import blind75.tree.TreeNode;

public class BalancedBinaryTree {

    public boolean checkBalancedBinaryTree(TreeNode root){

        if(root==null){
            return true;
        }
        if(Math.abs(getHeight(root.leftNode) - getHeight(root.rightNode))>1){
            return false;
        }

        return checkBalancedBinaryTree(root.leftNode) && checkBalancedBinaryTree(root.rightNode);
    }

    public int getHeight(TreeNode node){
        if(node==null){
            return 0;
        }
        return 1+Math.max(getHeight(node.leftNode),getHeight(node.rightNode));
    }
    public static void main(String[] args){

        Object[]  input = {3,9,20,null,null,15,7};

        TreeNode root = new TreeNode((int)input[0]);
        root.leftNode = new TreeNode((int)input[1]);
        root.rightNode = new TreeNode((int)input[2]);
        root.rightNode.leftNode = new TreeNode((int)input[5]);
        root.rightNode.rightNode = new TreeNode((int)input[6]);

        BalancedBinaryTree obj = new BalancedBinaryTree();
        boolean result = obj.checkBalancedBinaryTree(root);

        if(result){
           System.out.println("Given tree is a valid balance binary tree");
        }else{
           System.out.println("Given tree is not a valid balance binary tree");
        }
    }
}
