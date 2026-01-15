package grind75.tree;

public class TreeNode {

    public int data;
    public TreeNode leftNode;
    public TreeNode rightNode;

    public TreeNode() {

    }

    public TreeNode(int data) {
        this.data = data;
        this.leftNode = null;
        this.rightNode = null;
    }

    public TreeNode(int data, TreeNode leftNode, TreeNode rightNode) {
        this.data = data;
        this.leftNode = leftNode;
        this.rightNode = rightNode;
    }

}
