package binarysearch;

import java.util.Arrays;

public class aggressiveCows {
    public static void main(String[] args) {
        System.out.println(aggressivecows(new int[]{1,2,8,4,9}, 3));
    }
    public static int aggressivecows(int[] store , int cows){
        Arrays.sort(store);
        int ans = 1;
        int start = 1;
        int end = store[store.length-1]-store[0];
        while (start<=end) {
            int mid = start + (end-start)/2;
            if(canstorecows(store,mid,cows)){
                ans = mid;
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        return ans;
    }
    private static boolean canstorecows(int[] store, int mid, int cows) {
        int cow = 1;
        int last = store[0];
        for (int i = 1; i < store.length; i++) {
            if (store[i]-last>=mid){
                cow++;
                last = store[i];
            }
        }
        return cow>=cows;
    }
}
