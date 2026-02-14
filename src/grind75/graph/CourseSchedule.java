package grind75.graph;

import java.util.*;

public class CourseSchedule {
    public boolean canFinishCourseBFS(int numCourses,int[][] prerequisites){

        List<List<Integer>> adjList = new ArrayList<>();
        int[] indegree = new int[numCourses] ;
        Queue<Integer> queue = new LinkedList<>();

        for(int i=0;i<numCourses;i++){
            adjList.add(new ArrayList<>());
        }
        for(int i=0;i<prerequisites.length;i++){
            adjList.get(prerequisites[i][1]).add(prerequisites[i][0]);
            indegree[prerequisites[i][0]]++;
        }

        adjList.forEach(eList-> {
            System.out.print("{");
            eList.forEach(e-> System.out.print(e+","));
            System.out.println("}");
        });

        Arrays.stream(indegree).forEach(e-> System.out.print(e+" "));

        for(int i=0;i<indegree.length;i++){
            if(indegree[i] == 0){
                queue.add(i);
            }
        }
        while(!queue.isEmpty()){
            int node = queue.poll();
            List<Integer> nodeList = adjList.get(node);

            for(int i=0;i<nodeList.size();i++){
                int index = nodeList.get(i);
                indegree[index] = indegree[index]-1;
                if(indegree[index]==0){
                    queue.add(index);
                }
            }
        }

        if(Arrays.stream(indegree).allMatch(e-> e==0)){
            return true;
        }else {
            return false;
        }
    }

    public boolean canFinishCourseDFS(int numCourses,int[][] prerequisites) {

        List<List<Integer>> adjList = new ArrayList<>();
        boolean[] inrecursion = new boolean[numCourses] ;
        boolean[] visited = new boolean[numCourses];


        for(int i=0;i<numCourses;i++){
            adjList.add(new ArrayList<>());
        }
        for(int i=0;i<prerequisites.length;i++){
            adjList.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }

        adjList.forEach(eList-> {
            System.out.print("{");
            eList.forEach(e-> System.out.print(e+","));
            System.out.println("}");
        });

        for(int i=0;i<numCourses;i++){
            if(visited[i]==false){
                if(isCycle(adjList,inrecursion,visited,i)){
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isCycle(List<List<Integer>> adjList,boolean[] inrecursion,boolean[] visited,int index){
        inrecursion[index] = true;
        visited[index] = true;

        List<Integer> nodeList = adjList.get(index);
        for(int node : nodeList){
            if(visited[node] == false) {
                if (isCycle(adjList, inrecursion, visited, node)) {
                    return true; //cycle detected in current iteration
                } else if (inrecursion[node] == true) {
                    return true;
                }
            }
        }
        inrecursion[index] = false;
        return false;
    }

    public static void main(String[] args){
        int numCourses = 5;
        int[][] prerequisites = {{1,4},{2,4},{3,1},{3,2}};

        CourseSchedule obj = new CourseSchedule();
        boolean resultBFS = obj.canFinishCourseBFS(numCourses,prerequisites);
        if(resultBFS){
            System.out.println("\nyou can finish all courses");
        }else{
            System.out.println("\nyou can't finish all courses");
        }

        boolean resultDFS = obj.canFinishCourseDFS(numCourses,prerequisites);
        if(resultDFS){
            System.out.println("you can finish all courses");
        }else{
            System.out.println("you can't finish all courses");
        }

    }
}
