package arrays;

import java.util.ArrayList;

public class leaders {
    public static void main(String[] args) {
        System.out.println(leaderArray(6, new int[]{16,17,4,3,5,2}));
    }
    public static ArrayList<Integer> leaderArray(int n, int arr[]) {
        ArrayList<Integer> ans = new ArrayList<>();
        int currentmax =Integer.MIN_VALUE;
        for(int i = n;i>0;i--){
            if(arr[i-1]>=currentmax){
                ans.add(arr[i-1]);
                currentmax = arr[i-1]; 
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=ans.size()-1;i>=0;i--){
            list.add(ans.get(i));
        }
        return list;
    }

}
