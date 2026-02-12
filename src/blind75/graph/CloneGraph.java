package blind75.graph;


import java.util.*;

public class CloneGraph {

    public GraphNode cloneGraph(GraphNode node){
      if(node == null){
          return null;
      }
      Map<GraphNode,GraphNode> visited = new HashMap<>();
      GraphNode cloneNode = cloneUtil(node,visited);
      return cloneNode;
    }

    public GraphNode cloneUtil(GraphNode node,Map<GraphNode,GraphNode> visited){

        GraphNode cloneNode = new GraphNode(node.data);
        visited.put(node,cloneNode);

        for(GraphNode adjNode : node.neighbors){
            if(visited.containsKey(adjNode)) {
                cloneNode.neighbors.add(visited.get(adjNode));
            }else {
                cloneNode.neighbors.add(cloneUtil(adjNode,visited));
            }
        }
        return cloneNode;
    }


    public static void printGraph(GraphNode node){

        Set<GraphNode> nodeVisitedSet = new HashSet<>();
        Queue<GraphNode> queue = new LinkedList<>();
        queue.add(node);
        nodeVisitedSet.add(node);

        while(!queue.isEmpty()){
           GraphNode currentNode = queue.poll() ;
           System.out.print("Node " + currentNode.getData() + " -> ");
           for(GraphNode neibours : currentNode.neighbors) {
               System.out.print( neibours.getData()+ " ");
               if (!nodeVisitedSet.contains(neibours)) {
                   queue.add(neibours);
                   nodeVisitedSet.add(neibours);
               }
           }
           System.out.println();
        }
   }
    public static void main(String[] args){

        int[][] graph = {{2,4},{1,3},{2,4},{1,3}} ;

        GraphNode node1 = new GraphNode(1);
        GraphNode node2 = new GraphNode(2);
        GraphNode node3 = new GraphNode(3);
        GraphNode node4 = new GraphNode(4);


        node1.neighbors.add(node2);
        node1.neighbors.add(node4);

        node2.neighbors.add(node1);
        node2.neighbors.add(node3);

        node3.neighbors.add(node2);
        node3.neighbors.add(node4);

        node4.neighbors.add(node1);
        node4.neighbors.add(node3);

        CloneGraph obj = new CloneGraph();
        GraphNode result = obj.cloneGraph(node1);

        System.out.println("Original Graph:");
        printGraph(node1);

        System.out.println("\nCloned Graph:");
        printGraph(result);

    }
}

class GraphNode {
    int data;
    List<GraphNode> neighbors;

    public GraphNode(){
        this.data = 0;
        this.neighbors = new ArrayList<>();
    }

    public GraphNode(int data){
        this.data = data;
        this.neighbors = new ArrayList<>();
    }

    public GraphNode(int data,List<GraphNode> neibours){
        this.data = data;
        this.neighbors = neibours;
    }

    public int getData() {
        return data;
    }
}
