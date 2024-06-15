package greedy;

import java.util.HashMap;
import java.util.Map;

public class leetcode846 {
    public static void main(String[] args) {
        System.out.println(isNStraightHand(new int[] { 1, 2, 3, 6, 2, 3, 4, 7, 8 }, 3));
    }

    public static boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) {
            return false;
        }
        Map<Integer, Integer> map = new HashMap<>(); 
        for(int i=0; i<hand.length;i++){
            map.put(hand[i],map.getOrDefault(hand[i],0)+1);
        }                                          
        for (int key: map.keySet()){
            while(map.get(key)>0){
                
            }
        }

        return true;
    }
}
// Initial Check: If the total number of cards in hand is not a multiple of
// groupSize, return false immediately as it is impossible to partition the
// cards into groups of the desired size.
// Frequency Count: Use a hashmap to count the occurrences of each card.
// Sorting: Extract the unique cards from the hashmap and sort them.
// Group Formation: Iterate through the sorted unique cards. For each card, if
// its frequency is greater than zero, attempt to form a group starting from
// this card and extending for groupSize consecutive cards. If at any point, a
// required card is not available in the needed quantity, return false.
// Frequency Update: Decrease the frequency of cards used to form each group.