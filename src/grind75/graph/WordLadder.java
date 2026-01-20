package grind75.graph;

import java.util.*;

public class WordLadder {

    public int minWordLadderPathLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.stream().anyMatch(e -> e.matches(endWord))) {
            System.out.println("The endWord " + endWord + " is not in wordList, " +
                    "therefore there is no valid transformation sequence");
        }

        Map<String, Boolean> visited = new HashMap<>();
        visited.put(beginWord, true);

        Map<String, List<String>> allCombWord = new HashMap<>();

        wordList.forEach(word -> {
            for (int i = 0; i < word.length(); i++) {
                String sPattern = word.substring(0, i) + "*" + word.substring(i + 1, word.length());
                List<String> wordListBasedOnPattern;

                if (allCombWord.containsKey(sPattern)) {
                    wordListBasedOnPattern = allCombWord.get(sPattern);
                }else{
                    wordListBasedOnPattern = new ArrayList<>();
                }
                wordListBasedOnPattern.add(word);
                allCombWord.put(sPattern, wordListBasedOnPattern);
            }
        });
        allCombWord.entrySet().forEach(e -> System.out.println(e.getKey() + " ----> " + e.getValue()));

        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(beginWord, 1));

        while (!queue.isEmpty()) {

            Pair node = queue.poll();
            String lastWord = node.getKey();
            int level = node.getValue();

            for (int i = 0; i < lastWord.length(); i++) {
                String nodePattern = lastWord.substring(0, i) + "*" + lastWord.substring(i + 1, lastWord.length());
                if (allCombWord.containsKey(nodePattern)) {
                    List<String> getList = allCombWord.get(nodePattern);

                    for (String ladderNextWord :getList ) {
                        if (ladderNextWord.equals(endWord)) {
                            return level + 1;
                        } else {
                            if (!visited.containsKey(ladderNextWord)) {
                                visited.put(ladderNextWord, true);
                                queue.add(new Pair(ladderNextWord, level + 1));
                            }
                        }
                    }
                }
            }
            visited.entrySet().forEach(e-> System.out.println(e.getKey()+"--->"+e.getValue()));
            System.out.println();
        }
        return 0;
    }

    class Pair {
        String key;
        Integer value;

        public Pair() {

        }

        public Pair(String key, Integer value) {
            this.key = key;
            this.value = value;
        }

        public String getKey() {
            return key;
        }

        public Integer getValue() {
            return value;
        }
    }

    public static void main(String[] args) {

        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = List.of("hot", "dot", "dog", "lot", "log", "cog");

        WordLadder obj = new WordLadder();
        int result = obj.minWordLadderPathLength(beginWord, endWord, wordList);

        System.out.println("Shortest transformation sequence is containing " + result + " words long");
    }
}
