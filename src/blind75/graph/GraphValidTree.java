package blind75.graph;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GraphValidTree {

    public boolean checkGraphIsValidTree(int n, int[][] edges){

        boolean[] visited = new boolean[n];
        List<List<Integer>> adjList = new ArrayList<>();
        int parent = -1;
        int noOfConnectedComponent = 0;

        if(edges!=null && edges.length == n-1){
            noOfConnectedComponent = 1;
        }else{
            return false;
        }
        System.out.println(noOfConnectedComponent);

        for(int i=0;i<n;i++){
            adjList.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
          adjList.get(edges[i][0]).add(edges[i][1]);
          adjList.get(edges[i][1]).add(edges[i][0]);
        }

        adjList.forEach(eList-> {
            System.out.print("{");
            eList.forEach(e-> System.out.print(e+","));
            System.out.println("}");
        });

        if(noOfConnectedComponent == 1){
          if(detectCycle(adjList,visited,parent) == false){
              return true;
          }
        }
        return false;
    }

    public boolean detectCycle(List<List<Integer>> adjList,boolean[] visited,int parent){
      Arrays.fill(visited,false);

      for(int i=0;i<adjList.size();i++){
          if(visited[i]==false){
              if(isCycleDFS(adjList,visited,-1,i)){
                  return true;
              }
          }
      }
      return false;
    }

    public boolean isCycleDFS(List<List<Integer>> adjList,boolean[] visited,int parent,int index){
        visited[index] = true;

        for(int node: adjList.get(index)){
            if(visited[node]==false){
                if(isCycleDFS( adjList, visited, index, node)){
                    return true;
                }
            } else if (node != parent) {
                return true;
            }
        }
       return  false;
    }

    public static void main(String[] args){
        int n= 5;
        int[][] edges = {{0,1},{0,2},{0,3},{0,4},{3,4}};

        GraphValidTree obj = new GraphValidTree();
        boolean result = obj.checkGraphIsValidTree(n,edges);
        if(result){
            System.out.println("Graph is a valid Tree");
        }else{
            System.out.println("Graph is not a valid Tree");
        }
    }
}
