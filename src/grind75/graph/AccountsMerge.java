package grind75.graph;

import java.util.*;

public class AccountsMerge {

     public List<List<String>> accountsMerge(List<List<String>> accounts){

         UnionFind unionFind = new UnionFind();
         Map<String,String> emailToName = new HashMap<>();
         Map<String,List<String>> groups = new HashMap<>();
         List<List<String>> results = new ArrayList<>();

         for(List<String> list : accounts){
             String name = list.get(0);
             for(int i=1;i<list.size();i++){
                 String email = list.get(i);
                 unionFind.parent.put(email,email);
                 emailToName.put(email,name);
             }
         }

         for(List<String> list: accounts){
             String mainEmail = list.get(1);
             for(int i=2;i<list.size();i++){
                 unionFind.union(mainEmail,list.get(i));
             }
         }

         for(String entry : unionFind.parent.keySet()){
             String parent = unionFind.find(entry);
             if(groups.containsKey(parent)){
                 List<String> inner = groups.get(parent);
                 inner.add(entry);
                 groups.put(parent,inner);
             }else{
                 List<String> inner =  new ArrayList<>();
                 inner.add(entry);
                 groups.put(parent,inner);
             }
         }

         for(String root : groups.keySet()){
             List<String> rootSet = groups.get(root);
             Collections.sort(rootSet);
             String name = emailToName.get(root);
             rootSet.addFirst(name);
             results.add(rootSet);
         }
         return results;
     }

    public static void main(String[] args){
        List<List<String>> accounts = List.of(List.of("John","johnsmith@mail.com","john_newyork@mail.com"),
                                              List.of("John","johnsmith@mail.com","john00@mail.com"),
                                              List.of("Mary","mary@mail.com"),
                                              List.of("John","johnnybravo@mail.com"));

        AccountsMerge obj = new AccountsMerge();
        List<List<String>> result = obj.accountsMerge(accounts);
        result.forEach(e->{
            System.out.print("[");
            e.forEach(einner-> System.out.print(einner+" , "));
            System.out.println("]");
        });
    }

    private static class UnionFind{
         Map<String, String> parent = new HashMap<>();

        public String find(String a){
          if(!parent.get(a).equals(a)){
              String localParent = find(parent.get(a));
              return localParent;
          }else{
              return a;
          }
        }

         public void union(String a, String b){
             String roota = find(a);
             String rootb = find(b);
             if(!roota.equals(rootb)) {
                 parent.put(rootb, roota);
             }
         }
    }
}
