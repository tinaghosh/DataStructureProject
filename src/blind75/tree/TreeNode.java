package blind75.tree;

public class TreeNode {

    int data;
    TreeNode leftNode;
    TreeNode rightNode;

    TreeNode(){

    }

    TreeNode(int data){
        this.data = data;
        this.leftNode = null;
        this.rightNode = null;
    }

    TreeNode(int data , TreeNode leftNode, TreeNode rightNode){
       this.data = data;
       this.leftNode = leftNode;
       this.rightNode = rightNode;
    }
}

class Pair {

    TreeNode node ;
    int depth;

    Pair(TreeNode node, int depth){
        this.node = node;
        this.depth = depth;
    }

}
