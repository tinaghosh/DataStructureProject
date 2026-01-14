package grind75.binary_tree;

public class DiameterOfBinaryTree {

    int longestPath = 0;

    public int lengthOfLongestPath(TreeNode root ){
        getHeight(root);
        return longestPath;
    }

    public int getHeight(TreeNode root){

        if(root==null){
           return 0;
        }else{
            int left = getHeight(root.leftNode);
            int right = getHeight(root.rightNode);
            System.out.println(root.data+"---->"+left+"---->"+right);
            longestPath = Math.max(longestPath,left+right );
            return 1 + Math.max(left, right);
        }
    }

    public static void main(String[] args){

        int[] input = {1,2,3,4,5};
        TreeNode root = new TreeNode(input[0]);
        root.leftNode = new TreeNode(input[1]);
        root.rightNode = new TreeNode(input[2]);
        root.leftNode.leftNode = new TreeNode(input[3]);
        root.leftNode.rightNode = new TreeNode(input[4]);

        int[] input1 = {1,2,3,4,5,6};
        TreeNode root1 = new TreeNode(input1[0]);
        root1.leftNode = new TreeNode(input1[1]);
        root1.leftNode.leftNode = new TreeNode(input1[2]);
        root1.leftNode.rightNode = new TreeNode(input1[3]);
        root1.leftNode.leftNode.leftNode = new TreeNode(input1[4]);
        root1.leftNode.rightNode.rightNode = new TreeNode(input1[5]);

        DiameterOfBinaryTree obj = new DiameterOfBinaryTree();
        int result = obj.lengthOfLongestPath(root1);
        System.out.println("The diameter of a binary tree -> " +
                "the length of the longest path between any two nodes in a tree is ->"+result);

    }
}
