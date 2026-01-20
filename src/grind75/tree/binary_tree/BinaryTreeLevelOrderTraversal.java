package grind75.tree.binary_tree;

import grind75.tree.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {

    public List<List<Integer>> binaryTreeLevelOrderTraversal(TreeNode root) {
        List<List<Integer>> output = new ArrayList<>();

        if (root == null) {
            return output;
        } else {
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);

            while (!queue.isEmpty()) {

                int levelSize = queue.size();
                List<Integer> inner = new ArrayList<>();

                for (int i = 0; i < levelSize; i++) {
                    TreeNode node = queue.poll();
                    inner.add(node.data);

                    if (node.leftNode != null) {
                        queue.add(node.leftNode);
                    }
                    if (node.rightNode != null) {
                        queue.add(node.rightNode);
                    }
                }
                output.add(inner);
            }
        }

        return output;
    }

    public static void main(String[] args) {
        Object[] input = {3, 9, 20, null, null, 15, 7};

        TreeNode root = new TreeNode((int) input[0]);
        root.leftNode = new TreeNode((int) input[1]);
        root.rightNode = new TreeNode((int) input[2]);
        root.rightNode.leftNode = new TreeNode((int) input[5]);
        root.rightNode.rightNode = new TreeNode((int) input[6]);

        BinaryTreeLevelOrderTraversal obj = new BinaryTreeLevelOrderTraversal();
        List<List<Integer>> result = obj.binaryTreeLevelOrderTraversal(root);
        result.forEach(e -> {
            System.out.println(e);
        });
    }
}
