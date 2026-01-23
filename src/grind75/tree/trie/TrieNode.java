package grind75.tree.trie;

public class TrieNode {

    final int length = 26;
    TrieNode[] children;
    boolean endWord;

    public TrieNode(){
        this.children = new TrieNode[length];
    }
    public boolean isEndWord() {
        return endWord;
    }

    public void setEndWord(boolean endWord) {
        this.endWord = endWord;
    }

    public boolean containsKey(char c){
        if(this.children[c-'a']!=null){
            return true;
        }
        return false;
    }

    public TrieNode get(char c){
       return this.children[c-'a'];
    }

}
