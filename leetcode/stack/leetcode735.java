package stack;


import java.util.Arrays;
import java.util.Stack;

public class leetcode735 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(asteroidCollision(new int[]{5,10,-5})));
    }
    public static int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> collision = new Stack<>();
        for (int astroid: asteroids) {
            while (!collision.isEmpty() && astroid<0 && collision.peek()>0) {
                int diff = astroid + collision.peek();
                if (diff>0){
                    astroid = 0;
                }
                else if (diff<0){
                    collision.pop();
                }else{
                    astroid = 0;
                    collision.pop();
                }
            }
            if (astroid!=0){
                collision.add(astroid);
            }
        }
        int[] ans = new int[collision.size()];
        for (int i = ans.length; i >=0; i--) {
            ans[i] = collision.peek();
            collision.pop();
        }
        return ans;
    }
    
}
