package blind75.tree.trie;

public class TrieNode {
     final int data = 26 ;
     TrieNode[] children;
     boolean endNode;

    public TrieNode(){
     this.children = new TrieNode[data];
    }

    public TrieNode(TrieNode[] children, boolean endNode) {
        this.children = children;
        this.endNode = endNode;
    }

    public boolean isEndNode() {
        return endNode;
    }

    public void setEndNode(boolean endNode) {
        this.endNode = endNode;
    }

    public boolean containsKey(char c){
        if(children[c-'a']!=null){
            return true;
        }
        return false;
    }

    public TrieNode get(char c){
        return children[c-'a'];
    }

    public TrieNode put(char c, TrieNode insert){
        children[c-'a'] = insert;
        return insert;
    }
}
