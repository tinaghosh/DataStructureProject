package grind75.string.hashmap;

import java.util.*;

public class FindAllAnagramsInAString {

    public List<Integer> findAllAnagraInAStringUsingMap(String s, String p) {

        if (p.length() > s.length()) {
            return new ArrayList<>();
        }
        List<Integer> output = new ArrayList<>();

        Map<Character, Integer> table = new HashMap<>();

        for (Character c : p.toCharArray()) {
            if (table.containsKey(c)) {
                int value = table.get(c);
                table.put(c, value + 1);
            } else {
                table.put(c, 1);
            }
        }
        System.out.println("After Creating initial Map: ");
        table.entrySet().forEach(e -> System.out.print(e.getKey() + "-->" + e.getValue()));

        int start_pointer = 0;
        int end_pointer = 0;
        while (end_pointer < s.length()) {

            char endChar = s.charAt(end_pointer);
            if(table.containsKey(endChar)){
                table.put(s.charAt(end_pointer),table.get(s.charAt(end_pointer))-1);
            }

            if((end_pointer - start_pointer + 1) == p.length()){
                char startChar = s.charAt(start_pointer);
                if(table.values().stream().allMatch(eValue->eValue==0)){
                    output.add(start_pointer);
                }
                if(table.containsKey(startChar)){
                    table.put(startChar,table.get(startChar)+1);
                }
                start_pointer ++;
            }
            end_pointer++;
        }
        return output;
    }

    public List<Integer> findAllAnagraInAStringUsingArray(String s, String p) {

        if (p.length() > s.length()) {
            return new ArrayList<>();
        }
        List<Integer> output = new ArrayList<>();

        int[] table = new int[26];

        for (Character c : p.toCharArray()) {
           table[c-'a']++;
        }

        int start_pointer = 0;
        int end_pointer = 0;
        while (end_pointer < s.length()) {

            char endChar = s.charAt(end_pointer);
            table[endChar-'a']--;

            if((end_pointer - start_pointer + 1) == p.length()){

                if(Arrays.stream(table).allMatch(eValue->eValue==0)){
                    output.add(start_pointer);
                }
                char startChar = s.charAt(start_pointer);
                table[startChar-'a']++;
                start_pointer ++;
            }
            end_pointer++;
        }
        return output;
    }

    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";

        FindAllAnagramsInAString obj = new FindAllAnagramsInAString();
        List<Integer> resultMap = obj.findAllAnagraInAStringUsingMap(s, p);
        System.out.println();
        resultMap.stream().forEach(e -> System.out.print(e + ","));
        List<Integer> resultArray = obj.findAllAnagraInAStringUsingArray(s, p);
        System.out.println();
        resultArray.stream().forEach(e -> System.out.print(e + ","));
    }
}

