package grind75.graph;

import java.util.*;


public class CloneGraph {

    public GraphNode cloneNode(GraphNode node){

        if(node == null){
            return null;
        }
        Map<GraphNode,GraphNode> visitedNodeList = new HashMap<>();
     return cloneUtil(node,visitedNodeList);
    }

    public GraphNode cloneUtil(GraphNode node, Map<GraphNode,GraphNode> visitedNodeList){

        GraphNode cloneNode = new GraphNode(node.data);
        visitedNodeList.put(node,cloneNode);

        for(GraphNode neighbours : node.neiboursNodeList){
            if(visitedNodeList.containsKey(neighbours)){
                cloneNode.neiboursNodeList.add(visitedNodeList.get(neighbours));
            }else{
                cloneNode.neiboursNodeList.add(cloneUtil(neighbours,visitedNodeList));
            }
        }
     return cloneNode;
    }

    public static void printGraph(GraphNode node){

        Queue<GraphNode> queue = new LinkedList<>();
        Set<GraphNode> nodeVisited = new HashSet<>();
        queue.add(node);
        nodeVisited.add(node);

        while(!queue.isEmpty()){
           GraphNode currentNode = queue.poll();
            System.out.print("Node "+currentNode.data+"--->");
            for(GraphNode neibours : currentNode.neiboursNodeList){
                   System.out.print(neibours.data+" ");
                   if(!nodeVisited.contains(neibours)){
                       queue.add(neibours);
                       nodeVisited.add(neibours);
                   }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] graph = {{2, 4}, {1, 3}, {2, 4}, {1, 3}};

        GraphNode node1 = new GraphNode(1);
        GraphNode node2 = new GraphNode(2);
        GraphNode node3 = new GraphNode(3);
        GraphNode node4 = new GraphNode(4);

        node1.neiboursNodeList.add(node2);
        node1.neiboursNodeList.add(node4);

        node2.neiboursNodeList.add(node1);
        node2.neiboursNodeList.add(node3);

        node3.neiboursNodeList.add(node2);
        node3.neiboursNodeList.add(node4);

        node4.neiboursNodeList.add(node1);
        node4.neiboursNodeList.add(node3);

        System.out.println("Original Graph:");
        printGraph(node1);

        CloneGraph obj = new CloneGraph();
        GraphNode result = obj.cloneNode(node1);

        System.out.println("\nCloned Graph:");
        printGraph(result);
    }

     private static class GraphNode{
        int data;
        List<GraphNode> neiboursNodeList;

        public GraphNode(){
            this.data = 0;
            this.neiboursNodeList =null;
        }

        public GraphNode(int data){
            this.data = data;
            this.neiboursNodeList =new ArrayList<>();
        }

        public GraphNode(int data, List<GraphNode> nodeList){
            this.data = data;
            this.neiboursNodeList = nodeList;
        }
    }
}
