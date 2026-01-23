package blind75.string.hashmap;

import java.util.*;

public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs){

        List<List<String>> output = new ArrayList<>();
        Map<String,List<String>> map = new HashMap<>();

        for(int i=0;i<strs.length;i++){

           int[] alphabet = new int[26];

           for(char c: strs[i].toCharArray()){
               alphabet[c-'a']++;
           }

           StringBuilder sKey = new StringBuilder();

           for(int n : alphabet){
               sKey.append(("#"));
               sKey.append(n);
           }

           if(map.containsKey(sKey.toString())){
               List<String> getWordList = map.get(sKey.toString());
               getWordList.add(strs[i]);
               map.put(sKey.toString(),getWordList);
           }else{
               List<String> newWordList = new ArrayList<>();
               newWordList.add(strs[i]);
               map.put(sKey.toString(),newWordList);
           }
        }
       // map.entrySet().forEach(e-> System.out.println(e.getKey()+" ---> "+e.getValue()));

        for(Map.Entry<String, List<String>> entry: map.entrySet()){
            output.add(entry.getValue());
        }

        return output;
    }
    public static void main(String[] args){
        String[] input = {"bdddddddddd","bbbbbbbbbbc"};//{"eat","tea","tan","ate","nat","bat"};
        GroupAnagrams obj = new GroupAnagrams();
        List<List<String>> result = obj.groupAnagrams(input);
        result.forEach(e-> System.out.print(e));


    }
}
