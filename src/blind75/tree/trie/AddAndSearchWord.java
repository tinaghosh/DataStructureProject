package blind75.tree.trie;

public class AddAndSearchWord {

     TrieNode root;

     public AddAndSearchWord(){
         root = new TrieNode();
     }

     public void addWord(String word){

         TrieNode currentNode = root;
         char[] wordToCharArray = word.toCharArray();

         for(char c:wordToCharArray){
             if(!currentNode.containsKey(c)){
                 currentNode.children[c-'a'] = new TrieNode();
             }
             currentNode = currentNode.get(c);
         }
         currentNode.setEndNode(true);
     }

     public boolean search(String word){
         return searchUtil(root,word);
     }

     public boolean searchUtil(TrieNode root , String word){
         TrieNode currentNode = root;
         char[] wordToCharArray = word.toCharArray();

         for(int w=0;w<wordToCharArray.length;w++){
             char c = wordToCharArray[w];
             if( c == '.') {
                 for(int i=0;i<26;i++){
                     if(currentNode.children[i]!=null){
                         if(searchUtil(currentNode.children[i],word.substring(w+1,wordToCharArray.length))){
                             return true;
                         }
                     }
                 }
                 return false;
             }else {
                 if(currentNode.containsKey(c)){
                     currentNode = currentNode.get(c);
                 }else {
                     return false;
                 }
             }
         }
         if(currentNode!=null && currentNode.isEndNode()==true){
             return true;
         }
         return false;
     }

    public static void main(String[] args){

        String[] operations = {"WordDictionary","addWord","addWord","addWord","search","search","search","search"};

        String[][] words = {{}, {"bad"},{"dad"},{"mad"},{"pad"},{"bad"},{".ad"},{"b.."}};

        AddAndSearchWord trieObj = null;
        int index = 0;

        for(String operation : operations){
            System.out.println("Operation-> "+operation);
            if(operation.equals("WordDictionary")){

                trieObj = new AddAndSearchWord();
                index++;

            }else if(operation.equals("addWord")){

                if(index>0 && index<=3) {
                    String[] arrInputWordList = words[index];
                    for (String word : arrInputWordList) {
                        trieObj.addWord(word);
                    }
                    index++;
                }

            }else if(operation.equals("search")){

                if(index>3 && index<=7) {
                    String[] arrInputWordList = words[index];
                    for (String word : arrInputWordList) {
                        boolean result = trieObj.search(word);
                        if (result) {
                            System.out.println(word + " present in the trie");
                        } else {
                            System.out.println(word + " not present in the trie");
                        }
                    }
                    index++;
                }
            }
        }
    }
}
