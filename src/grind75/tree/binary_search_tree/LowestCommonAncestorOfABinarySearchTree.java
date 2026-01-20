package grind75.tree.binary_search_tree;

import blind75.tree.TreeNode;


public class LowestCommonAncestorOfABinarySearchTree {

    public TreeNode lowestCommonAncestorOfABST(TreeNode root, TreeNode p , TreeNode q){

        if(root == null){
            return null;
        }
        if(root.data == p.data || root.data == q.data){
            return root;
        }
        if(p.data < root.data && q.data < root.data ){

            return lowestCommonAncestorOfABST(root.leftNode,p,q);

        } else if(p.data > root.data && q.data > root.data ){

            return lowestCommonAncestorOfABST(root.rightNode ,p,q);
        }

        return root;
    }

    public static void main(String[] args){

       Object[] rootArray = {6,2,8,0,4,7,9,null,null,3,5};
       TreeNode p = new TreeNode(4);
       TreeNode q = new TreeNode(7) ;

        TreeNode root = new TreeNode((int)rootArray[0]);
        root.leftNode = new TreeNode((int)rootArray[1]);
        root.rightNode = new TreeNode((int)rootArray[2]);
        root.leftNode.leftNode = new TreeNode((int)rootArray[3]);
        root.leftNode.rightNode = new TreeNode((int)rootArray[4]);
        root.rightNode.leftNode = new TreeNode((int)rootArray[5]);
        root.rightNode.rightNode = new TreeNode((int)rootArray[6]);
        root.leftNode.rightNode.leftNode = new TreeNode((int)rootArray[9]);
        root.leftNode.rightNode.rightNode = new TreeNode((int)rootArray[10]);

        LowestCommonAncestorOfABinarySearchTree obj = new LowestCommonAncestorOfABinarySearchTree();
        TreeNode result = obj.lowestCommonAncestorOfABST(root,p,q);
        System.out.println(result.data);

    }
}
