package blind75.string.hashmap;

import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {

    public boolean checkValidAnagramWithoutExtraSpace(String s, String t){

            if(s.length() != t.length()){
                return false;
            }

            int[] alphabet = new int[26];

            for (int i = 0; i < s.length(); i++) {
                alphabet[s.charAt(i) - 'a']++;
            }

            for (int i = 0; i < t.length(); i++){
                alphabet[t.charAt(i) - 'a']--;
                if(alphabet[t.charAt(i) - 'a'] < 0) {
                    return false;
                }
            }
      return true;
    }

    public boolean checkValidAnagram(String t, String s){

        if(s.length()!=t.length()){
            return false;
        }

        Map<Character,Integer> table = new HashMap<>();

        for(Character c : s.toCharArray()){
            if(table.containsKey(c)){
                table.put(c,table.get(c)+1);
            }else{
                table.put(c,1);
            }
        }

        for(Character c : t.toCharArray()){
            if(table.containsKey(c)){
                table.put(c,table.get(c)-1);
            }else{
               return false;
            }
        }

      for(Map.Entry<Character,Integer> e : table.entrySet()){
         if(e.getValue()!=0){
             return false;
         }
      }
        return true;
    }

    public static void main(String[] args){
      String  s = "anagram"; //"rat";
      String t =  "nngaram" ; //"car";

        ValidAnagram obj = new ValidAnagram();
        boolean result = obj.checkValidAnagram(s,t);
        boolean resultWithoutExtraSpace = obj.checkValidAnagramWithoutExtraSpace(s,t);

        if(result){
            System.out.println("\nProvided input strings are anagram");
        }else{
            System.out.println("\nProvided input strings are not anagram");
        }

        if(resultWithoutExtraSpace){
            System.out.println("\nProvided input strings are anagram");
        }else{
            System.out.println("\nProvided input strings are not anagram");
        }

    }
}
