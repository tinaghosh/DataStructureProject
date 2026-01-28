package blind75.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EncodeAndDecodeStrings {

    public String encodeString(List<String> input){
      StringBuilder sb = new StringBuilder();

      for(int i=0;i<input.size();i++){
          int length = input.get(i).length();
          sb.append(length+"#"+input.get(i));
      }
     return sb.toString();
    }

    public List<String> decodedString(String s){
       List<String> output = new ArrayList<>();
       int i=0;

       while(i<s.length()){
         int j=i;
         while(s.charAt(j)!='#'){
             j++;
         }
         int wordLength = Integer.parseInt(s.substring(i,j));
         i = j+1;
         j = i+wordLength;
         output.add(s.substring(i,j));
         i=j;
       }
       return output;
    }

    public static void main(String[] args){

        List<String> input = Arrays.asList("I","love","programming");

        EncodeAndDecodeStrings obj = new EncodeAndDecodeStrings();
        String encodedString = obj.encodeString(input);
        System.out.println(encodedString);

        List<String> result = obj.decodedString(encodedString);
        result.forEach(e->System.out.print(e+" "));
    }
}
