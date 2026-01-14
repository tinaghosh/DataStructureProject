package grind75.binary_tree;

import java.util.*;

public class BinaryTreeRightSideView {

    public List<Integer> rightSieViewOfATree(TreeNode root){

        List<Integer> output = new ArrayList<>();

        if(root==null){
            return output;
        }else {
            Deque<TreeNode> queue = new LinkedList<>();
            queue.add(root);

            while (!queue.isEmpty()) {
                int levelSize = queue.size();
                for (int i = 0; i < levelSize; i++) {
                    TreeNode node = queue.pop();

                    if (i == levelSize - 1) {
                        output.add(node.data);
                    }

                    if (node.leftNode != null) {
                        queue.add(node.leftNode);
                    }
                    if (node.rightNode != null) {
                        queue.add(node.rightNode);
                    }
                }
            }
            return output;
        }
    }

    public static void main(String[] args){

        Object[] nums = {1,2,3,null,5,null,4};
        Object[] nums1 = {1,2,3,5,6};

        TreeNode root = new TreeNode((int)nums[0]);
        root.leftNode = new TreeNode((int)nums[1]);
        root.rightNode = new TreeNode((int)nums[2]);
        root.leftNode.rightNode = new TreeNode((int)nums[4]);
        root.rightNode.rightNode = new TreeNode((int)nums[6]);

        TreeNode root1 = new TreeNode((int)nums1[0]);
        root1.leftNode = new TreeNode((int)nums1[1]);
        root1.rightNode = new TreeNode((int)nums1[2]);
        root1.leftNode.leftNode = new TreeNode((int)nums1[3]);
        root1.leftNode.rightNode = new TreeNode((int)nums1[4]);

        BinaryTreeRightSideView obj = new BinaryTreeRightSideView();
        List<Integer> result = obj.rightSieViewOfATree(root1);
        result.forEach(e-> System.out.print(e+","));

    }
}
