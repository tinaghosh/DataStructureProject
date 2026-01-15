package blind75.tree.binarytree;

import blind75.tree.TreeNode;

public class SameTree {

    public boolean compareTree(TreeNode ptree , TreeNode qtree){

        if(ptree!=null && qtree==null){
            return false;
        }

        if(ptree==null && qtree!=null){
            return false;
        }

        if(ptree==null && qtree==null){
            return true;
        }

        if(ptree.data == qtree.data){
            if(compareTree(ptree.leftNode, qtree.leftNode) && (compareTree(ptree.rightNode, qtree.rightNode))){
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }

    public static void main(String[] args){
       int[] ptreeArray = {1,2,3};
       int[] qtreeArray = {1,2,3};

        TreeNode ptree = new TreeNode(ptreeArray[0]);
        ptree.leftNode = new TreeNode(ptreeArray[1]);
        ptree.rightNode = new TreeNode(ptreeArray[2]);

        TreeNode qtree = new TreeNode(qtreeArray[0]);
        qtree.leftNode = new TreeNode(qtreeArray[1]);
        qtree.rightNode = new TreeNode(qtreeArray[2]);

        SameTree obj = new SameTree();
        boolean result = obj.compareTree(ptree,qtree);

        if(result){
            System.out.println("Both the tree is same.");
        }else{
            System.out.println("Both the tree is not same.");
        }
    }
}
