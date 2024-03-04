package greedy;

import java.util.Arrays;


public class leetcode948 {
    public static void main(String[] args) {
        System.out.println(bagOfTokensScore(new int[]{100,200,300,400}, 200));
    }
    public static int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        int res=0;
        int score=0;
        int left=0;
        int right=tokens.length-1;
        while (left<=right) {
            if (power>=tokens[left]) {
                power-=tokens[left];
                left++;
                score++;
                res=Math.max(res,score);
            }
            else if (score>0) {
                power+=tokens[right];
                score--;
                right--;
            }
            else{
                break;
            }
        }
        return res;
    }
}
