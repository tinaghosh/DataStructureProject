package grind75.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MinimumHeightTrees {

    public List<Integer> minimumHeightTreesRoots(int n, int[][] edges){

        if(n==1){
            return List.of(0);
        }
        List<List<Integer>> adjList = new ArrayList<>();

        for(int i=0;i<=edges.length;i++){
            adjList.add(new ArrayList<>());
        }
        for(int[] edge :edges){
           adjList.get(edge[0]).add(edge[1]);
           adjList.get(edge[1]).add(edge[0]);
        }

        adjList.forEach(e->{
            System.out.print("[");
            e.forEach(einner->System.out.print(einner+" "));
            System.out.println("]");
        });

        List<Integer> leafNode = new ArrayList<>();

        for(int i=0;i<adjList.size();i++){
           if(adjList.get(i)!=null && adjList.get(i).size()==1){
               leafNode.add(i);
           }
        }

        int remainingNode = n;
        while(remainingNode>2){
            remainingNode = remainingNode - leafNode.size();
            List<Integer> newLeaves = new ArrayList<>();
            for(int leaf : leafNode){
               int neiboursNode = adjList.get(leaf).get(0);
               adjList.get(neiboursNode).remove((Integer)leaf); //(Integer) will treat it as leaf
                                                                 // is value which we need to remove  not the index

               if(adjList.get(neiboursNode)!=null && adjList.get(neiboursNode).size()==1){
                   newLeaves.add(neiboursNode);
               }
            }
            leafNode = newLeaves;
        }
        return leafNode;
    }
    public static void main(String[] args){
       int n = 6 ;
       int[][] edges = {{3,0},{3,1},{3,2},{3,4},{5,4}};

        MinimumHeightTrees obj = new MinimumHeightTrees();
        List<Integer> results = obj.minimumHeightTreesRoots(n,edges);
        results.forEach(e->System.out.print(e+" "));
    }
}
