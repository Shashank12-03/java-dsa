package string;

import java.util.*;

public class leetcode592 {
    public static void main(String[] args) {
        leetcode592 sol = new leetcode592();
        System.out.println(sol.fractionAddition("1/3-1/2"));
    }
    public String fractionAddition(String expression) {
        String[] nums = expression.split("/|(?=[-+])");
        Queue<String> queue = new LinkedList<>();
        for (String num : nums) {
            queue.offer(num); // Adds the element to the queue
        }
        // queue.poll();
        // Print the queue
        System.out.println(queue);
        // [-1, 2, +1, 2, +1, 3]
        while (queue.size()!=2) {
            int num1 = Integer.parseInt(queue.poll());
            int deno1 =0;
            int num2 =0;
            int deno2 =0;
            if(!queue.isEmpty()){
                deno1 = Integer.parseInt(queue.poll());
            }
            if(!queue.isEmpty()){
                num2 = Integer.parseInt(queue.poll());
            }
            if(!queue.isEmpty()){
                deno2 = Integer.parseInt(queue.poll());
            }
            int num = 0;
            int deno = 0 ;
            if(deno1==deno2){
                num = num1+num2;
                deno = deno1;
            }else{
                num = (num1*deno2)+(num2*deno1);
                deno = deno1*deno2;
            }
            queue.add(String.valueOf(num));
            queue.add(String.valueOf(deno));
            
        }
        int numerator = Integer.parseInt(queue.poll());
        int denominator = Integer.parseInt(queue.poll());
        // System.out.println(queue);
        int gcd = findGCD(numerator, denominator);
        numerator /= gcd;
        denominator /= gcd;
        // System.out.println(Arrays.toString(nums));
        if (denominator<0){
            denominator = -1*denominator;
            String ans = "-" + numerator+ "/" + denominator;
            return ans;
        }
        String ans = numerator+ "/" + denominator;
        return ans;
    }
    private int findGCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
