package greedy;

import java.util.HashMap;
import java.util.Map;

public class leetcode1128 {

    class Pair{
        int first;
        int second;
        Pair(int first, int second){
            this.first = first;
            this.second = second;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Pair pair = (Pair) obj;
            return first == pair.first && second == pair.second;
        }

        // Override hashCode to ensure consistent hashing
        @Override
        public int hashCode() {
            return 31 * Math.min(first, second) + Math.max(first, second);
        }
    }
    public int numEquivDominoPairs(int[][] dominoes) {
        Map<Pair, Integer> map = new HashMap<>();
        int count = 0;
        for(int[] domino:dominoes){
            Pair pair = new Pair(Math.min(domino[0], domino[1]), Math.max(domino[0], domino[1]));

            // Count the number of equivalent pairs
            count += map.getOrDefault(pair, 0);

            // Update the count of the current pair
            map.put(pair, map.getOrDefault(pair, 0) + 1);
        }
        return count;
    }
    public static void main(String[] args) {
        int[][] dominoes = {{1, 2}, {2, 1}, {3, 4}, {5, 6}};
        leetcode1128 solution = new leetcode1128();
        int result = solution.numEquivDominoPairs(dominoes);
        System.out.println("Number of equivalent domino pairs: " + result);
    }
}
