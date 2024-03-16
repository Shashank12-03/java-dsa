package arrays;

import java.util.HashMap;


public class leetcode525 {
    public static void main(String[] args) {
        System.out.println(findMaxLength(new int[]{0,1}));
    }
    public static int findMaxLength(int[] nums) {
        HashMap<Integer,Integer> sum=new HashMap<>();

        int currentSum=0;
        int maxLength=0;
        sum.put(0,0);
        for (int i = 0; i < nums.length; i++) {
            
            if (nums[i]==1) {
                currentSum++;
                if (sum.containsKey(currentSum)) {
                    int ind=sum.get(currentSum);
                    maxLength=Math.max(maxLength,i-ind+1);
                }
                sum.put(currentSum,i);
            }
            else{
                currentSum--;
                if (sum.containsKey(currentSum)) {
                    int ind=sum.get(currentSum);
                    maxLength=Math.max(maxLength,i-ind);
                }
                sum.put(currentSum,i);
            }

        }
        return maxLength;
    }
}
