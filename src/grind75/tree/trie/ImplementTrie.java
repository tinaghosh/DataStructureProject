package grind75.tree.trie;

public class ImplementTrie {

    TrieNode root;

    public ImplementTrie(){
      root = new TrieNode();
    }

    public void insert(String word){

        TrieNode currentNode = root;
        char[] wordToCharArray = word.toCharArray();
        for(char c: wordToCharArray){
            if(!currentNode.containsKey(c)){
                currentNode.children[c-'a'] = new TrieNode();
            }
            currentNode = currentNode.get(c);
        }
        currentNode.setEndWord(true);
    }

    public boolean search(String word){

        TrieNode node = searchPrefix(word);
        if(node!=null && node.isEndWord()){
            return true;
        }
        return false;
    }

    public boolean startsWith(String word){

        TrieNode node = searchPrefix(word);
        if(node!=null){
            return true;
        }
        return false;
    }

    public TrieNode searchPrefix(String word){

        TrieNode currentNode = root;

        char[] wordToCharArray = word.toCharArray();
        for(char c : wordToCharArray){
            if(currentNode.containsKey(c)){
               currentNode = currentNode.get(c);
            }else{
                return null;
            }
        }
        return currentNode;
    }

    public static void main(String[] args){

        String[] operations = {"Trie", "insert", "search", "search", "startsWith", "insert", "search"};

        String[][] words = {{}, {"apple"}, {"apple"}, {"app"}, {"app"}, {"app"}, {"app"}};

        ImplementTrie trieObj = null;
        int index = 0;

        for(String operation : operations){
            System.out.println("Operation-> "+operation);
            if(operation.equals("Trie")){

                trieObj = new ImplementTrie();
                index++;

            }else if(operation.equals("insert")){

                if(index==1 || index==5 ) {
                    String[] arrInputWordList = words[index];
                    for (String word : arrInputWordList) {
                        trieObj.insert(word);
                    }
                    index++;
                }

            }else if(operation.equals("search")){

                if(index==2 || index==3 || index==6 ) {
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
            }else if(operation.equals("startsWith")){

                if(index==4) {
                    String[] arrInputWordList = words[index];
                    for (String word : arrInputWordList) {
                        boolean result = trieObj.startsWith(word);
                        if (result) {
                            System.out.println("Word starts with "+word + " present in the trie");
                        } else {
                            System.out.println("Word starts with "+ word + " not present in the trie");
                        }
                    }
                    index++;
                }
            }
        }
    }
}
