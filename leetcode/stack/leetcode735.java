

import java.util.Arrays;
import java.util.Stack;

public class leetcode735 {
    public static void main(String[] args) {
        //System.out.println(Arrays.toString(asteroidCollision(new int[]{-2,-1,1,2})));
    }
    // public static int[] asteroidCollision(int[] asteroids) {
    //     Stack<Integer> collision = new Stack<>();
    //     // collision.push(asteroids[0]);
    //     // for(int i=1;i<asteroids.length;i++){
    //     //     if(!collision.isEmpty() && Math.abs(asteroids[i])==collision.peek() && !hasSameSignAsPeek(collision, asteroids[i])){
    //     //         collision.pop();
    //     //     }
    //     //     else{
    //     //         while(!collision.isEmpty() && Math.abs(asteroids[i])>collision.peek() && !hasSameSignAsPeek(collision, asteroids[i])){
    //     //             collision.pop();
    //     //             //collision.push(asteroids[i]);
    //     //         }
    //     //         if(!collision.isEmpty() && Math.abs(asteroids[i])>collision.peek()){
    //     //             collision.push(asteroids[i]);
    //     //         }
    //     //     }
    //     // }
    //     // int[] ans= new int[collision.size()];
    //     // for(int i=collision.size()-1;i>=0;i--){
    //     //     ans[i]=collision.pop();
    //     // }
    //     // return ans;
    // }
    // // public static boolean hasSameSignAsPeek(Stack<Integer> stack, int incomingElement) {
    //     // Function to check if the incoming element has the same sign as the top element of the stack.
    //     if (stack.isEmpty()) {
    //         // The stack is empty, so there's no top element to compare with.
    //         return true;
    //     }

    //     int topElement = stack.peek();
    //     return getSign(topElement) == getSign(incomingElement);
    // }
    // public static int getSign(int num) {
    //     if (num > 0) {
    //         return 1;
    //     } else if (num < 0) {
    //         return -1;
    //     } else {
    //         return 0;
    //     }
    // }
}
