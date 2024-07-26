package Trees;

import java.util.*;

public class leetcode127 {
    public static void main(String[] args) {

    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        if (!wordList.contains(endWord)) {
            return 0;
        }
        Set<String> store = new HashSet<>();
        for (String string : wordList) {
            store.add(string);
        }

        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(beginWord, 1));
        while (!queue.isEmpty()) {
            String word = queue.peek().str;
            int step = queue.peek().cnt;
            queue.remove();
            if (word.equals(endWord)){
                return step;
            }
            for (int j = 0; j < word.length(); j++) {
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    char[] temp = word.toCharArray();
                    temp[j] = ch;
                    String newword = new String(temp);
                    if (store.contains(newword)==true) {
                        store.remove(newword);
                        queue.add(new Pair(newword, step+1));
                    }
                }
            }
        }
        return 0;
    }
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> ans = new ArrayList<>();
        List<String> ladder = new ArrayList<>();

        if (!wordList.contains(endWord)) {
            return ans;
        }
        Set<String> store = new HashSet<>();
        for (String string : wordList) {
            store.add(string);
        }

        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(beginWord, 1));
        ladder.add(beginWord);
        while (!queue.isEmpty()) {
            String word = queue.peek().str;
            int step = queue.peek().cnt;
            queue.remove();
            if (word.equals(endWord)){
                ans.add(new ArrayList<>(ladder));
                return ans;
            }
            for (int j = 0; j < word.length(); j++) {
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    char[] temp = word.toCharArray();
                    temp[j] = ch;
                    String newword = new String(temp);
                    if (store.contains(newword)==true) {
                        ladder.add(newword);
                        store.remove(newword);
                        queue.add(new Pair(newword, step+1));
                    }
                }
            }
        }
        return ans;
    }
}
class Pair{
    String str;
    int cnt;
    Pair(String str,int cnt){
        this.str = str;
        this.cnt = cnt;
    }
}
