package grind75.tree.binary_tree;

import blind75.tree.TreeNode;

import java.lang.reflect.Array;
import java.util.Arrays;

public class SerializeAndDeserializeBinaryTree {

    public String serialize(TreeNode root){

        if(root==null){
           return "null"+",";
        }
        String s = root.data+",";
        String left = serialize(root.leftNode);
        String right = serialize(root.rightNode);
        String finalString = s+left+right;

        return finalString;
    }

    private int index =0;
    public TreeNode deserialize(String rootString){
        String[] rootArray = rootString.split(",");
        Arrays.stream(rootArray).forEach(e-> System.out.print(e+" "));

        return subTree(rootArray);
    }

    public TreeNode subTree(String[] rootArray) {

        if(rootArray[index].equals("null")){
            index++;
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(rootArray[index]));
        index++;

        root.leftNode = subTree(rootArray);
        root.rightNode = subTree(rootArray);

       return root;
    }

    public static void main(String[] args){

        Object[] rootArray =  {1,2,3,null,null,4,5};

        TreeNode root = new TreeNode((int)rootArray[0]);
        root.leftNode = new TreeNode((int)rootArray[1]);
        root.rightNode = new TreeNode((int)rootArray[2]);
        root.rightNode.leftNode = new TreeNode((int)rootArray[5]);
        root.rightNode.rightNode = new TreeNode((int)rootArray[6]);

        SerializeAndDeserializeBinaryTree obj = new SerializeAndDeserializeBinaryTree();
        String resultOfserialize = obj.serialize(root);
        System.out.println(resultOfserialize);
        TreeNode resultOfderialize = obj.deserialize(resultOfserialize);
        System.out.println(resultOfderialize);
    }
}
