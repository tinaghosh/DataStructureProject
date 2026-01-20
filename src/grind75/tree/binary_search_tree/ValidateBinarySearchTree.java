package grind75.tree.binary_search_tree;

import grind75.tree.TreeNode;

public class ValidateBinarySearchTree {

    public boolean validBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        return checkDFSValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean checkDFSValidBST(TreeNode root, long leftLimit, long rightLimit) {

        if (root == null) {
            return true;
        }

        if (!((leftLimit < root.data) && (root.data < rightLimit))) {
            return false;
        }
        return checkDFSValidBST(root.leftNode, leftLimit, root.data) // {Left part Range -infinity <data < 5(root)}
                && checkDFSValidBST(root.rightNode, root.data, rightLimit); // {Right part Range 5(root) <data < +infinity }
    }

    public static void main(String[] args) {
        Object[] rootArray = {5, 1, 4, null, null, 3, 6};

        TreeNode root = new TreeNode((int) rootArray[0]);
        root.leftNode = new TreeNode((int) rootArray[1]);
        root.rightNode = new TreeNode((int) rootArray[2]);
        root.rightNode.leftNode = new TreeNode((int) rootArray[5]);
        root.rightNode.rightNode = new TreeNode((int) rootArray[6]);

        ValidateBinarySearchTree obj = new ValidateBinarySearchTree();
        boolean result = obj.validBST(root);

        if (result) {
            System.out.println("Given Binary tree can be considered as binary search tree.");
        } else {
            System.out.println("Given Binary tree can't be considered as binary search tree.");
        }
    }
}
