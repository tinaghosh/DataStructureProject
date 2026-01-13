package grind75.binary_tree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class MaximumDepthOfBinaryTree {

    //Recursive DFS
    public int findMaxDepthOfBinaryTreeUsingRecursiveDFS(TreeNode root){

        int depth;

        if(root == null){
            depth = 0;
        }else{
           depth = 1+ Math.max(findMaxDepthOfBinaryTreeUsingRecursiveDFS(root.leftNode),findMaxDepthOfBinaryTreeUsingRecursiveDFS(root.rightNode));
        }
      return depth;
    }

    //Iterative DFS
    public int findMaxDepthOfBinaryTreeUsingIterativeDFS(TreeNode root){
        int depth = 0;

        if(root == null){
            return depth;
        }else {

            Stack<Pair> stack = new Stack<>();
            stack.push(new Pair(root,depth+1));

            while(!stack.isEmpty()){
                   Pair pairNode = stack.pop();
                   depth = Math.max(depth, pairNode.depth);

                   if(pairNode.node.leftNode!=null){
                       stack.add(new Pair(pairNode.node.leftNode,pairNode.depth+1));
                   }
                   if(pairNode.node.rightNode!=null){
                       stack.add(new Pair(pairNode.node.rightNode,pairNode.depth+1));
                   }
            }
        }
        return depth;
    }

    //BFS
    public int findMaxDepthOfBinaryTreeUsingBFS(TreeNode root) {

        int depth = 0;

        if (root == null) {
            return depth;
        } else {

            Deque<TreeNode> queue = new LinkedList();
            queue.add(root);

            while (!queue.isEmpty()) {
                for (int i = 0; i < queue.size(); i++) {
                    TreeNode node = queue.pop();
                    if (node.leftNode != null) {
                        queue.add(node.leftNode);
                    }
                    if (node.rightNode != null) {
                        queue.add(node.rightNode);
                    }
                }
                depth++;
            }
        }
        return depth;
    }


public static void main(String[] args){

    Object[] rootArray = {3,9,20,null,null,15,7};

    TreeNode root = new TreeNode((int)rootArray[0]);
    root.leftNode = new TreeNode((int)rootArray[1]);
    root.rightNode = new TreeNode((int)rootArray[2]);
    root.rightNode.leftNode = new TreeNode((int)rootArray[5]);
    root.rightNode.rightNode = new TreeNode((int)rootArray[6]);

    MaximumDepthOfBinaryTree obj = new MaximumDepthOfBinaryTree();

    int result = obj.findMaxDepthOfBinaryTreeUsingRecursiveDFS(root);
    System.out.println("Maximum Depth Of Binary Tree is using Recursive DFS : "+result);

    int result2 = obj.findMaxDepthOfBinaryTreeUsingIterativeDFS(root);
    System.out.println("Maximum Depth Of Binary Tree is using Iterative DFS : "+result2);

    int result3 = obj.findMaxDepthOfBinaryTreeUsingBFS(root);
    System.out.println("Maximum Depth Of Binary Tree is using BFS : "+result3);

  }
}
