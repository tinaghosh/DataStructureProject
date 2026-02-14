package blind75.graph;

import java.util.*;

public class AlienDictionary {

    public String alienOrder(List<String> words){

        Map<Character, Set<Character>> adjListGraph = new HashMap<>();
        Map<Character,Integer> indegree = new HashMap<>();
        Queue<Character> queue = new LinkedList<>();
        StringBuilder outputString = new StringBuilder();

        for(String word: words){
            for(int i=0;i<word.length();i++){
              if(!indegree.containsKey(word.charAt(i))) {
                  indegree.put(word.charAt(i), 0);
                  adjListGraph.put(word.charAt(i), new HashSet<>());
              }
            }
        }

        for(int i=0;i<words.size()-1;i++){
            String word1 = words.get(i);
            String word2 = words.get(i+1);
            if(word1.length()>word2.length() && word1.startsWith(word2)){
                return "";
            }
            int pointerMaxLength = Math.min(word1.length(),word2.length());
            for(int pointer = 0; pointer<pointerMaxLength ;pointer++){
                if(word1.charAt(pointer) != word2.charAt(pointer)){
                    if(!adjListGraph.get(word1.charAt(pointer)).contains(word2.charAt(pointer))){
                        adjListGraph.get(word1.charAt(pointer)).add(word2.charAt(pointer));
                        indegree.put(word2.charAt(pointer), indegree.get(word2.charAt(pointer)) + 1);
                    }
                    break;
                }
            }
        }

        adjListGraph.entrySet().forEach(entry->{
            System.out.print(entry.getKey()+"->");
            entry.getValue().forEach(e-> {
                System.out.print("[");
                System.out.print(e+" ");
                System.out.print("]");
            });
            System.out.println();
        });

      indegree.entrySet().forEach(e-> System.out.println(e.getKey()+"->"+e.getValue()));

      for(char cIndex : indegree.keySet()){
          if(indegree.get(cIndex)==0){
              queue.add(cIndex);
          }
      }

      while(!queue.isEmpty()){
          char node = queue.poll();
          outputString.append(node);
          for(char innerNode : adjListGraph.get(node)){
              indegree.put(innerNode,indegree.get(innerNode)-1);
              if(indegree.get(innerNode) == 0){
                 queue.add(innerNode);
              }
          }
      }
      if(!indegree.values().stream().allMatch(e->e==0)){
          return "";
      }
     return outputString.toString();
    }

    public static void main(String[] args){
        List<String> words = List.of("wrt", "wrf", "er", "ett", "rftt");
        List<String> words1 = List.of("cbguqbugezw","xpvsugvv","hzevuvuor","qmfqnanvdmgadkp","ocowmasbcnlqjlusxut","oxhmdyszvxvzz");

        AlienDictionary obj = new AlienDictionary();
        String result = obj.alienOrder(words1);
        System.out.print("\nThe order of the letters in Alien directory is -> "+result);
    }
}
