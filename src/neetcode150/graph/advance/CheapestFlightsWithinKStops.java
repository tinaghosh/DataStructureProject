package neetcode150.graph.advance;

import java.util.*;

public class CheapestFlightsWithinKStops {

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        int[] visitedCost = new int[n];
        Arrays.fill(visitedCost, Integer.MAX_VALUE);
        visitedCost[src] = 0;

        Deque<Pair> queue = new LinkedList<>();
        queue.add(new Pair(src,0));

        List<List<Pair>> adjList = new ArrayList<>();

        for(int i=0;i<n;i++){
            adjList.add(new ArrayList<>());
        }

        for(int i=0;i<flights.length;i++){
            Pair p = new Pair(flights[i][1],flights[i][2]);
            adjList.get(flights[i][0]).add(p);
        }

        int stopage = 0;

        while(!queue.isEmpty() && stopage<=k){
            int levelSize = queue.size();
            for(int i=0;i<levelSize;i++){

                Pair currentPair = queue.poll();
                int currentStop = currentPair.node;
                int currentCost = currentPair.cost;

                int size = adjList.get(currentStop).size();

                for(int m=0;m<size;m++){
                    int nextStop = adjList.get(currentStop).get(m).node;
                    int nextCost = currentCost + adjList.get(currentStop).get(m).cost;

                    if(visitedCost[nextStop] > nextCost){
                        visitedCost[nextStop] = nextCost;
                        queue.add(new Pair(nextStop,nextCost));
                    }
                }
            }
            stopage++;
        }

        return visitedCost[dst]!=Integer.MAX_VALUE ? visitedCost[dst] : -1;
    }

    class Pair{
        int node ;
        int cost;
        Pair(int node, int cost){
            this.node = node;
            this.cost = cost;
        }
    }

    public static void main(String[] args) {
        int n = 4;
        int[][] flights = {{0,1,100},{1,2,100},{2,0,100},{1,3,600},{2,3,200}};
        int src = 0;
        int dst = 3;
        int k = 1;

        CheapestFlightsWithinKStops obj = new CheapestFlightsWithinKStops();
        int result = obj.findCheapestPrice(n,flights,src,dst,k);
        System.out.println(result);
    }
}
