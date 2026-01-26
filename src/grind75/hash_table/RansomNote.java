package grind75.hash_table;

import java.util.HashMap;
import java.util.Map;

public class RansomNote {

    public boolean ransomNotePossibleFromMagazineUsingArray(String ransomNote,String magazine){

        int[] occurance = new int[26];

        for(Character c:magazine.toCharArray()){
            occurance[c-'a']++;
        }

        for(Character c:ransomNote.toCharArray()){
            if(occurance[c-'a']==0){
                return false;
            }
            occurance[c-'a']--;
        }
        return true;
    }

    public static void main(String[] args){
        String ransomNote = "aa";
        String magazine = "aab";

        RansomNote obj = new RansomNote();
        boolean result = obj.ransomNotePossibleFromMagazineUsingArray(ransomNote,magazine);
        if(result){
            System.out.println("We can create ransome note from the given magazine");
        }else{
            System.out.println("We can not create ransome note from the given magazine");
        }

    }
}
