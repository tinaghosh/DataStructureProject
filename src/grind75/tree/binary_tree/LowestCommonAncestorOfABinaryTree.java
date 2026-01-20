package grind75.tree.binary_tree;

import grind75.tree.TreeNode;

public class LowestCommonAncestorOfABinaryTree {

    public TreeNode lowestCommonAncestorOfABinaryTree(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null) {
            return null;
        }
        if (root.data == p.data || root.data == q.data) {
            return root;
        }

        TreeNode left = lowestCommonAncestorOfABinaryTree(root.leftNode, p, q);
        TreeNode right = lowestCommonAncestorOfABinaryTree(root.rightNode, p, q);

        if(left!=null && right == null){
            return left;
        }
        if(left==null && right!= null){
            return right;
        }
        if(left!=null && right!=null){
            return root;
        }
        return null;
    }

    public static void main(String[] args) {
        Object[] rootArray = {3, 5, 1, 6, 2, 0, 8, null, null, 7, 4};
        TreeNode p = new TreeNode(5);
        TreeNode q = new TreeNode(4);

        TreeNode root = new TreeNode((int) rootArray[0]);
        root.leftNode = new TreeNode((int) rootArray[1]);
        root.rightNode = new TreeNode((int) rootArray[2]);
        root.leftNode.leftNode = new TreeNode((int) rootArray[3]);
        root.leftNode.rightNode = new TreeNode((int) rootArray[4]);
        root.rightNode.leftNode = new TreeNode((int) rootArray[5]);
        root.rightNode.rightNode = new TreeNode((int) rootArray[6]);
        root.leftNode.rightNode.leftNode = new TreeNode((int) rootArray[9]);
        root.leftNode.rightNode.rightNode = new TreeNode((int) rootArray[10]);

        LowestCommonAncestorOfABinaryTree obj = new LowestCommonAncestorOfABinaryTree();
        TreeNode result = obj.lowestCommonAncestorOfABinaryTree(root, p, q);
        System.out.println(result.data);

    }
}
