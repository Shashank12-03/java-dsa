package slidingwindow;

// import java.util.*;

public class fruitBowl {
    public static void main(String[] args) {
        System.out.println(totalFruits(new Integer[]{3, 3, 3, 1, 3, 2, 1, 1, 1, 1, 2}));
    }
    public static int totalFruits(Integer[] arr) {
        int maxFruit = 0;
        for (int fruit : arr) {
            if (fruit > maxFruit) {
                maxFruit = fruit;
            }
        }

        int left,right,maxLen,fruit;
        left=right=maxLen=fruit=0;
        int[] freq = new int[maxFruit+1];
        // 3 3 3 1 2 1 1 2
        // 0 1 1 3
        while(right<arr.length){
            if(freq[arr[right]]==0){
                fruit++;
            }
            freq[arr[right]]++;
            while(fruit>2){
                if(freq[arr[left]]!=0){
                    freq[arr[left]]--;
                }
                if(freq[arr[left]]==0){
                    fruit--;   
                }
                left++;
            }
            maxLen = Math.max(maxLen,right-left+1); //3 4 
            right++;
        }
        return maxLen;
        // int max = Integer.MIN_VALUE;
        // for(int i =0;i<arr.length;i++){
        //     max = Math.max(max,arr[i]);
        // }
        // int[] store = new int[max+1];
        // for(int i =0;i<arr.length;i++){
        //     store[arr[i]]++;
        // }
        // int firstMax = 0;
        // max = 0;
        // int lessMax = 0;
        // int secondMax = 0;
        // System.out.println(Arrays.toString(store));
        // for(int i =0;i<store.length;i++){
        //     if(max<store[i]){
        //         lessMax = max;
        //         max = arr[i];
        //         secondMax = firstMax;
        //         firstMax = i;
        //     }
        // }
        // int ans = 0;
        // for(int i = 0;i<arr.length;i++){
        //     if(arr[i]==firstMax || arr[i]==secondMax){
        //         ans++;
        //     }
        // }
        // return ans;
    }
}
