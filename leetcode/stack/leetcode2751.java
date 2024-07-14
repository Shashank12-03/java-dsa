package stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;

public class leetcode2751 {
    public static void main(String[] args) {
        System.out.println(survivedRobotsHealths(new int[]{3,5,2,6}, new int[]{10,10,15,12},"RLRL"));
    }
    static class Pair {
        int originalPos;
        int pos;
        int health;
        char dir;
        
        Pair(int originalPos, int pos, int health, char dir) {
            this.originalPos = originalPos;
            this.pos = pos;
            this.health = health;
            this.dir = dir;
        }
    }
    
    public static List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int n = positions.length;
        Pair[] robots = new Pair[n];
        
        for (int i = 0; i < n; i++) {
            robots[i] = new Pair(i, positions[i], healths[i], directions.charAt(i));
        }
        
        Arrays.sort(robots, Comparator.comparingInt(r -> r.pos));
        Stack<Pair> stack = new Stack<>();
        
        for (int i = 0; i < n; i++) {
            Pair curr = robots[i];
            if (curr.dir == 'R') {
                stack.push(curr);
            } else {
                while (!stack.isEmpty() && stack.peek().dir == 'R') {
                    Pair top = stack.pop();
                    if (top.health > curr.health) {
                        top.health--;
                        stack.push(top);
                        curr = null;
                        break;
                    } else if (top.health < curr.health) {
                        curr.health--;
                    } else {
                        curr = null;
                        break;
                    }
                }
                if (curr != null) {
                    stack.push(curr);
                }
            }
        }
        
        List<Pair> survivors = new ArrayList<>(stack);
        survivors.sort(Comparator.comparingInt(r -> r.originalPos));
        
        List<Integer> result = new ArrayList<>();
        for (Pair p : survivors) {
            result.add(p.health);
        }
        
        return result;
    }
}