package Trees;

import java.util.*;
import Trees.TreeNode;

public class leetcode127 {
    public static void main(String[] args) {

    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        int length = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            length++;
            for (int i = 0; i < size; i++) {
                String current = queue.poll();
                for (int j = 0; j < current.length(); j++) {
                    char[] temp = current.toCharArray();
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        temp[j] = ch;
                        String newword = new String(temp);
                        if (newword.equals(endWord)) {
                            return length + 1;
                        }
                        if (wordList.contains(newword) && !visited.contains(newword)) {
                            queue.offer(newword);
                            visited.add(newword);
                        }
                    }
                }
            }
        }
        return 0;
    }
}
