package blind75.graph;

import java.util.ArrayList;
import java.util.List;

public class NumberOfConnectedComponentsInAnUndirectedGraph {

    public int numberOfConnectedComponentsInAnUndirectedGraph(int node , int[][] edges){

       int count = 0;
       boolean[] visited = new boolean[node];
       List<List<Integer>> adjList = new ArrayList<>();

       for(int i=0;i<node;i++){
           adjList.add(new ArrayList<>());
       }

       for(int i=0;i<edges.length;i++){
            adjList.get(edges[i][0]).add(edges[i][1]);
            adjList.get(edges[i][1]).add(edges[i][0]);
       }

       for(int i=0;i<node;i++){
           if(!visited[i]) {
            count++;
            recursion(adjList,visited,i);
           }
       }
       return count;
    }

    public void recursion(List<List<Integer>> adjList,boolean[] visited , int index){

        visited[index] = true;

         for(int enode : adjList.get(index)){
             if(visited[enode] == false) {
               recursion(adjList,visited,enode);
             }
         }
    }

    public static void main(String[] args){
        int node = 8;
        int[][] edges = {{0,1},{1,2},{4,5},{6,7}};

        NumberOfConnectedComponentsInAnUndirectedGraph obj = new NumberOfConnectedComponentsInAnUndirectedGraph();
        int result = obj.numberOfConnectedComponentsInAnUndirectedGraph(node,edges);
        System.out.println("Number Of total Connected Components in the given Undirected Graph is -> "+result);
     }
}
