package blind75.tree.binarytree;

import blind75.tree.TreeNode;

public class SubtreeOfAnotherTree {

    public boolean isSubTree(TreeNode originalTree, TreeNode subTree){

        if(originalTree==null && subTree == null){
            return true;
        }

        if(originalTree!=null && subTree == null){
            return true;
        }

        if(originalTree==null && subTree != null){
            return false;
        }
        /*if(sameTree(originalTree,subTree)){
            return true;
        }*/
        return isSubTree(originalTree.leftNode,subTree) || isSubTree(originalTree.rightNode,subTree) || sameTree(originalTree,subTree) ;
    }

    public boolean sameTree(TreeNode originalTree, TreeNode subTree){

        if(originalTree==null && subTree == null){
            return true;
        }

        if(originalTree!=null && subTree == null){
            return false;
        }

        if(originalTree==null && subTree != null){
            return false;
        }

        if(originalTree.data == subTree.data){
            return sameTree(originalTree.leftNode,subTree.leftNode) && sameTree(originalTree.rightNode,subTree.rightNode);
        }else{
            return false;
        }
    }

    public static void main(String[] args){
        Object[] originalTreeArray = {3,4,5,1,2,null,null,null,null,0};
        //Object[] originalTreeArray = {3,4,5,1,2};
        int[] subTreeArray = {4,1,2};

        TreeNode originalTree = new TreeNode((int)originalTreeArray[0]);
        originalTree.leftNode = new TreeNode((int)originalTreeArray[1]);
        originalTree.rightNode = new TreeNode((int)originalTreeArray[2]);
        originalTree.leftNode.leftNode = new TreeNode((int)originalTreeArray[3]);
        originalTree.leftNode.rightNode = new TreeNode((int)originalTreeArray[4]);
        originalTree.leftNode.rightNode.leftNode = new TreeNode((int)originalTreeArray[4]);

        TreeNode subTree = new TreeNode((int)subTreeArray[0]);
        subTree.leftNode = new TreeNode((int)subTreeArray[1]);
        subTree.rightNode = new TreeNode((int)subTreeArray[2]);

        SubtreeOfAnotherTree obj = new SubtreeOfAnotherTree();
        boolean result = obj.isSubTree(originalTree,subTree);
        if(result){
            System.out.println("SubTree is Part of Another Tree");
        }else{
            System.out.println("SubTree is not Part of Another Tree");
        }
    }
}
