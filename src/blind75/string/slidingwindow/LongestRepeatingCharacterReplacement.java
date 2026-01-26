package blind75.string.slidingwindow;


public class LongestRepeatingCharacterReplacement {

    public int characterReplacement(String s, int k){

        int maxWindowLength = 0;
        int leftPointer = 0;
        int[] alphabetOccurance = new int[26];
        int maxLetterFrequency = 0;


        for(int rightPointer = 0;rightPointer<s.length() ; rightPointer++){

            char c = s.charAt(rightPointer);
            alphabetOccurance[c-'A']++;  // Constraints: s consists of only uppercase English letters.
            maxLetterFrequency = Math.max(maxLetterFrequency, alphabetOccurance[c-'A']);
            int windowLength = rightPointer-leftPointer+1;

            if( windowLength-maxLetterFrequency>k){
                alphabetOccurance[s.charAt(leftPointer)-'A']--;
                windowLength--;
                leftPointer++;
            }
            maxWindowLength = Math.max(maxWindowLength,windowLength);
        }

        return maxWindowLength;
    }
    public static void main(String[] args){

       String s = "AABABBA";
       int k = 1;

       LongestRepeatingCharacterReplacement obj = new LongestRepeatingCharacterReplacement();
       int result = obj.characterReplacement(s,k);
       System.out.println("After Replacement Longest Repeating character length will be : "+result);
    }
}
