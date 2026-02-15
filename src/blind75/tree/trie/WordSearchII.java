package blind75.tree.trie;

import java.util.ArrayList;
import java.util.List;

public class WordSearchII{

    LocalTrieNode root;
    List<String> output;

    public WordSearchII(){
        root = new LocalTrieNode();
    }

    public List<String> wordSearchFromGrid(char[][] board, String[] words){

        output = new ArrayList<>();
        int rowLength = board.length;
        int colLength = board[0].length;

        insertTrieNode(words);

        for(int i=0;i<rowLength;i++){
            for(int j=0;j<colLength;j++){
                char c = board[i][j];
                if(root.containsKey(c)){
                    findWords(board,i,j,root,rowLength,colLength);
                }
            }
        }
      return  output;
    }

    public void findWords(char[][] board, int row,int col,LocalTrieNode trie, int rowLength,int colLength){

        int[][] direction = {{0,1},{1,0},{-1,0},{0,-1}};

        if(row<0 || row>=rowLength || col<0 || col>=colLength){
            return;
        }
        if(board[row][col]=='$'){
            return;
        }
        if(!trie.containsKey(board[row][col])){
            return;
        }
        LocalTrieNode current = trie.get(board[row][col]);

        if(current.isEndNode()){
            output.add(current.word);
            current.setEndNode(false);
        }
        char temp =  board[row][col];
        board[row][col]='$';

        for(int[] d: direction){
            int newRow = row + d[0];
            int newCol = col + d[1];
            findWords(board,newRow,newCol,current,rowLength,colLength);
        }
      board[row][col] = temp;
    }

    public void insertTrieNode(String[] words){

        for(String word: words){
            char[] wordToCharArray = word.toCharArray();
            LocalTrieNode current = root;

            for(char c : wordToCharArray){
                if(!current.containsKey(c)){
                    current.put(c,new LocalTrieNode());
                }
                current = current.get(c);
            }
           current.setEndNode(true);
           current.setWord(word);
        }
    }

    public static void main(String[] args){
        char[][] board = {{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}};
        String[] words = {"oath","pea","eat","rain"};
        WordSearchII obj = new WordSearchII();
        List<String> result = obj.wordSearchFromGrid(board,words);
        result.forEach(e-> System.out.print(e+" "));
    }

private static class LocalTrieNode{

        String word;
        final int length = 26 ;
        LocalTrieNode[] children;
        boolean endNode;

        LocalTrieNode(){
            this.word = "";
            this.children = new LocalTrieNode[length];
            this.endNode = false;
        }

        public boolean isEndNode() {
            return endNode;
        }

        public void setEndNode(boolean endNode) {
            this.endNode = endNode;
        }

        public String getWord() {
            return word;
        }

        public void setWord(String word) {
            this.word = word;
        }

        public boolean containsKey(char c){
            if(children[c-'a']!=null){
                return true;
            }
            return false;
        }

        public LocalTrieNode get(char c){
            return children[c-'a'];
        }

        public LocalTrieNode put(char c, LocalTrieNode insert){
            children[c-'a'] = insert;
            return insert;
        }
    }
}
