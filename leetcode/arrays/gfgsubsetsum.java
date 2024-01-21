package arrays;

import java.util.ArrayList;

public class gfgsubsetsum {
    public static void main(String[] args) {
        ArrayList<Integer> arr=new ArrayList<>();
        arr.add(2);
        arr.add(1);
        arr.add(5);
        // arr.add();
        // arr.add();
        System.out.println(subsetSums(arr, 3));
    }
    static ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int N){
        // code here
        ArrayList<Integer> ans= new ArrayList<>();
        subsetSums(0,arr, N,ans,0);
        return ans;
    }
    private static void subsetSums(int index, ArrayList<Integer> arr, int n, ArrayList<Integer> ans,int sum) {
        if(index==n){
            ans.add(sum);
            return;
        }
        subsetSums(index+1, arr, n, ans, sum+arr.get(index));
        subsetSums(index+1, arr, n, ans, sum);
    }
}
