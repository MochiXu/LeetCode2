package top150;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ladderLength_127 {
    public boolean compare(String a, String b) {
        if (a.length() != b.length()) {
            return false;
        }
        int count = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                count++;
            }
        }
        return count == 1;
    }

    class Item {
        public String content;
        public int step;

        public Item(String content, int step) {
            this.content = content;
            this.step = step;
        }
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (beginWord.equals(endWord)){
            return 1;
        }
        LinkedList<Item> list = new LinkedList<>();
        list.addFirst(new Item(beginWord, 1));
        boolean[] visited = new boolean[wordList.size()];
        while (list.size() != 0) {
            Item left = list.pollFirst();
            if (left.content.equals(endWord)){
                return left.step;
            }
            if (compare(left.content,endWord)){
                return left.step+1;
            }
            for (int i = 0; i < wordList.size(); i++) {
                if (compare(left.content, wordList.get(i))) {
                    if (wordList.get(i).equals(endWord)) {
                        return left.step + 1;
                    } else if (!visited[i]) {
                        list.addLast(new Item(wordList.get(i), left.step + 1));
                        visited[i] = true;
                    }
                }
            }
        }
        return 0;
    }
}
